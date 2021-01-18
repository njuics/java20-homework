package org.cvm.net;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import javafx.application.Platform;
import javafx.concurrent.Task;

import static org.cvm.Framework.*;

// Server 发出的 MOVE 指令
public class S_MOVE_MSG implements Msg {
    private int MSGType = Msg.S_MOVE_MSG;
    private int team; // 12
    private int id;
    private int last_pos;
    private int current_pos;

    public S_MOVE_MSG(){
        this.team = -1;
        this.id = -1;
        this.last_pos = -1;
        this.current_pos = -1;
    }
    public S_MOVE_MSG(int team, int id, int last_pos, int current_pos){
        this.team = team;
        this.id = id;
        this.last_pos = last_pos;
        this.current_pos = current_pos;
    }

    public int getTeam() {
        return team;
    }

    public int getLast_pos() {
        return last_pos;
    }

    public int getCurrent_pos() {
        return current_pos;
    }

    public int getId() {
        return id;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(MSGType);
            dos.writeInt(team);
            dos.writeInt(id);
            dos.writeInt(last_pos);
            dos.writeInt(current_pos);
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
            int team = dis.readInt();
            int id = dis.readInt();
            int last_pos = dis.readInt();
            int current_pos = dis.readInt();
            this.team = team;
            this.id = id;
            this.last_pos = last_pos;
            this.current_pos = current_pos;
            System.out.println("Client request a swap");
            playFile.addStatement("MOVE " + team + " " + id + " " + last_pos + " " + current_pos);
            Platform.setImplicitExit(false);
            Platform.runLater(() -> {
                playView.setPos(team,id,last_pos,current_pos);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
