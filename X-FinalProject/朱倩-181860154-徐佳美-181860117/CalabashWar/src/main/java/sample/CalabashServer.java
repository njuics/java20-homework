package sample;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 服务器
 */
public class CalabashServer{

    public static int clientCount = 0;//连接的客户端数量
    public static final int TCP_PORT = 55555;//TCP端口号
    public static final int UDP_PORT = 55556;//转发客户端数据的UDP端口号
    public static final int NEW_PLAYER_UDP_PORT=55557;//告知新用户加入的UDP端口号
    private List<Client> clients = new ArrayList<>();//客户端集合

    public static void main(String[] args) {
        CalabashServer calabashServer = new CalabashServer();
        calabashServer.start();
    }

    public void start(){
        new Thread(new UDPThread()).start();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(TCP_PORT);
            System.out.println("CalabashServer has started...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            Socket clientSocket = null;
            try {
                //处理新连接的用户
                clientSocket = serverSocket.accept();//给客户分配TCP套接字
                System.out.println("A client has connected...");
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                int udpPort = in.readInt();//记录客户端UDP端口
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                Client client = new Client(clientSocket.getInetAddress().getHostAddress(), udpPort, clientCount);//创建Client对象
                out.writeInt(clientCount++);//向客户端分配id号
                out.writeInt(CalabashServer.UDP_PORT);//告诉客户端自己的UDP端口号

                //告知已连接服务器的玩家有新玩家加入，告知新玩家之前已连接的玩家
                DatagramSocket ds = null;
                try{
                    ds = new DatagramSocket(NEW_PLAYER_UDP_PORT);
                }catch (SocketException e) {
                    e.printStackTrace();
                }
                NewPlayerMessage m1=new NewPlayerMessage(client.id);
                for(Client c:clients){
                    m1.send(ds,c.ip,c.udpPORT);
                }
                for(Client c:clients){
                    NewPlayerMessage m2=new NewPlayerMessage(c.id);
                    m2.send(ds,client.ip,client.udpPORT);
                }
                ds.close();

                //客户端数量++
                clients.add(client);//添加进客户端容器

            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(clientSocket != null) clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class UDPThread implements Runnable{
        byte[] buf = new byte[1024];
        @Override
        public void run() {
            DatagramSocket ds = null;
            try{
                ds = new DatagramSocket(UDP_PORT);
            }catch (SocketException e) {
                e.printStackTrace();
            }

            while (ds!=null){
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try {
                    ds.receive(dp);
                    String addr=dp.getAddress().getHostName();
                    int port=dp.getPort();
                    for (Client c : clients){
                        dp.setSocketAddress(new InetSocketAddress(c.ip, c.udpPORT));
                        ds.send(dp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public class Client{
        String ip;
        int udpPORT;
        int id;

        public Client(String ipAddr, int UDP_PORT, int id) {
            this.ip = ipAddr;
            this.udpPORT = UDP_PORT;
            this.id = id;
        }
    }

}

