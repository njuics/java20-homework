import game.ScreenController;
import game.screen.Game;
import game.screen.Menu;
import game.template.GameApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends GameApplication {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("葫芦娃战棋");
        primaryStage.setResizable(false);

        mScene = new Scene(new Pane(),1200,900);
        primaryStage.setScene(mScene);

        ScreenController.getInstance().setScene(mScene);

        //菜单
        ScreenController.getInstance().addScreen("Menu", new Menu());
        ScreenController.getInstance().activate("Menu");

        //游戏主界面
        ScreenController.getInstance().addScreen("Game", new Game());


        super.start(primaryStage);
    }
}
