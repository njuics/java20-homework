package huluwa.Client;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

import huluwa.Protocol.DeadMsg;
import huluwa.Protocol.GameOverMsg;
import huluwa.Protocol.JoinMsg;
import huluwa.Protocol.MoveMsg;
import huluwa.Protocol.Msg;
import huluwa.Protocol.ShootMsg;
import huluwa.Server.PlayerServer;

public class NetClient {
    private PlayerClient pc;
    private int UDP_PORT; // 客户端UDP端口号
    private String serverIP; // 服务器IP
    private int serverUDPPort; // 服务器转发客户端UDP包的UDP端口
    private int GAME_OVER; // 服务器监听游戏结束的UDP端口
    private DatagramSocket ds = null; // 客户端UDP套接字

    public NetClient(PlayerClient pc){
        this.pc = pc;
        try{
            this.UDP_PORT = getRandomUDPPort();
        }catch (Exception e){
            System.exit(0);
        }
    }

    public void setUDP_PORT(int UDP_PORT){
        this.UDP_PORT = UDP_PORT;
    }

    /**
     * 与服务器进行TCP连接
     * @param ip server IP
     */
    public void connect(String ip){
        serverIP = ip;
        Socket s = null;
        try{
            ds = new DatagramSocket(UDP_PORT);  //创建UDP套接字
            try{
                s = new Socket(ip, PlayerServer.TCP_PORT);
            }catch(Exception e1){
                System.out.println("fail to create socket...");
                e1.printStackTrace();
            }
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(UDP_PORT); //向服务器发送自己的UDP端口号
            DataInputStream dis = new DataInputStream(s.getInputStream());
            int id = dis.readInt();  //获得自己的id号
            this.serverUDPPort = dis.readInt();   //获得服务器转发客户端消息的UDP端口号
            this.GAME_OVER = dis.readInt();//获得服务器监听坦克死亡的UDP端口
            pc.setGoodBad((id & 1) == 0 ? true : false);; //根据id分配阵营
            System.out.println("connect to server successfully...");
            if(pc.getGoodBad()){
                pc.goodReady = true;
                System.out.println("The good man is ready...");
            }else{
                pc.goodReady = true;
                System.out.println("The bad man is ready...");
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(s!=null)s.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        new Thread(new UDPThread()).start(); //开启客户端UDP线程, 向服务器发送或接收游戏数据

        JoinMsg msg = new JoinMsg(pc); //创建加入游戏消息
        send(msg);
    }

    /**
     * 客户端随机获取UDP端口号
     * @return
     */
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
                msgType = dis.readInt();//获得消息类型
            } catch (IOException e) {
                e.printStackTrace();
            }
            Msg msg = null;
            switch (msgType){//根据消息的类型调用对应消息的解析方法
                case Msg.PLAYER_JOIN_MSG :
                    msg = new JoinMsg(pc);
                    msg.parse(dis);
                    break;
                case  Msg.MOVE_MSG :
                    msg = new MoveMsg(pc);
                    msg.parse(dis);
                    break;
                case Msg.SHOOT_MSG:
                    //msg = new ShootMsg(pc);
                    msg.parse(dis);
                    break;
                case Msg.DEAD_MSG:
                    //msg = new DeadMsg(pc);
                    msg.parse(dis);
                    break;
                case Msg.GAME_OVER_MSG:
                    //msg = new GameOverMsg(pc);
                    msg.parse(dis);
                    break;
            }
        }
    }

    public void sendClientDisconnectMsg(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream(88);
        DataOutputStream dos = new DataOutputStream(baos);
        try{
            dos.writeInt(UDP_PORT); //发送客户端的UDP端口号, 从服务器Client集合中注销
        }catch(IOException e) {
            e.printStackTrace();
        }finally{
            if(dos != null){
                try{
                    dos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try{
                    baos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        byte[] buf = baos.toByteArray();
        try{
            DatagramPacket dp = new DatagramPacket(buf, buf.length,new InetSocketAddress(serverIP, GAME_OVER));
            ds.send(dp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
