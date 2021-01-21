package game.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends Application {

    protected Scene mScene;

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(1200);
        primaryStage.setHeight(900);



        showStage(primaryStage);
    }

    public void showStage(Stage s){
        s.setScene(mScene);
        s.show();
    }



}
