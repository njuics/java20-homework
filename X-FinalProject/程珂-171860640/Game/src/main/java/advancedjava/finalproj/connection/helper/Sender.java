package advancedjava.finalproj.connection.helper;

import advancedjava.finalproj.game.message.Message;

import java.io.BufferedWriter;
import java.io.IOException;

public class Sender
{
    BufferedWriter sender;

    public Sender(BufferedWriter sender)
    {
        this.sender = sender;
    }

    public void close() throws IOException
    {
        sender.close();
    }

    public void sendMessage(Message msg)
    {
        try
        {
            //Output Test Information
            System.out.println("sender:" + msg);
            sender.write(msg.toString());
            sender.newLine();
            sender.flush();
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}


