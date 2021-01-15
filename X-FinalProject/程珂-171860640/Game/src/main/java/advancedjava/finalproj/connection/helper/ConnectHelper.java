package advancedjava.finalproj.connection.helper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class ConnectHelper
{
    static public InetAddress getInetAddrFromStr(String addrStr) throws IOException
    {
        String[] addrStrs = addrStr.split("\\.");
        byte[] addrBytes = new byte[4];
        for (int i = 0; i < 4; i++)
        {
            addrBytes[i] = (byte) Integer.parseInt(addrStrs[i]);
        }
        return InetAddress.getByAddress(addrBytes);
    }

    static public SocketAddress getSocketAddr(InetAddress addr, int port)
    {
        return new InetSocketAddress(addr, port);
    }
}
