package org.cvm.net;


import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

import static org.cvm.Framework.*;

public class FINISH_MSG implements Msg {
    private int MSGType = Msg.FINISH_MSG;
    private int team;

    public FINISH_MSG(){
        this.team = -1;
    }
    public FINISH_MSG(int team){
        this.team = team;
    }

    public int getTeam() {
        return team;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int UDP_Port) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(30);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(MSGType);
            dos.writeInt(team);
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
            this.team = team;
            int op_team = (team == 1 ? 2 : 1);
            START_MSG start_msg1 = new START_MSG(team,true);
            serverView.send(start_msg1);
            START_MSG start_msg2 = new START_MSG(op_team,false);
            serverView.send(start_msg2);
            monsterTeam.TeamNewTurn();
            calabashbrotherTeam.TeamNewTurn();
            INFORM_MSG inform_msg = new INFORM_MSG(team, calabashbrotherTeam.getTeamActionnumber(), calabashbrotherTeam.getTeamSkillNumber());
            serverView.send(inform_msg, team);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
