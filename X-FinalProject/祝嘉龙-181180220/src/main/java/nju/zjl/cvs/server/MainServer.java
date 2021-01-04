package nju.zjl.cvs.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer {
    public static void main(String[] args){
        ServerSocket server;
        try{
            server = new ServerSocket(23456);
        }catch(IOException exception){
            System.err.println("an error occured when create Serversocket");
            exception.printStackTrace();
            return;
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        Socket client1 = null;
        Socket client2 = null;

        while(true)try{
            client1 = server.accept();
            System.out.println("player1 come");
            DataOutputStream out1 = new DataOutputStream(client1.getOutputStream());
            out1.writeInt(0);

            client2 = server.accept();
            System.out.println("player2 come");
            DataOutputStream out2 = new DataOutputStream(client2.getOutputStream());
            out2.writeInt(0);

            boolean c = new Random().nextBoolean();
            out1.writeBoolean(c);
            out2.writeBoolean(!c);

            System.out.println("game begin");
            exec.execute(new GameServer(client1, client2));
        }catch(IOException exception){
            System.err.println("an error occured when establish game");
            exception.printStackTrace();
            try{
                if(client1 != null){
                    client1.close();
                    client1 = null;
                }
                if(client2 != null){
                    client2.close();
                    client2 = null;
                }
            }catch(IOException exception2){
                System.err.println("an error occured when close TCP connection");
                exception2.printStackTrace();
            }
        }
    }
}
