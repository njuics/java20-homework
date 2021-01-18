package advancedjava.finalproj.connection.helper;

import advancedjava.finalproj.game.message.Message;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ReceiveThread extends Thread
{
    Receiver reader;
    boolean exitFlag;
    ConcurrentLinkedQueue<Message> msgChannal;

    public ReceiveThread(Receiver receiver, ConcurrentLinkedQueue<Message> msgChannal)
    {
        reader = receiver;
        exitFlag = false;
        this.msgChannal = msgChannal;
    }

    public void exit()
    {
        exitFlag = true;
    }

    @Override
    public void run()
    {
        Message msg;
        while (!exitFlag)
        {
            if ((msg = reader.getMessage()) != null)
            {
                msgChannal.offer(msg);
            }
        }
        //Output Test Information
        System.out.println("Recv Thread Exited");
    }
}
