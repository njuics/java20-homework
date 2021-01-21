package advancedjava.finalproj.game.main;

import advancedjava.finalproj.connection.server.Server;

import java.io.IOException;

public class testServer
{
    public static void main(String[] args) throws IOException
    {
        Server s = new Server();
        while (true)
        {
            s.startMatch();
        }
    }
}
