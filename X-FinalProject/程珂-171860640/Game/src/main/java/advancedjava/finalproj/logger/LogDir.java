package advancedjava.finalproj.logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LogDir
{
    static public final String LOGDIR_ADDR = "logs";
    private File logDir;

    public LogDir()
    {
        logDir = new File(LOGDIR_ADDR);
        try
        {
            if (!logDir.exists()) logDir.createNewFile();
        }
        catch (IOException e)
        {
        }
    }

    public ArrayList<String> loadCatalog()
    {
        ArrayList<String> fileList = new ArrayList<>();
        if (logDir != null)
        {
            File[] files = logDir.listFiles();
            for (int i = 0; i < files.length; i++)
                fileList.add(files[i].getName());
        }
        return fileList;
    }
}
