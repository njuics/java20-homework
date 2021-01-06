package hulubattle.client.controller;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 启动 JavaFX 应用
 */
public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getClassLoader().getResource("layout/main.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(new MainViewController(primaryStage));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HuLu Battle");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
