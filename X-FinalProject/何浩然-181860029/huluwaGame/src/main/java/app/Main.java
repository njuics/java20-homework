package app;

import control.Action;
import control.KeyboardAction;
import control.MouseAction;
import control.SkillAction;
import creature.*;
import field.BattleField;
import io.RecordReader;
import io.RecordWriter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import notification.MainNotificationController;
import notification.UpperNotificationController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    public static final int WIDTH_UNIT = 13;
    public static final int HEIGHT_UNIT = 11;
    public static final int UNIT_LENGTH = 60;

    private static UpperNotificationController unc = new UpperNotificationController();
    private static MainNotificationController mnc = new MainNotificationController();

    private BattleField bf = new BattleField(WIDTH_UNIT,HEIGHT_UNIT);

    private List<Creature> creatures = new ArrayList<>();
    private SnakeWoman snakeWoman = SnakeWoman.getInstance();

    private static List<Action> actions = new ArrayList<>();
    private static long recordStartTime;

    public enum GameType {NOT_BEGIN,PLAY,REPLAY, FINISH}
    private static GameType type = GameType.NOT_BEGIN;

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("huluwa VS shejing pangxiejing and monsters");
        primaryStage.setHeight(HEIGHT_UNIT*UNIT_LENGTH+22);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/hp.css").toExternalForm());
        primaryStage.setScene(scene);

        Canvas canvas = new Canvas(WIDTH_UNIT*UNIT_LENGTH,HEIGHT_UNIT*UNIT_LENGTH);
        root.getChildren().add(canvas);

        bf.getBfs().draw(UNIT_LENGTH,canvas,root);
        bf.setMainController(this);


        for(int i=1;i<=7;i++){
            CalabashMan man = CalabashMan.getInstance(i);
            creatures.add(man);
            root.getChildren().addAll(man.getSprite().getProfileImage(),man.getSprite().getHpBar());
            man.enterBattleField(bf,1,i+1);
        }

        GrandFather grandFather = GrandFather.getInstance();
        root.getChildren().addAll(grandFather.getSprite().getProfileImage(),grandFather.getSprite().getHpBar());
        grandFather.enterBattleField(bf,0,HEIGHT_UNIT/2);
        creatures.add(grandFather);

        root.getChildren().addAll(snakeWoman.getSprite().getProfileImage(), snakeWoman.getSprite().getHpBar());
        snakeWoman.enterBattleField(bf,WIDTH_UNIT-1,HEIGHT_UNIT/2);
        creatures.add(snakeWoman);
        root.getChildren().add(snakeWoman.getFss().getFireImage());
        snakeWoman.setBf(bf);

        ScorpionMan scorpionMan = ScorpionMan.getInstance();
        root.getChildren().addAll(scorpionMan.getSprite().getProfileImage(),scorpionMan.getSprite().getHpBar());
        scorpionMan.enterBattleField(bf,WIDTH_UNIT-4,HEIGHT_UNIT/2);
        creatures.add(scorpionMan);

        List<Minion> minions = new ArrayList<>();
        for(int i=1;i<=Minion.TOTAL_NUM;i++){
            Minion minion = Minion.getInstance(i);
            minions.add(minion);
            root.getChildren().addAll(minion.getSprite().getProfileImage(),minion.getSprite().getHpBar());
            minion.enterBattleField(bf,WIDTH_UNIT-(i%3+1),(i<=3?-1:1)*(3-i%3)+HEIGHT_UNIT/2);
            creatures.add(minion);
        }

        unc.draw(root,UNIT_LENGTH,WIDTH_UNIT,HEIGHT_UNIT);
        mnc.draw(root,UNIT_LENGTH,WIDTH_UNIT,HEIGHT_UNIT);
        mnc.show("1、按下空格键开始游戏，游戏过程会自动保存。\n" +
                "2、按下L键可选择一个文件进行回放。\n" +
                "3、在游戏过程中，您可以使用鼠标选中任意存活的正方角色，然后通过W、S、A、D键控制其行动。\n" +
                "4、任意一方被全部击败时游戏结束，另一方获胜。");
        snakeWoman.getFss().hide();

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(type == GameType.PLAY){
                    Platform.runLater(()->{
                        actionMouseClickedHandle((int)event.getX(),(int)event.getY());
                        actions.add(new MouseAction(System.nanoTime()-recordStartTime,(int)event.getX(),(int)event.getY()));
                    });
                }
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(type == GameType.NOT_BEGIN){
                    if(event.getCode() == KeyCode.SPACE){
                        actions.clear();
                        recordStartTime = System.nanoTime();
                        mnc.hide();
                        unc.show("       游戏开始");
                        setType(GameType.PLAY,false);
                        for (Creature creatureThread : creatures) {
                            creatureThread.start();
                        }
                        creatures.clear();
                    }else if (event.getCode()==KeyCode.L){
                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("选择一个回放文件");
                        File file = fileChooser.showOpenDialog(primaryStage);
                        if(file==null){
                            return;
                        }

                        List<Action> replayActions = RecordReader.read(file);
                        recordStartTime = System.nanoTime();
                        mnc.hide();
                        unc.show("       回放开始");
                        setType(GameType.REPLAY,false);
                        for (Creature creatureThread : creatures) {
                            creatureThread.start();
                        }
                        creatures.clear();
                        replayActionsHandler(replayActions);
                    }
                }
                else if(type == GameType.PLAY){
                    if(event.getCode()==KeyCode.W||
                    event.getCode()==KeyCode.S||
                    event.getCode()==KeyCode.A||
                    event.getCode()==KeyCode.D){
                        Platform.runLater(()->{
                            actionKeyPressedHandle(event.getCode());
                            actions.add(new KeyboardAction(System.nanoTime()-recordStartTime,event.getCode()));
                        });
                    }
                }
            }
        });


        primaryStage.show();
    }


    public static UpperNotificationController getUnc() {
        return unc;
    }

    public static MainNotificationController getMnc() {
        return mnc;
    }

    public void setType(GameType type,boolean save){
        this.type = type;
        if(type == GameType.FINISH){
            snakeWoman.stopSkill();
            if(save){
                RecordWriter.write(actions);
            }
        }
    }

    public synchronized static GameType getType(){
        return type;
    }

    private void actionMouseClickedHandle(int x,int y){
        bf.clickOn(x/UNIT_LENGTH,y/UNIT_LENGTH);
    }

    private void actionKeyPressedHandle(KeyCode code){


        Creature creature = bf.getCurrentSelectCreature();
        if(creature!=null){
            switch (code) {
                case W:
                    creature.moveUp();
                    break;
                case S:
                    creature.moveDown();
                    break;
                case A:
                    creature.moveLeft();
                    break;
                case D:
                    creature.moveRight();
                    break;
            }
        }
    }

    private void replayActionsHandler(List<Action> replayActions){
        for(Action action:replayActions){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    if(action instanceof KeyboardAction){
                        actionKeyPressedHandle(((KeyboardAction) action).getCode());
                    }else if(action instanceof MouseAction){
                        actionMouseClickedHandle(((MouseAction) action).getX(),((MouseAction) action).getY());
                    }else if(action instanceof SkillAction){
                        snakeWoman.startSkill();
                    }
                }
            },action.getTime()/1000000);
        }
    }

    public static void hasSnakeWomanStartSkill(){
        Platform.runLater(()->{
            actions.add(new SkillAction(System.nanoTime()-recordStartTime));
        });
    }
}
