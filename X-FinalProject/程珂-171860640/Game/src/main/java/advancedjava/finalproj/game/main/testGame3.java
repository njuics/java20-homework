package advancedjava.finalproj.game.main;

import advancedjava.finalproj.connection.helper.ConnectHelper;
import advancedjava.finalproj.game.handler.GameHandler;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class testGame3 extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        GameHandler gameHandler = new GameHandler(ConnectHelper.getInetAddrFromStr("127.0.0.35"));
        gameHandler.start();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

