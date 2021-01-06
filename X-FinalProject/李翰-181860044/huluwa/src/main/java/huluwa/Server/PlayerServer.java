package huluwa.Server;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import huluwa.Render;

public class PlayerServer {
    public static int ID = 100;//id号的初始序列
    public static final int TCP_PORT = 55555;//TCP端口号
    public static final int UDP_PORT = 55556;//转发客户端数据的UDP端口号
    public static final int GAME_OVER_UDP_PORT = 55557;//接收客户端游戏结束的端口号
    private List<Client> clients = new ArrayList<>();//客户端集合


    public static void main(String[] args) {
        PlayerServer ps = new PlayerServer();
        ps.start();
        //Render.main(args);
    }

    public void start(){
        new Thread(new UDPThread()).start();
        new Thread(new GameOverThread()).start();
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(TCP_PORT); //在TCP欢迎套接字上监听客户端连接
            System.out.println("PlayerServer has started...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            Socket s = null;
            try{
                s = ss.accept(); //给客户端分配专属TCP套接字
                System.out.println("A client has connected...");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                int UDP_PORT = dis.readInt(); //记录客户端UDP端口
                Client client = new Client(s.getInetAddress().getHostAddress(), UDP_PORT, ID); //创建Client对象
                clients.add(client); //添加进客户端容器

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(ID++);   //向客户端分配ID号
                dos.writeInt(PlayerServer.UDP_PORT);   //告诉客户端自己的UDP端口号
                dos.writeInt(PlayerServer.GAME_OVER_UDP_PORT);
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                try{
                    if(s != null)s.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private class UDPThread implements Runnable{
        byte[] buf = new byte[1024];

        @Override
        public void run(){
            DatagramSocket ds = null;
            try{
                ds = new DatagramSocket();
            }catch(SocketException e){
                e.printStackTrace();
            }

            while(ds != null){
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try{
                    ds.receive(dp);
                    for(Client c:clients){
                        dp.setSocketAddress(new InetSocketAddress(c.IP, c.UDP_PORT));
                        ds.send(dp);
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private class GameOverThread implements Runnable{

        @Override
        public void run(){
            //TODO
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
