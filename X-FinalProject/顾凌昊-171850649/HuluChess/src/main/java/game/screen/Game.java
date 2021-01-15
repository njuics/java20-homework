package game.screen;

import com.sun.javafx.geom.Vec2d;
import game.MainController;
import game.ScreenController;
import game.character.data.CharacterData;
import game.character.object.Chess;
import game.map.object.Map;
import game.template.GameScreen;
import game.utils.Vec2Int;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Pane {

    GameScreen screen;

    Map map;

    Chess selected;

    Text turnText;

    public Game(){

        screen = new GameScreen(1200,900);

        map = new Map(1080,360);
        map.setWorldPosition( new Vec2d(60,300));

        screen.addObject(map);

        getChildren().add(screen);


        generateUI();
        startGame();
    }

    public void generateUI(){

        turnText = new Text();
        turnText.setFont(Font.font(20));
        turnText.setLayoutX(50);
        turnText.setLayoutY(50);

        getChildren().add(turnText);

        refreshUI();
    }

    public void refreshUI(){

        if(currentPlayer== CharacterData.Fraction.Huluwa){
            turnText.setText("葫芦娃阵营行动");

        }else{
            turnText.setText("妖精阵营行动");
        }
    }

    public void startGame(){

        MainController.getInstance().gameStart();

        screen.setOnMouseClicked(event -> {

            if(MainController.getInstance().mGameState!= MainController.GameState.GAME_START) return;

            System.out.println("mouse clicked!");
            System.out.println(event.getX()+", "+event.getY());

            Vec2Int loc = map.worldToLocation(new Vec2d(event.getX(), event.getY()));

            if(map.getChessObject(loc) != null){

                if(map.getChessObject(loc).fraction == currentPlayer){
                    selected = map.getChessObject(loc);
                }



            }else{

                if(selected != null && selected.fraction == currentPlayer){

                    if(map.canMoveTo(selected, loc)){

                        map.moveChess(selected, loc);
                        selected = null;

                        endTurn();

                    }
                }

            }

        });


    }


    CharacterData.Fraction currentPlayer = CharacterData.Fraction.Huluwa;

    void endTurn(){

        if(currentPlayer == CharacterData.Fraction.Huluwa){
            currentPlayer = CharacterData.Fraction.Monster;
        }else{
            currentPlayer = CharacterData.Fraction.Huluwa;
        }

        selected = null;

        refreshUI();
        checkWin();
    }

    void checkWin(){

        int result = map.checkWin();

        if(result !=0){

            MainController.getInstance().gameOver();
            showOverStage(result);

        }



    }

    void showOverStage(int result){

        Stage stage = new Stage();

        Pane pane = new Pane();

        Text title = new Text("游戏结束");
        title.setFont(Font.font(50));
        title.setLayoutX(200);
        title.setLayoutY(50);


        pane.getChildren().add(title);

        Text winner = new Text();
        if(result == 1) winner.setText("葫芦娃阵营获胜！");
        else winner.setText("妖精阵营获胜！");

        winner.setFont(Font.font(30));
        winner.setLayoutX(100);
        winner.setLayoutY(200);

        pane.getChildren().add(winner);

        Button confirm = new Button("再来");
        confirm.setPrefWidth(100);
        confirm.setPrefHeight(40);
        confirm.setLayoutX(100);
        confirm.setLayoutY(300);
        confirm.setOnAction(e->{
            stage.close();
            ScreenController.getInstance().activate("Game");

            map.generate();
            MainController.getInstance().gameStart();
        });
        pane.getChildren().add(confirm);

        Button cancel = new Button("离开");
        cancel.setPrefWidth(100);
        cancel.setPrefHeight(40);
        cancel.setLayoutX(400);
        cancel.setLayoutY(300);
        cancel.setOnAction(e->{
            stage.close();

            MainController.getInstance().disconnect();
            ScreenController.getInstance().activate("Menu");
        });
        pane.getChildren().add(cancel);

        stage.setScene(new Scene(pane,600,400));
        stage.show();




    }


}
