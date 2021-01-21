package org.cvm.net;


import javafx.application.Platform;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import static org.cvm.Framework.playView;

public class DEAD_MSG implements Msg {
    private int MSGType = Msg.DEAD_MSG;
    private int team;
    private boolean youwin;

    public DEAD_MSG(){
        this.team = -1;
        this.youwin = false;
    }
    public DEAD_MSG(int team, boolean youwin){
        this.team = team;
        this.youwin = youwin;
    }

    public int getTeam() {
        return team;
    }

    public boolean isYouwin() {
        return youwin;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(MSGType);
            dos.writeInt(team);
            dos.writeBoolean(youwin);
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
            boolean youwin = dis.readBoolean();
            this.team = team;
            this.youwin = youwin;
            Platform.setImplicitExit(false);
            Platform.runLater(() -> {
                playView.game_over(team,youwin);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
