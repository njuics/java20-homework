package sample;

//import client.protocol.*;
//import server.TankServer;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 网络方法接口
 */
public class CalabashClient {
    private Main player;//从属的玩家
    private int UDP_PORT;//客户端的UDP端口号
    private String serverIP=Attributes.localServerIP;//服务器IP地址
    private int serverUDPPort;//服务器转发客户UDP包的UDP端口
    private int TANK_DEAD_UDP_PORT;//服务器监听坦克死亡的UDP端口
    private DatagramSocket ds = null;//客户端的UDP套接字

    public void setUDP_PORT(int UDP_PORT) {
        this.UDP_PORT = UDP_PORT;
    }

    public CalabashClient(Main player){
        this.player = player;
        this.serverIP=player.serverIP;
        try {
            this.UDP_PORT = getRandomUDPPort();
        }catch (Exception e){
            //tc.getUdpPortWrongDialog().setVisible(true);//弹窗提示
            System.exit(0);//如果选择到了重复的UDP端口号就退出客户端重新选择.
        }
    }

    /*public static void main(String[] args){
        CalabashClient calabashClient=new CalabashClient();
        calabashClient.connect("127.0.0.1");
    }*/
    /**
     * 与服务器进行TCP连接
     * @param ip server IP
     */
    public boolean connect(String ip) {
        Socket s = null;
        try {
            ds = new DatagramSocket(UDP_PORT);//创建UDP套接字
            try {
                s = new Socket(ip, CalabashServer.TCP_PORT);//创建TCP套接字
            }catch (Exception e1){
                ds.close();
                return false;
            }
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeInt(UDP_PORT);//向服务器发送自己的UDP端口号//TODO
            DataInputStream in = new DataInputStream(s.getInputStream());
            int id = in.readInt();//获得自己的id号//TODO
            player.myID=id;
            this.serverUDPPort = in.readInt();//获得服务器转发客户端消息的UDP端口号//TODO
            //this.TANK_DEAD_UDP_PORT = in.readInt();//获得服务器监听坦克死亡的UDP端口//TODO
            //tc.getMyTank().setId(id);//设置坦克的id号
            //tc.getMyTank().setGood((id & 1) == 0 ? true : false);//根据坦克的id号分配阵营
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
        new Thread(new UDPThread()).start();//开启客户端UDP线程, 向服务器发送或接收游戏数据
        return true;
    }

    /**
     * 客户端随机获取UDP端口号
     * @return
     */
    private int getRandomUDPPort(){
        return 55558 + (int)(Math.random() * 9000);
    }

    public void send(Message message){
        message.send(ds, serverIP, serverUDPPort);
    }

    public class UDPThread implements Runnable{

        byte[] buffer = new byte[1024];

        @Override
        public void run() {
            while(ds!=null){
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                try{
                    ds.receive(dp);
                    parse(dp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void parse(DatagramPacket dp) {
            ByteArrayInputStream bin = new ByteArrayInputStream(buffer, 0, dp.getLength());
            DataInputStream in = new DataInputStream(bin);
            int messageType = 0;
            try {
                messageType = in.readInt();//获得消息类型
            } catch (IOException e) {
                e.printStackTrace();
            }
            Message message = null;
            switch (messageType){//根据消息的类型调用对应消息的解析方法
                case Message.GAME_START:
                    //message = new GameStartMessage(player);
                    //message.parse(in);
                    break;
                case  Message.ROLE_MOVE :
                    message = new RoleMoveMessage(player);
                    message.parse(in);
                    break;
                case Message.ATTACK:
                    message=new AttackMessage(player);
                    message.parse(in);
                    break;
                case Message.NEW_PLAYER:
                    message=new NewPlayerMessage(player);
                    message.parse(in);
                    break;
                case Message.INVITATION:
                    message=new InviteMessage(player);
                    message.parse(in);
                    break;
                case Message.REPLY:
                    message=new ReplyMessage(player);
                    message.parse(in);
                    break;
                    /*
                case Msg.MISSILE_NEW_MSG:
                    msg = new MissileNewMsg(tc);
                    msg.parse(dis);
                    break;
                case Msg.TANK_DEAD_MSG:
                    msg = new TankDeadMsg(tc);
                    msg.parse(dis);
                    break;
                case Msg.MISSILE_DEAD_MSG:
                    msg = new MissileDeadMsg(tc);
                    msg.parse(dis);
                    break;
                case Msg.TANK_ALREADY_EXIST_MSG:
                    msg = new TankAlreadyExistMsg(tc);
                    msg.parse(dis);
                    break;
                case Msg.TANK_REDUCE_BLOOD_MSG:
                    msg = new TankReduceBloodMsg(tc);
                    msg.parse(dis);
                    break;
                    */
            }
        }
    }

    public void sendClientDisconnectMsg(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream(88);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(UDP_PORT);//发送客户端的UDP端口号, 从服务器Client集合中注销
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != dos){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != baos){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] buf = baos.toByteArray();
        try{
            DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(serverIP, TANK_DEAD_UDP_PORT));
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

