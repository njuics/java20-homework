package advancedjava.finalproj.stage;

import advancedjava.finalproj.game.handler.GameHandler;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


public class LogInStage extends MyStage {
    public static final int STAGE_WIDTH=660*2;
    public  final int STAGE_HEIGHT=500*2;
    private static final int CENTER_IMAGE_WIDTH=210*5;
    private static final int CENTER_HEIGHT=130*5;
    private static final String CENTER_IMAGE_ADDR="/LogInCenter.png";
    private static final String BG_IMAGE_ADDR="/LogInBackGround.png";

    private Button exitBtn;
    private Button loadHisBtn;
    private Button startBtn;

    private GameHandler gameHandler;


    public LogInStage(GameHandler gameHandler){

        this.gameHandler=gameHandler;
        //加载中心图片 : 葫芦娃
        Image loginCenter=new Image(getClass().getResourceAsStream(CENTER_IMAGE_ADDR));
        ImageView loginCenterView=new ImageView(loginCenter);
        loginCenterView.setFitWidth(CENTER_IMAGE_WIDTH);loginCenterView.setFitHeight(CENTER_HEIGHT);
        Label centerLabel=new Label();
        centerLabel.setGraphic(loginCenterView);

        //加载背景图片 : 战场
        Image bgImage = new Image(getClass().getResourceAsStream(BG_IMAGE_ADDR));
        BackgroundSize bgSize=new BackgroundSize(STAGE_WIDTH,STAGE_HEIGHT,
                false,false,false,false);
        Background bg=new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bgSize));

        //加载按钮
        startBtn=new Button("开始匹配");initButton(startBtn);
        startBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameHandler.handleGameStart();
            }});

        loadHisBtn=new Button("加载历史");initButton(loadHisBtn);
        loadHisBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameHandler.showHistoryStage();
                gameHandler.closeLoginStage();
            }});

        exitBtn=new Button("退出游戏");initButton(exitBtn);
        exitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameHandler.closeLoginStage();
            }});

        //加载按钮到grid中
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(startBtn,0,0);
        grid.add(loadHisBtn,1,0);
        grid.add(exitBtn,2,0);

        //设置行间距
        grid.setHgap(100);

        //加载布局
        //布局居中
        BorderPane pane = new BorderPane();
        pane.setCenter(centerLabel);
        pane.setBackground(bg);
        pane.setBottom(grid);

        //加载Scene
        Scene scene=new Scene(pane);

        //加载Stage
        this.setTitle("Log in");this.setScene(scene);
        this.setMinWidth(STAGE_WIDTH);this.setMinHeight(STAGE_HEIGHT);
        this.setResizable(false);
    }
}


