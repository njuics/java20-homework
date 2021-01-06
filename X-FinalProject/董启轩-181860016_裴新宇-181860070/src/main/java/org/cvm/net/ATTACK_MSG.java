package org.cvm.net;

import javafx.application.Platform;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import static org.cvm.Framework.*;

public class ATTACK_MSG implements Msg {
    private int MSGType = Msg.ATTACK_MSG;
    private int team;
    private int id;
    private boolean is_skill;//技能 12

    public ATTACK_MSG(){
        this.team = -1;
        this.id = -1;
        this.is_skill = false;
    }
    public ATTACK_MSG(int team, int id, boolean is_skill){
        this.team = team;
        this.id = id;
        this.is_skill = is_skill;
    }

    public int getTeam() {
        return team;
    }

    public boolean getIs_skill() {
        return is_skill;
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
            dos.writeBoolean(is_skill);
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
            boolean is_skill = dis.readBoolean();
            this.team = team;
            this.id = id;
            this.is_skill = is_skill;
            int op_team = (team == 1 ? 2 : 1);
            List<List<Integer>> result = (team == 1 ? calabashbrotherTeam.Doattack(id,is_skill) : monsterTeam.Doattack(id,is_skill));
            if (result.get(0).get(0) == -1) {
                System.out.println("行动力/技能点不够");
            }
            else {
                for (int i = 1; i < result.size(); i++) {
                    List<Integer> result_in = result.get(i);
                    if (result_in.get(0) == 1) {
                        int attack_id = result_in.get(1);
                        int damage = result_in.get(2);
                        int current_blood = result_in.get(3);
                        int max_blood = result_in.get(4);
                        double blood = (double) current_blood / (double) max_blood;
                        Msg msg = new BLOOD_MSG(op_team, attack_id, damage, current_blood, max_blood);
                        serverView.send(msg);
                        System.out.println("Server sent a blood_msg");
                    } else {
                        System.out.println("Buff todo");
                    }
                }
            }

            if (team == 1) {
                INFORM_MSG inform_msg = new INFORM_MSG(team, calabashbrotherTeam.getTeamActionnumber(), calabashbrotherTeam.getTeamSkillNumber());
                serverView.send(inform_msg);
            }
            else {
                INFORM_MSG inform_msg = new INFORM_MSG(team, monsterTeam.getTeamActionnumber(), monsterTeam.getTeamSkillNumber());
                serverView.send(inform_msg);
            }

            if (calabashbrotherTeam.isGameOver()) {
                DEAD_MSG msg1 = new DEAD_MSG(1,false);
                DEAD_MSG msg2 = new DEAD_MSG(2,true);
                serverView.send(msg1,1);
                serverView.send(msg2,2);
            }
            else if (monsterTeam.isGameOver()) {
                DEAD_MSG msg1 = new DEAD_MSG(1,true);
                DEAD_MSG msg2 = new DEAD_MSG(2,false);
                serverView.send(msg1,1);
                serverView.send(msg2,2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
