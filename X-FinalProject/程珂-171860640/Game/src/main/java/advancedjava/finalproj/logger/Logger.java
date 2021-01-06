package advancedjava.finalproj.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger
{
    static private final Date DATE = new Date();
    static private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    private String addr;
    BufferedWriter out;

    public Logger()
    {
        try
        {
            addr = LogDir.LOGDIR_ADDR + "/" + format.format(DATE);
            out = new BufferedWriter(new FileWriter(addr));
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void writeLine(String line)
    {
        try
        {
            out.write(line);
            out.newLine();
            out.flush();
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            out.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
