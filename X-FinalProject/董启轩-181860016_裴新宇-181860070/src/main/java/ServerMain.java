import org.cvm.Framework;
import org.cvm.app.Game;
import org.cvm.view.ServerView;

import static org.cvm.Framework.app;

public class ServerMain extends Game {

    ServerView serverView;

    @Override
    public void onLaunch() {
        app.setTitle("Server");
        app.setWidth(200);
        app.setHeight(400);

        serverView = new ServerView();
        Framework.serverView = serverView;
        app.regView("Server", serverView);
        app.gotoView("Server");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onFinish() {
        System.out.println("ServerMain Finish");
    }

    @Override
    public boolean onExit() {
//        engine.stop();
        System.out.println("ServerMain Exit");
        System.exit(0);
        return true;
    }
}