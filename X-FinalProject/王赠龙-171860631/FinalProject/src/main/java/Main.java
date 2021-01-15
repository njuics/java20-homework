import BattleControl.Controller;
import BattleControl.NetThread;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Main extends Application {
    private static final double SCENE_WIDTH=960.0;//场景的宽与高
    private static final double SCENE_HEIGHT=720.0;
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//java -jar target/FinalProject-1.0-SNAPSHOT.jar
        primaryStage.setTitle("空格开始游戏,L复盘回放,JUSTICE玩家WSAD键控制移动,Tab键切换控制;EVIL玩家方向键控制移动,J键切换控制");//JUSTICE玩家WSAD键控制移动,EVIL玩家方向键控制移动
        primaryStage.getIcons().add(new Image("StageTittleGraphic.jpg"));//,JUSTICE玩家WSAD键控制移动,Tab键切换控制;EVIL玩家方向键控制移动,J键切换控制
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));//<encoding>UTF-8</encoding>
        primaryStage.show();
        primaryStage.setResizable(false);//不可变更窗口大小
        Controller.setStage(primaryStage);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

/*
        System.out.println("sb");
        URL url=getClass().getResource("picture/scene/background.jpg");
        if(url==null){
            System.out.println("sb1");
        }
        else{
            System.out.println("sb2");
        }
*/
    }
    public static void main(String[] args) throws  Exception{
        launch(args);
    }

}
