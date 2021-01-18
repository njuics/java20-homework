package advancedjava.finalproj.connection.server;

import advancedjava.finalproj.Pair;
import advancedjava.finalproj.connection.helper.ReceiveThread;
import advancedjava.finalproj.connection.helper.Receiver;
import advancedjava.finalproj.game.CampEnum;
import advancedjava.finalproj.game.message.Message;
import advancedjava.finalproj.game.message.MessageType;
import advancedjava.finalproj.game.message.StartMessage;
import advancedjava.finalproj.connection.helper.Sender;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Match implements Runnable
{
    //仅用来发
    Pair<Socket> playerSenderSocks;
    //仅用来收
    Pair<Socket> playerReceiverSocks;
    //Receivers
    Pair<Receiver> playerReceivers;
    //Senders
    Pair<Sender> playerSenders;

    ConcurrentLinkedQueue<Message> msgChannel;

    //write for constructor
    private boolean isSocketPairNull(Pair<Socket> playerSocks)
    {
        return playerSocks == null ||
                playerSocks.getFirst() == null ||
                playerSocks.getSecond() == null;
    }

    //write for constructor
    private Receiver getReceiver(Socket socket) throws IOException
    {
        return new Receiver(new BufferedReader(new InputStreamReader(socket.getInputStream())));
    }

    //write for constructor
    private Sender getSender(Socket socket) throws IOException
    {
        return new Sender(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
    }

    public Match(Pair<Socket> playerSenderSocks, Pair<Socket> playerReceiverSocks) throws IOException
    {
        if (isSocketPairNull(playerSenderSocks) || isSocketPairNull(playerReceiverSocks))
            throw new IOException("Player Socket Exception");
        this.playerSenderSocks = playerSenderSocks;
        this.playerReceiverSocks = playerReceiverSocks;

        playerReceivers = new Pair<>(getReceiver(playerReceiverSocks.getFirst()),
                getReceiver(playerReceiverSocks.getSecond()));
        this.playerSenders = new Pair<>(getSender(playerSenderSocks.getFirst()),
                getSender(playerSenderSocks.getSecond()));

        msgChannel = new ConcurrentLinkedQueue<>();
    }

    public void initConnection()
    {
        Random rand = new Random();
        boolean isFirstBro = rand.nextBoolean();
        long seed = rand.nextLong();
        StartMessage firstStartMsg, secondStartMsg;
        if (isFirstBro)
        {
            firstStartMsg = new StartMessage(CampEnum.HULUBRO, seed);
            secondStartMsg = new StartMessage(CampEnum.MONSTER, seed);
        }
        else
        {
            firstStartMsg = new StartMessage(CampEnum.MONSTER, seed);
            secondStartMsg = new StartMessage(CampEnum.HULUBRO, seed);
        }

        Message firstMsg = new Message(CampEnum.SERVER, MessageType.START, firstStartMsg.toString()),
                secondMsg = new Message(CampEnum.SERVER, MessageType.START, secondStartMsg.toString());

        playerSenders.getFirst().sendMessage(firstMsg);
        playerSenders.getSecond().sendMessage(secondMsg);
    }

    public void processOtherMsg(Message msg)
    {
        playerSenders.getFirst().sendMessage(msg);
        playerSenders.getSecond().sendMessage(msg);
    }

    //主线程中不断读取
    public void run()
    {
        ReceiveThread firstRecvThread = new ReceiveThread(playerReceivers.getFirst(), msgChannel);
        ReceiveThread secondRecvThread = new ReceiveThread(playerReceivers.getSecond(), msgChannel);
        firstRecvThread.start();
        secondRecvThread.start();

        initConnection();

        //process
        boolean isExited = false;
        while (!isExited)
        {
            Message msg = msgChannel.poll();
            if (msg != null)
            {
                //Output Test Information
                System.out.println("Server process:" + msg);
                if (msg.type == MessageType.GAME_OVER)
                    isExited = true;
                processOtherMsg(msg);
            }
        }

        //Interrupt Receive Thread
        firstRecvThread.exit();
        secondRecvThread.exit();

        //Close Connection
        try
        {
            this.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

        //Output Test Information
        System.out.println("Match Exited");
    }

    public void close() throws IOException
    {
        //First Close IOStream
        playerSenders.getFirst().close();
        playerSenders.getSecond().close();
        //Then Close Socket
        playerSenderSocks.getFirst().close();
        playerSenderSocks.getSecond().close();
        playerReceivers.getFirst().close();
        playerReceiverSocks.getSecond().close();
        playerReceiverSocks.getFirst().close();
        playerReceiverSocks.getSecond().close();
    }
}