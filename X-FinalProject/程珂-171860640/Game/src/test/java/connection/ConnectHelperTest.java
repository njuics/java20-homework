package connection;

import advancedjava.finalproj.connection.helper.ConnectHelper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ConnectHelperTest
{

    @Test
    public void testException()
    {
        try
        {
            ConnectHelper.getInetAddrFromStr("127.2.3");
            fail("Expected an IOException to be thrown");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
            assertEquals(e.getMessage(), "3");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        try
        {
            ConnectHelper.getInetAddrFromStr("10001.24452435.4325,-176875645");
            fail("Expected an IOException to be thrown");
        }
        catch (NumberFormatException e)
        {
            assertEquals(e.getMessage(), "For input string: \"4325,-176875645\"");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
