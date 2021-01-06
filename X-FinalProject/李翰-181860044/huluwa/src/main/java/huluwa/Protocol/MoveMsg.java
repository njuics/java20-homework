package huluwa.Protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import huluwa.Client.PlayerClient;
import huluwa.Creature.Creature;

public class MoveMsg implements Msg{
    private int msgType = Msg.MOVE_MSG;
    private PlayerClient pc;
    private Creature c;
    private int dir;
    private boolean good;

    public MoveMsg(PlayerClient pc, Creature c, int dir, boolean good){
        this.pc = pc;
        this.c = c;
        this.dir = dir;
        this.good = good;
    }
    public MoveMsg(PlayerClient pc){
        this.pc = pc;
    }

	@Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);//指定大小, 免得字节数组扩容占用时间
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeUTF(c.getName());
            dos.writeInt(dir);
            dos.writeBoolean(good);
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

    @Override
    public void parse(DataInputStream dis) {
        try{
            String name = dis.readUTF();
            dir = dis.readInt();
            good = dis.readBoolean();
            if(good){
                for(int i=0; i<pc.getGame().goodManGrid.size(); ++i){
                    if(pc.getGame().goodManGrid.get(i).creature.getName()==name){
                        pc.getGame().goodManGrid.get(i).move(dir);
                        pc.getGame().goodManGrid.get(i).update();
                        pc.getGame().staticGoodManGrid.get(i).move(dir);
                        break;
                    }
                }
            }else{
                for(int i=0; i<pc.getGame().badManGrid.size(); ++i){
                    if(pc.getGame().badManGrid.get(i).creature.getName()==name){
                        pc.getGame().badManGrid.get(i).move(dir);
                        pc.getGame().badManGrid.get(i).update();
                        pc.getGame().staticBadManGrid.get(i).move(dir);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
