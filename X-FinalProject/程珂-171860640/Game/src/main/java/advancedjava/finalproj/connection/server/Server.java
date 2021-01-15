package advancedjava.finalproj.connection.server;

import advancedjava.finalproj.connection.client.Client;
import advancedjava.finalproj.connection.helper.ConnectHelper;
import advancedjava.finalproj.Pair;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static final String SERVER_ADDR = "127.0.0.20";
    public static final int SERVER_RECEIVER_PORT = 6400;

    Match match;
    ServerSocket server;

    public Server() throws IOException
    {
        server = new ServerSocket();
        server.bind(ConnectHelper.getSocketAddr(ConnectHelper.getInetAddrFromStr(SERVER_ADDR), SERVER_RECEIVER_PORT));
    }

    public void startMatch() throws IOException
    {
        Socket playerReceiver1 = server.accept();
        Socket playerReceiver2 = server.accept();
        Socket playerSender1 = new Socket();
        Socket playerSender2 = new Socket();

        //Init A new Match
        playerSender1.connect(ConnectHelper.getSocketAddr(playerReceiver1.getInetAddress(),
                Client.CLIENT_RECEIVER_PORT));
        playerSender2.connect(ConnectHelper.getSocketAddr(playerReceiver2.getInetAddress(),
                Client.CLIENT_RECEIVER_PORT));

        match = new Match(new Pair<>(playerSender1, playerSender2),
                new Pair<>(playerReceiver1, playerReceiver2));

        //Output Test Information
        System.out.println("client1:" + playerReceiver1.getInetAddress());
        System.out.println("client2:" + playerReceiver2.getInetAddress());
        System.out.println("Match Start!");
        Thread matchThread = new Thread(match);
        matchThread.start();
    }
}





