package huluwa.Protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import huluwa.Client.PlayerClient;

/**
 * 客户端加入游戏消息协议
 */

public class JoinMsg implements Msg{
    private int msgType = Msg.PLAYER_JOIN_MSG;
    private PlayerClient pc;

    public JoinMsg(PlayerClient pc){
        this.pc = pc;
    }
    
    public void send(DatagramSocket ds, String IP, int UDP_Port){
        ByteArrayOutputStream baos = new ByteArrayOutputStream(88);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeBoolean(pc.getGoodBad());

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] buf = baos.toByteArray();
        try{
            DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP, UDP_Port));
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parse(DataInputStream dis){
        try{
            boolean good = dis.readBoolean();
            if(good){
                this.pc.goodReady = true;
            }else{
                this.pc.badReady = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
