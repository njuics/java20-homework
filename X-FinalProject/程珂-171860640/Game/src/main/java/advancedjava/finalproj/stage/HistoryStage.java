package advancedjava.finalproj.stage;

import advancedjava.finalproj.game.handler.GameHandler;
import advancedjava.finalproj.logger.LogDir;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class HistoryStage extends MyStage {
    private Button backBtn;
    private Button confirmBtn;
    private GameHandler gameHandler;
    private String fileName;
    private ObservableList<String> items;
    public static final int STAGE_WIDTH=550;
    public static final int STAGE_HEIGHT=800;
    private static final int BUTTON_GAP=800;

    LogDir logDir;

    public HistoryStage(GameHandler gameHandler){
        this.gameHandler=gameHandler;

        //加载标题
        Label titleLabel=new Label("战斗记录");
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setFont(new Font("Cambria", 30));
        titleLabel.setMinSize(550,50);

        //初始化
        logDir=new LogDir();

        //加载列表
        ListView<String> list = new ListView<>();
        items = FXCollections.observableArrayList ();
        list.setItems(items);
        list.setFixedCellSize(50);

        //初始化按钮
        backBtn=new Button("返回上页");initButton(backBtn);
        backBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameHandler.showLoginStage();
                gameHandler.closeHistoryStage();
            }
        });

        confirmBtn =new Button("确认载入");initButton(confirmBtn);
        confirmBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fileName=list.getSelectionModel().getSelectedItem().toString();
                gameHandler.handleGameLoad(fileName);
            }
        });

        //加载底层Grid布局
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        //Button Location
        grid.add(backBtn,0,0);
        grid.add(confirmBtn,1,0);
        grid.setHgap(BUTTON_GAP);

        //加载BorderPane布局
        BorderPane pane=new BorderPane();
        pane.setTop(titleLabel);
        pane.setCenter(list);
        pane.setBottom(grid);
        Scene scene=new Scene(pane);

        //加载自身布局
        this.setScene(scene);
        this.setMinWidth(STAGE_WIDTH);
        this.setMinHeight(STAGE_HEIGHT);
        this.setTitle("History");
    }

    public void flush(){
        if(logDir!=null){
            items.clear();
            items.addAll(logDir.loadCatalog());
        }
    }
}
