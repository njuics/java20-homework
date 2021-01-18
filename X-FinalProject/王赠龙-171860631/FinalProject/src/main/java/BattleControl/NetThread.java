package BattleControl;

import sun.nio.ch.Net;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NetThread extends Thread {
    private  int otherPort=3303;//对方端口
    private  int receivePort=3304;//本地端口
    private  String otherIp="114.212.132.208";//对方ip
    public NetThread(int otherPort,int receivePort,String otherIp){
        this.otherPort=otherPort;
        this.receivePort=receivePort;
        this.otherIp=otherIp;
    }

    @Override
    public void run() {
        try {
         //   System.out.println("我是客户端，我绑定的端口是" + receivePort);
            DatagramSocket s = new DatagramSocket(receivePort);
            byte[] data = new byte[1024*60];
            DatagramPacket dgp = new DatagramPacket(data, data.length);//创建UDP通信端口
            while (true) {//监听通信端口
                s.receive(dgp);//从端口中获取对手发的信息
                /*
                String strData = new String(data);
                System.out.println("接收到信息:"+strData);*/
                NetPacket tempPacket=convertToNetPacket(data);//将获取的二进制信息转为NetPacket对象，以便获取生物信息
                System.out.println(tempPacket.getName()+" "+tempPacket.getNewPosX()+" "+tempPacket.getNewPosY()+" "+tempPacket.getHp());
                Controller.processNetPacket(tempPacket);//更新自己程序对手阵营生物的信息
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public NetPacket convertToNetPacket(byte[] data) {
        NetPacket employee = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            employee = (NetPacket) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employee;
    }

}
