import javafx.scene.image.Image;
import org.cvm.Framework;
import org.cvm.app.Game;
import org.cvm.view.FilePlayView;
import org.cvm.view.HomeView;
import org.cvm.view.PlayView;

import static org.cvm.Framework.app;

public class Main extends Game {

    PlayView playView;

    @Override
    public void onLaunch() {
        app.setTitle("葫芦娃大战妖精");
        app.setWidth(1000);
        app.setHeight(700);
        Image img_logo = new Image(getClass().getResourceAsStream("logo.png"));
        app.getStage().getIcons().add(img_logo);

        playView = new PlayView();
        Framework.playView = playView;
        app.regView("Home", new HomeView());
        app.regView("Play", playView);
        app.regView("FilePlay", new FilePlayView());
        app.gotoView("Home");
        // app.gotoView("Play"); // 测试
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onFinish() {
        System.out.println("Main Finish");
    }

    @Override
    public boolean onExit() {
//        engine.stop();
        System.out.println("Main Exit");
        System.exit(0);
        return true;
    }
}