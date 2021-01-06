package huluwa.Protocol;

import java.io.DataInputStream;
import java.net.DatagramSocket;

/**
 * 应用层协议接口
 */
public interface Msg {
    public static final int PLAYER_JOIN_MSG = 1;
    public static final int MOVE_MSG= 2;
    public static final int SHOOT_MSG = 3;
    public static final int DEAD_MSG = 4;
    public static final int GAME_OVER_MSG = 5;

    public void send(DatagramSocket ds, String IP, int UDP_Port);
    public void parse(DataInputStream dis);
}
