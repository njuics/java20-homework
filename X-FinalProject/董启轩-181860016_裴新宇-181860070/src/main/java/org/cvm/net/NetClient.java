package org.cvm.net;


import javafx.application.Platform;
import org.cvm.view.ServerView;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

import static org.cvm.Framework.playView;


public class NetClient {
    private int UDP_PORT;
    private String serverIP;
    private int serverUDPPort;
    private DatagramSocket ds = null;


    public NetClient(){
        try {
            this.UDP_PORT = getRandomUDPPort();
        }catch (Exception e){
            System.out.println("netClient error");
        }
    }
    public void connect(String ip){
        serverIP = ip;
        Socket s = null;
        try {
            ds = new DatagramSocket(UDP_PORT);
            try {
                s = new Socket(ip, ServerView.TCP_PORT);
            }catch (Exception e1){
                System.out.println("Connect error");
                System.exit(0);
            }
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(UDP_PORT);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            int id = dis.readInt();
            this.serverUDPPort = dis.readInt();
            if (id == 0) {
                Platform.setImplicitExit(false);
                Platform.runLater(() -> {
                    playView.set_team(1);
                });
                System.out.println("Huluwa! id = " + id);
            }
            else {
                Platform.setImplicitExit(false);
                Platform.runLater(() -> {
                    playView.set_team(2);
                });
                System.out.println("Monster! id = " + id);
            }
            System.out.println("connect to server successfully...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        new Thread(new UDPThread()).start();
    }
    private int getRandomUDPPort(){
        return 55558 + (int)(Math.random() * 9000);
    }

    public void send(Msg msg){
        msg.send(ds, serverIP, serverUDPPort);
    }

    public class UDPThread implements Runnable{

        byte[] buf = new byte[1024];

        @Override
        public void run() {
            while(null != ds){
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try{
                    ds.receive(dp);
                    parse(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void parse(DatagramPacket dp) {
            ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, dp.getLength());
            DataInputStream dis = new DataInputStream(bais);
            int msgType = 0;
            try {
                msgType = dis.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (msgType){
                case Msg.S_MOVE_MSG :
                    S_MOVE_MSG msg1 = new S_MOVE_MSG();
                    msg1.parse(dis);
                    break;
                case Msg.BLOOD_MSG:
                    BLOOD_MSG msg2 = new BLOOD_MSG();
                    msg2.parse(dis);
                    break;
                case Msg.INFORM_MSG:
                    INFORM_MSG msg3 = new INFORM_MSG();
                    msg3.parse(dis);
                    break;
                case Msg.START_MSG:
                    START_MSG msg4 = new START_MSG();
                    msg4.parse(dis);
                    break;
                case Msg.DEAD_MSG:
                    DEAD_MSG msg5 = new DEAD_MSG();
                    msg5.parse(dis);
                    break;
            }
        }
    }
}
