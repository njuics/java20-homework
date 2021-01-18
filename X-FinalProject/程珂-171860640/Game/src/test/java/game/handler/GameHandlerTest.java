package game.handler;

import advancedjava.finalproj.connection.helper.ConnectHelper;
import advancedjava.finalproj.game.handler.GameHandler;

import java.io.IOException;

public class GameHandlerTest
{

    public GameHandlerTest() throws IOException
    {
        GameHandler gameHandler = new GameHandler(ConnectHelper.getInetAddrFromStr("127.0.0.20"));
    }


}
