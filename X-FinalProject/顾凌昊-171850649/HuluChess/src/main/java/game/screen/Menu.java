package game.screen;

import client.Client;
import game.MainController;
import game.ScreenController;
import game.map.object.CellObject;
import game.template.GameScreen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import server.Server;
import sun.security.util.Debug;

import java.awt.*;

public class Menu extends Pane {



    public Menu() {

        showMenuText();
        showMenuButton();
    }


    public void showMenuText(){

        Text menu = new Text(350,150,"葫芦娃战棋");
        menu.setFont(Font.font(100));;

        Text intro = new Text();


        getChildren().add(menu);
    }

    public void showMenuButton(){

        GridPane layout = new GridPane();

        //创建房间按钮
        Button createRoom = new Button("创建房间");
        createRoom.setPrefWidth(400);
        createRoom.setPrefHeight(80);

        createRoom.setOnAction(e->{
            showCreateRoomStage();
        });

        //进入房间按钮
        Button enterRoom = new Button("进入房间");
        enterRoom.setPrefWidth(400);
        enterRoom.setPrefHeight(80);

        enterRoom.setOnAction(e->{
            showEnterRoomStage();
        });

        //播放录像按钮
        Button load = new Button("游戏玩法");
        load.setPrefWidth(400);
        load.setPrefHeight(80);

        load.setOnAction(e->{
            showHelpStage();
        });

        //退出游戏按钮
        Button exit = new Button("退出游戏");
        exit.setPrefWidth(400);
        exit.setPrefHeight(80);

        exit.setOnAction(e->{
            MainController.getInstance().exit();
        });

        layout.setLayoutX(400);
        layout.setLayoutY(300);
        layout.setVgap(50);

        layout.add(createRoom,0,0);
        layout.add(enterRoom,0,1);
        layout.add(load,0,2);
        layout.add(exit,0,3);

        getChildren().add(layout);

    }

    public void showCreateRoomStage(){
        Stage stage = new Stage();

        Pane pane = new Pane();

        Text title = new Text("创建房间");
        title.setFont(Font.font(30));
        title.setLayoutX(200);
        title.setLayoutY(50);


        pane.getChildren().add(title);

        /*
        Text ip = new Text("ip地址");
        ip.setFont(Font.font(30));
        ip.setLayoutX(50);
        ip.setLayoutY(100);

        TextField ipField = new TextField();
        ipField.setPrefSize(200,50);
        ipField.setLayoutX(200);
        ipField.setLayoutY(100);

        getChildren().add(ip);
        getChildren().add(ipField);
*/

        Text pw = new Text("连接码");
        pw.setFont(Font.font(20));
        pw.setLayoutX(50);
        pw.setLayoutY(150);

        TextField pwField = new TextField();
        pwField.setPrefSize(200,50);
        pwField.setLayoutX(200);
        pwField.setLayoutY(150);

        pane.getChildren().add(pw);
        pane.getChildren().add(pwField);

        Button confirm = new Button("连接");
        confirm.setPrefWidth(100);
        confirm.setPrefHeight(40);
        confirm.setLayoutX(100);
        confirm.setLayoutY(300);
        confirm.setOnAction(e->{
            //stage.close();
            //ScreenController.getInstance().activate("Game");

            System.out.println(pw.getText());

            MainController.getInstance().createRoom("服务器", Integer.parseInt(pwField.getText()));
            confirm.setDisable(true);
            confirm.setText("等待接入");

            //new Server("服务器", 10800);
        });
        pane.getChildren().add(confirm);


        Button cancel = new Button("取消");
        cancel.setPrefWidth(100);
        cancel.setPrefHeight(40);
        cancel.setLayoutX(400);
        cancel.setLayoutY(300);
        cancel.setOnAction(e->{
            stage.close();
        });
        pane.getChildren().add(cancel);

        stage.setScene(new Scene(pane,600,400));
        stage.show();

    }

    public void showEnterRoomStage(){
        Stage stage = new Stage();


        Pane pane = new Pane();

        Text title = new Text("进入房间");
        title.setFont(Font.font(30));
        title.setLayoutX(200);
        title.setLayoutY(50);

        pane.getChildren().add(title);

        Text ip = new Text("ip地址");
        ip.setFont(Font.font(30));
        ip.setLayoutX(50);
        ip.setLayoutY(100);

        TextField ipField = new TextField();
        ipField.setPrefSize(200,50);
        ipField.setLayoutX(200);
        ipField.setLayoutY(100);

        pane.getChildren().add(ip);
        pane.getChildren().add(ipField);

        Text pw = new Text("连接码");
        pw.setFont(Font.font(20));
        pw.setLayoutX(50);
        pw.setLayoutY(150);

        TextField pwField = new TextField();
        pwField.setPrefSize(200,50);
        pwField.setLayoutX(200);
        pwField.setLayoutY(150);

        pane.getChildren().add(pw);
        pane.getChildren().add(pwField);


        Button confirm = new Button("确定");
        confirm.setPrefWidth(100);
        confirm.setPrefHeight(40);
        confirm.setLayoutX(100);
        confirm.setLayoutY(300);
        confirm.setOnAction(e->{

            stage.close();
            ScreenController.getInstance().activate("Game");

            MainController.getInstance().enterRoom("客户端", ip.getText(), Integer.parseInt(pwField.getText()));

        });

        pane.getChildren().add(confirm);


        Button cancel = new Button("取消");
        cancel.setPrefWidth(100);
        cancel.setPrefHeight(40);
        cancel.setLayoutX(400);
        cancel.setLayoutY(300);
        cancel.setOnAction(e->{
            stage.close();
        });
        pane.getChildren().add(cancel);

        stage.setScene(new Scene(pane,600,400));
        stage.show();
    }

    public void showHelpStage(){
        Stage stage = new Stage();


        Pane pane = new Pane();

        Text title = new Text("游戏玩法");
        title.setFont(Font.font(30));
        title.setLayoutX(240);
        title.setLayoutY(50);

        pane.getChildren().add(title);

        Text info = new Text(
                "游戏开始时，葫芦娃爷爷和青蛇精对峙于场地两侧。\n"+"" +
                "每方拥有九枚棋子，每个棋子具有两种状态：\n"+
                "\t（1）浅色。该状态下棋子可以向周围八个方向任意移动一格；\n"+"" +
                "\t（2）深色。该状态下棋子可以跳过八个方向内所有相邻棋子，\n"+"" +
                "\t\t但是若没有相邻的棋子则不能移动。\n" +
                "双方轮流行动，每次行动移动一枚本方棋子，棋子移动过后会切换状态。\n"+
                "让所有棋子到达对方三列内获得胜利。");

        info.setFont(Font.font(18));
        info.setLayoutX(30);
        info.setLayoutY(100);

        pane.getChildren().add(info);

        Button confirm = new Button("确定");
        confirm.setPrefWidth(100);
        confirm.setPrefHeight(40);
        confirm.setLayoutX(250);
        confirm.setLayoutY(300);
        confirm.setOnAction(e->{

            stage.close();
        });

        pane.getChildren().add(confirm);


        stage.setScene(new Scene(pane,600,400));
        stage.show();
    }


}
