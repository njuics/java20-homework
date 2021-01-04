package nju.zjl.cvs.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

import nju.zjl.cvs.game.Operation;



public class GameServer implements Runnable {
    public GameServer(Socket player1, Socket player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void run(){
        new Thread(new Receiver(player1)).start();
        new Thread(new Receiver(player2)).start();
        
        try(
            ObjectOutputStream objout1 = new ObjectOutputStream(player1.getOutputStream());
            ObjectOutputStream objout2 = new ObjectOutputStream(player2.getOutputStream());
        ){
            long lastSend = -1;
            while(exit < 2){
                if(System.currentTimeMillis() - lastSend < 100){
                    continue;
                }
                lastSend = System.currentTimeMillis();

                AppPacket pkt;
                synchronized(lock){
                    pkt = new AppPacket(0, logicFrame, operationList.toArray(new Operation[0]));
                    operationList.clear();
                }
                objout1.writeObject(pkt);
                objout2.writeObject(pkt);

                logicFrame++;
            }
        }catch(IOException exception){
            System.err.println("an error occured when send or build packet");
            exception.printStackTrace();
        }finally{
            try{
                System.out.println("game over");
                player1.close();
                player2.close();
            }catch(IOException exception2){
                System.err.println("an error occured when close socket");
                exception2.printStackTrace();
            }
        }
    }

    private Socket player1;
    private Socket player2;

    private final Object lock = new Object();
    private int logicFrame = 0;
    private LinkedList<Operation> operationList = new LinkedList<>();
    private int exit = 0;

    class Receiver implements Runnable {
        Receiver(Socket client){
            this.client = client;
        }

        @Override
        public void run(){
            try{
                ObjectInputStream objin = new ObjectInputStream(client.getInputStream());
                boolean terminate = false;
                while(!terminate){
                    AppPacket pkt = (AppPacket)objin.readObject();
                    switch(pkt.type){
                        case 1:
                            synchronized(lock){
                                operationList.add(pkt.payload[0]);
                            }
                            break;
                        case 2:
                            synchronized(lock){
                                exit++;
                            }
                            System.out.println("player exit");
                            terminate = true;
                            break;
                        default:
                            break;
                    }
                }
            }catch(IOException | ClassNotFoundException exception){
                System.err.println("an error occured when receive or read packet");
                exception.printStackTrace();
                synchronized(lock){
                    exit++;
                }
            }
        }

        private Socket client;
    }
    
}
