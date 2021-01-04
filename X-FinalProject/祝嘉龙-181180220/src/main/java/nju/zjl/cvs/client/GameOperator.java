package nju.zjl.cvs.client;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

import nju.zjl.cvs.game.Constants.Camp;
import nju.zjl.cvs.game.Operation;
import nju.zjl.cvs.game.Operator;
import nju.zjl.cvs.server.AppPacket;



public class GameOperator implements Operator, Runnable{
    public void sendOperation(Operation op){
        try{
            Operation[] temp = new Operation[1];
            temp[0] = op;
            AppPacket pkt = new AppPacket(1, -1, temp);
            objout.writeObject(pkt);
        }catch(IOException exception){
            System.err.println("an error occurred when send packet");
            exception.printStackTrace();
        }
    }

    @Override
    public Operation[] getLogicFrames(int logicFrame){
        synchronized(lock){
            if(logicFrame >= operationsList.size()){
                return null;
            }
            else{
                return operationsList.get(logicFrame);
            }
        }
    }

    @Override
    public void run(){
        try{  
            while(!gameOver){
                AppPacket pkt = (AppPacket)objin.readObject();
                synchronized(lock){
                    operationsList.add(pkt.logicFrame, pkt.payload);
                }
            }
        }catch(IOException | ClassNotFoundException exception){
            System.err.println("an error occurred when receive or read packet");
            exception.printStackTrace();
        }

        exitGame();
    }

    public void connect(String hostIp, int port, Consumer<Boolean> establish, Consumer<Camp> begin){
        byte[] ipBytes = new byte[4];
        String [] s = hostIp.split("\\.");
        for(int i = 0; i < 4; i++){
            ipBytes[i] = (byte)Integer.parseInt(s[i]);
        }

        try{
            InetAddress ip = InetAddress.getByAddress(ipBytes);
            client = new Socket(ip, port);
            DataInputStream in = new DataInputStream(client.getInputStream());

            if(in.readInt() != 0){
                establish.accept(false);
                return;
            }
            establish.accept(true);

            boolean c = in.readBoolean();
            objin = new ObjectInputStream(client.getInputStream());
            objout = new ObjectOutputStream(client.getOutputStream());
            begin.accept(c ? Camp.CALABASH : Camp.MONSTER);
        }catch(UnknownHostException exception){
            System.err.println("hostIp is illegal: " + hostIp);
            exception.printStackTrace();
            establish.accept(false);
        }catch(IOException exception){
            System.err.println("an error occurred when establish connection or game");
            exception.printStackTrace();
            establish.accept(false);
        }        
    }

    public void terminate(){
        gameOver = true;
    }

    public String saveRecord(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date time = new Date();
        String fileName = formatter.format(time) + ".record";
        File file = new File(fileName);
        try{
            file.createNewFile();
        }catch(IOException exception){
            exception.printStackTrace();
            return null;
        }

        try(
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream objout = new ObjectOutputStream(new BufferedOutputStream(fout));
        ){
            objout.writeInt(operationsList.size());
            for(Operation[] ops : operationsList){
                objout.writeObject(ops);
            }
        }catch(IOException exception){
            exception.printStackTrace();
            return null;
        }
        return fileName;
    }

    protected void exitGame(){
        try{
            AppPacket pkt = new AppPacket(2, -1, new Operation[0]);
            objout.writeObject(pkt);
        }catch(IOException exception){
            System.err.println("an error occurred when send packet");
            exception.printStackTrace();
        }

        try{
            client.close();
        }catch(IOException exception){
            System.err.println("an error occurred when close socket");
            exception.printStackTrace();
        }
    }

    protected Socket client = null;
    protected ObjectInputStream objin = null;
    protected ObjectOutputStream objout = null;

    private final Object lock = new Object();
    protected boolean gameOver = false;
    protected ArrayList<Operation[]> operationsList = new ArrayList<>(180);
}
