package advancedjava.finalproj.connection.helper;

import advancedjava.finalproj.game.message.Message;

import java.io.BufferedReader;
import java.io.IOException;

public class Receiver
{
    BufferedReader receiver;

    public Receiver(BufferedReader receiver)
    {
        this.receiver = receiver;
    }

    public Message getMessage()
    {
        Message msg = null;
        try
        {
            String msgStr = receiver.readLine();
            //Output Test Information
            System.out.println("receiver:" + msgStr);
            if (msgStr != null)
            {
                msg = Message.parseMessage(msgStr);
            }
            return msg;
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
            return msg;
        }
    }

    public void close() throws IOException
    {
        receiver.close();
    }
}
