package org.cvm.view;

import javafx.scene.control.Label;
import org.cvm.app.View;
import org.cvm.net.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ServerView extends View{

    public static int ID = 0;
    public static final int TCP_PORT = 5555;
    public static final int UDP_PORT = 5556;
    private List<Client> clients = new ArrayList<>();
    private DatagramSocket ds = null;

    @Override
    public void onLaunch() {
        Label label = new Label("正在等待连接...");
        getChildren().add(label);
    }

    @Override
    public void onEnter() {
        new Thread(new UDPThread()).start();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(TCP_PORT);
            System.out.println("Server has started...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(ID<=1){
            Socket s = null;
            try {
                s = ss.accept();
                if (ID == 0) {
                    System.out.println("One client has connected...");
                }
                else {
                    System.out.println("Another client has connected...");
                }
                DataInputStream dis = new DataInputStream(s.getInputStream());
                int UDP_PORT = dis.readInt();
                Client client = new Client(s.getInetAddress().getHostAddress(), UDP_PORT, ID);
                clients.add(client);

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(ID++);
                dos.writeInt(ServerView.UDP_PORT);
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(s != null) s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        START_MSG start_msg = new START_MSG(1,false);
        send(start_msg);
    }

    public void send(Msg msg){
        send(msg, 1);
        send(msg, 2);
    }

    public void send(Msg msg, int team){
        msg.send(ds, clients.get(team-1).IP, clients.get(team-1).UDP_PORT);
    }

    private class UDPThread implements Runnable{

        byte[] buf = new byte[1024];

        @Override
        public void run() {
            try{
                ds = new DatagramSocket(ServerView.UDP_PORT);
            }catch (SocketException e) {
                e.printStackTrace();
            }

            while (null != ds){
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try {
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
                case Msg.MOVE_MSG :
                    MOVE_MSG msg1 = new MOVE_MSG();
                    msg1.parse(dis);
                    break;
                case Msg.ATTACK_MSG:
                    ATTACK_MSG msg2 = new ATTACK_MSG();
                    msg2.parse(dis);
                    break;
                case Msg.FINISH_MSG:
                    FINISH_MSG msg3 = new FINISH_MSG();
                    msg3.parse(dis);
                    break;
                default:
                    System.out.println("TODO");
            }
        }
    }


    public class Client{
        String IP;
        int UDP_PORT;
        int id;

        public Client(String ipAddr, int UDP_PORT, int id) {
            this.IP = ipAddr;
            this.UDP_PORT = UDP_PORT;
            this.id = id;
        }
    }
}
