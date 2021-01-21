package org.cvm.net;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javafx.application.Platform;
import javafx.concurrent.Task;
import org.cvm.view.ServerView;

import static org.cvm.Framework.*;

// Client 发出的 MOVE 指令
public class MOVE_MSG implements Msg {
    private int MSGType = Msg.MOVE_MSG;
    private int team; // 12
    private int id;
    private int dir;//上下左右 1234

    public MOVE_MSG(){
        this.team = -1;
        this.id = -1;
        this.dir = -1;
    }
    public MOVE_MSG(int team, int id, int dir){
        this.team = team;
        this.id = id;
        this.dir = dir;
    }

    public int getTeam() {
        return team;
    }

    public int getDir() {
        return dir;
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
            dos.writeInt(dir);
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
            int dir = dis.readInt();
            this.team = team;
            this.id = id;
            this.dir = dir;
            switch (dir) {
                case 1: {
                    int[] s = (team == 1 ? calabashbrotherTeam.moveup(id) : monsterTeam.moveup(id));
                    if (s[0] != -1) {
                        int src = s[2];
                        int dst = s[3];
                        Msg msg = new S_MOVE_MSG(team,id,src,dst);
                        serverView.send(msg);
                    }
                    break;
                }
                case 2: {
                    int[] s = (team == 1 ? calabashbrotherTeam.movedown(id) : monsterTeam.movedown(id));
                    if (s[0] != -1) {
                        int src = s[2];
                        int dst = s[3];
                        Msg msg = new S_MOVE_MSG(team,id,src,dst);
                        serverView.send(msg);
                    }
                    break;
                }
                case 3: {
                    int[] s = (team == 1 ? calabashbrotherTeam.moveleft(id) : monsterTeam.moveleft(id));
                    if (s[0] != -1) {
                        int src = s[2];
                        int dst = s[3];
                        Msg msg = new S_MOVE_MSG(team,id,src,dst);
                        serverView.send(msg);
                    }
                    break;
                }
                case 4: {
                    int[] s = (team == 1 ? calabashbrotherTeam.moveright(id) : monsterTeam.moveright(id));
                    if (s[0] != -1) {
                        int src = s[2];
                        int dst = s[3];
                        Msg msg = new S_MOVE_MSG(team,id,src,dst);
                        serverView.send(msg);
                    }
                    break;
                }
                default: {
                    System.out.println("error in MOVE_MSG");
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
