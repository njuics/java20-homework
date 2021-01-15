package org.cvm.net;


import javafx.application.Platform;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import static org.cvm.Framework.playFile;
import static org.cvm.Framework.playView;

public class INFORM_MSG implements Msg {
    private int MSGType = Msg.INFORM_MSG;
    private int team;
    private int action;
    private int skill;

    public INFORM_MSG(){
        this.team = -1;
        this.action = -1;
        this.skill = -1;
    }
    public INFORM_MSG(int team, int action, int skill){
        this.team = team;
        this.action = action;
        this.skill = skill;
    }

    public int getTeam() {
        return team;
    }

    public int getAction() {
        return action;
    }

    public int getSkill() {
        return skill;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(MSGType);
            dos.writeInt(team);
            dos.writeInt(action);
            dos.writeInt(skill);
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
            int action = dis.readInt();
            int skill = dis.readInt();
            this.team = team;
            this.action = action;
            this.skill = skill;
            playFile.addStatement("INFORM " + team + " " + action + " " + skill);
            Platform.setImplicitExit(false);
            Platform.runLater(() -> {
                playView.set_inform(team, action, skill);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
