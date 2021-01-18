package org.cvm.net;


import javafx.application.Platform;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import static org.cvm.Framework.*;
import static org.cvm.Framework.monsterTeam;

public class BLOOD_MSG implements Msg {
    private int MSGType = Msg.BLOOD_MSG;
    private int team;
    private int id;
    private int damage;
    private int current_blood;
    private int max_blood;

    public BLOOD_MSG(){
        this.team = -1;
        this.id = -1;
        this.damage = -1;
        this.current_blood = -1;
        this.max_blood = -1;
    }
    public BLOOD_MSG(int team, int id, int damage, int current_blood, int max_blood){
        this.team = team;
        this.id = id;
        this.damage = damage;
        this.current_blood = current_blood;
        this.max_blood = max_blood;
    }

    public int getTeam() {
        return team;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getCurrent_blood() {
        return current_blood;
    }

    public int getMax_blood() {
        return max_blood;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(MSGType);
            dos.writeInt(team);
            dos.writeInt(id);
            dos.writeInt(damage);
            dos.writeInt(current_blood);
            dos.writeInt(max_blood);
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
            int damage = dis.readInt();
            int current_blood = dis.readInt();
            int max_blood = dis.readInt();
            this.team = team;
            this.id = id;
            this.damage = damage;
            this.current_blood = current_blood;
            this.max_blood = max_blood;
            double blood = (double)current_blood / (double)max_blood;
            playFile.addStatement("BLOOD " + team + " " + id + " " + damage + " " + current_blood + " " + max_blood);

            String team_str = (team == 1 ? "葫芦队" : "妖怪队");
            String id_str = (team == 1 ? calabashbrotherTeam.getSkillName(id) :monsterTeam.getSkillName(id));
            String isdead_str = (current_blood <= 0 ? "后死亡" : "");

            Platform.setImplicitExit(false);
            Platform.runLater(() -> {
                playView.add_playinfo(team_str + "的" + id_str + "受到了" + damage + "点伤害" + isdead_str);
                playView.set_blood(team,id,blood);
                if (current_blood == 0) {
                    playView.delete_creature(team,id);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
