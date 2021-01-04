package nju.zjl.cvs.client;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nju.zjl.cvs.game.Constants;
import nju.zjl.cvs.game.Constants.Camp;
import nju.zjl.cvs.game.Creature;
import nju.zjl.cvs.game.GameController;
import nju.zjl.cvs.game.Instruction;
import nju.zjl.cvs.game.ItemManager;
import nju.zjl.cvs.game.Operation;



public class GUI extends Application{
    public void start(Stage primaryStage) throws Exception{
        StackPane stackPane = new StackPane();
        bgCanvas = new Canvas(Constants.COLUMNS * Constants.GRIDWIDTH, Constants.ROWS * Constants.GRIDHEIGHT);
        gameCanvas = new Canvas(Constants.COLUMNS * Constants.GRIDWIDTH, Constants.ROWS * Constants.GRIDHEIGHT);
        uiCanvas = new Canvas(Constants.COLUMNS * Constants.GRIDWIDTH, Constants.ROWS * Constants.GRIDHEIGHT);
        stackPane.getChildren().addAll(bgCanvas, gameCanvas, uiCanvas);

        info = new TextArea();
        info.setEditable(false);
        info.setWrapText(true);

        gameButton = new Button("New Game");
        recordButton = new Button("Load Record");

        HBox hlayout = new HBox(20, gameButton, recordButton);
        hlayout.setAlignment(Pos.CENTER);
        VBox vlayout = new VBox(20, hlayout, info);
        vlayout.setPrefWidth(250);

        HBox root = new HBox(20);
        root.getChildren().addAll(stackPane, vlayout);
        Scene scene = new Scene(root);

        info.prefHeightProperty().bind(vlayout.heightProperty());
        vlayout.prefHeightProperty().bind(root.heightProperty());

        primaryStage.setTitle("Calabash Vs Monster");
        primaryStage.setScene(scene);
        primaryStage.show();
        stage = primaryStage;

        initBackground();
        initEventHandler();

        Platform.setImplicitExit(false);
    }

    protected void newGame(){
        select = -1;
        items = new ItemManager();
        items.initDefaultCreatures();
        gameOp = new GameOperator();
        game = new GameController(items, gameOp, this::gameOver);
        drawer = new DrawController(items, gameCanvas);

        info.appendText(String.format("Connecting to server.%n"));

        new Thread(() -> {
            gameOp.connect("121.4.28.220", 23456, this::establishConnection, this::beginGame);
        }).start();
    }

    protected void loadRecord(){
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        chooser.setTitle("Seclect Record File");
        File record = chooser.showOpenDialog(stage);
        if(record == null){
            info.appendText(String.format("No record file selected.%n"));
            status = "";
            return;
        }

        RecordOperator recordOp = new RecordOperator();
        if(recordOp.readRecord(record)){
            info.appendText(String.format("Successfully load record.%n"));
            items = new ItemManager();
            items.initDefaultCreatures();
            game = new GameController(items, recordOp, this::recordOver);
            drawer = new DrawController(items, gameCanvas);

            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(drawer);
            exec.execute(game);
            exec.shutdown();
        }
        else{
            info.appendText(String.format("Failed to load record file, please check its legitimacy.%n"));
            status = "";
        }

    }

    protected void gameOver(Camp winner){
        Platform.runLater(() -> {
            drawer.terminate();
            gameOp.terminate();
            info.appendText(String.format("Game Over, you %s.%n", (winner == camp ? "win" : "lose")));
            String ret = gameOp.saveRecord();
            if(ret == null){
                info.appendText(String.format("Failed to save record.%n"));
            }
            else{
                info.appendText(String.format("Successfully save record to '%s'.%n", ret));
            }
            status = "";
        });
    }

    protected void establishConnection(Boolean success){
        Platform.runLater(() -> {
            if(Boolean.TRUE.equals(success)){
                info.appendText(String.format("Connection established, matching player.%n"));
            }
            else{
                info.appendText(String.format("Failed to connect to server.%n"));
                status = "";
            }
        });
    }

    protected void beginGame(Camp c){
        Platform.runLater(() -> {
            info.appendText(String.format("Match successfully, your camp is %s.%n", c.name()));

            camp = c;
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(gameOp);
            exec.execute(drawer);
            exec.execute(game);
            exec.shutdown();
        });
    }

    protected void recordOver(Camp winner){
        Platform.runLater(() -> {
            drawer.terminate();
            info.appendText(String.format("Record Over, %s win.%n", winner.toString()));
            status = "";
        });
    }

    protected void initEventHandler(){
        stage.setOnCloseRequest(e -> {
            switch(status){
                case "game":
                    game.terminate();
                    drawer.terminate();
                    gameOp.terminate();
                    break;
                case "record":
                    game.terminate();
                    drawer.terminate();
                    break;
                default:
                    break;
            }
            Platform.exit();
        });

        gameButton.setOnMouseClicked(e -> {
            if(status == "") {
                status = "game";
                newGame();
            }
        });

        recordButton.setOnMouseClicked(e -> {
            if(status == "") {
                status = "record";
                loadRecord();
            }
        });

        uiCanvas.setOnMouseClicked(e -> {
            if(status != "game"){
                return;
            }
            if(e.getButton() == MouseButton.PRIMARY){
                leftMouseClickEvent(Constants.bulletPos2CreaturePos((int)e.getX(), (int)e.getY()));
                e.consume();
            }
        });
    }

    protected void initBackground(){
        GraphicsContext gc = bgCanvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        for(int i = 0; i < Constants.ROWS; i++){
            for(int j = 0; j < Constants.COLUMNS; j++){
                if(i % 2 != j % 2){
                    gc.fillRect(j * Constants.GRIDWIDTH, i * Constants.GRIDHEIGHT, Constants.GRIDWIDTH, Constants.GRIDHEIGHT);
                }
            }
        }
    }

    protected void leftMouseClickEvent(int pos){
        if(select == -1 || items.getCreatureById(select) == null){
            Creature c = items.getCreatureByPos(pos);
            if(c != null && c.getCamp() == camp){
                select = c.getId();
            }
            else{
                select = -1;
            }
        }
        else{
            Creature t = items.getCreatureByPos(pos);
            if(t == null){
                gameOp.sendOperation(new Operation(select, Instruction.newMoveInst(pos)));
            }
            else if(t.getCamp() == camp){
                select = t.getId();
            }
            else if(t.getCamp() != camp){
                gameOp.sendOperation(new Operation(select, Instruction.newAttackInst(t.getId())));
            }
        }
        
    }

    protected Stage stage;

    protected Button gameButton;
    protected Button recordButton;
    protected Canvas bgCanvas;
    protected Canvas gameCanvas;
    protected Canvas uiCanvas;
    protected TextArea info;

    protected String status = "";

    protected int select = -1;
    protected Camp camp = null;
    protected ItemManager items;
    protected GameOperator gameOp;
    protected RecordOperator recordOp;
    protected GameController game;
    protected DrawController drawer;
}
