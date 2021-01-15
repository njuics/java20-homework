package advancedjava.finalproj.connection.client;

import advancedjava.finalproj.connection.helper.ConnectHelper;
import advancedjava.finalproj.connection.helper.Receiver;
import advancedjava.finalproj.game.message.Message;
import advancedjava.finalproj.connection.helper.Sender;
import advancedjava.finalproj.connection.server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client
{
    public static final String SERVER_ADDR = "127.0.0.20";
    public static final int CLIENT_RECEIVER_PORT = 6400;
    public static final int CLIENT_SENDER_PORT = 6401;
    Socket senderSocket;
    Socket receiverSocket;
    InetAddress addr;
    Sender sender;
    Receiver receiver;

    public Client(InetAddress addr) throws IOException
    {
        this.addr = addr;
        ServerSocket clientServer = new ServerSocket();
        clientServer.bind(ConnectHelper.getSocketAddr(this.addr, CLIENT_RECEIVER_PORT));
        senderSocket = new Socket();
        senderSocket.bind(ConnectHelper.getSocketAddr(this.addr, CLIENT_SENDER_PORT));
        senderSocket.connect(ConnectHelper.getSocketAddr(ConnectHelper.getInetAddrFromStr(SERVER_ADDR),
                Server.SERVER_RECEIVER_PORT));
        receiverSocket = clientServer.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(receiverSocket.getInputStream()));
        receiver = new Receiver(in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(senderSocket.getOutputStream()));
        sender = new Sender(out);
    }

    public Client(Sender sender, Receiver receiver)
    {
        this.sender = sender;
        this.receiver = receiver;
    }

    //Only Receive
    public Client(Receiver receiver)
    {
        this(null, receiver);
    }

    public void sendMsg(Message msg)
    {//发送数据
        if (sender != null)
            sender.sendMessage(msg);
    }

    public Message recvMsg()
    {
        Message msg = null;
        if (receiver != null)
            msg = receiver.getMessage();
        return msg;
    }

    public void close()
    {
        try
        {
            if (sender != null)
            {
                sender.close();
            }
            if (receiver != null)
            {
                receiver.close();
            }
            if (senderSocket != null)
            {
                senderSocket.close();
            }
            if (receiverSocket != null)
            {
                receiverSocket.close();
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}


