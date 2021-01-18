package advancedjava.finalproj.stage;

import advancedjava.finalproj.game.DirectionEnum;

import advancedjava.finalproj.game.Location;
import advancedjava.finalproj.game.handler.GameHandler;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.WindowEvent;
import java.util.Hashtable;

class CreatureLabel extends Label {

    public CreatureLabel(){
        super();
    }

    public void cancelChosen(){
        this.setScaleX(1);
        this.setScaleY(1);
        this.setBorder(null);
    }
}

public class GameStage extends MyStage{
    private int BATTLE_FIELD_WIDTH;
    private int BATTLE_FIELD_HEIGHT;
    public int STAGE_WIDTH;
    public int STAGE_HEIGHT;
    private static final int LOCATION_SIZE=100;
    private static final int BORDER_EXTRA_LEN=30;
    private static final String IMAGE_SUFFIX=".png";

    private GameHandler gameHandler;
    private CreatureLabel[][] battleField;
    private GridPane grid;
    private Label campLabel,stateLabel;
    private Button upBtn,downBtn, leftBtn, rightBtn,attackBtn,defendBtn,giveupBtn;
    private Label currentSelectedLabel;
    private Hashtable<CreatureLabel, Location> creatures;
    private Hashtable<CreatureLabel, ImageView> status;


    public GameStage(GameHandler gamehandler,int BATTLE_FIELD_WIDTH,int BATTLE_FIELD_HEIGHT) {
        this.BATTLE_FIELD_WIDTH=BATTLE_FIELD_WIDTH;
        this.BATTLE_FIELD_HEIGHT=BATTLE_FIELD_HEIGHT;
        this.STAGE_WIDTH=(BATTLE_FIELD_WIDTH)*(LOCATION_SIZE+10)+200;
        this.STAGE_HEIGHT=BATTLE_FIELD_HEIGHT*(LOCATION_SIZE+15)+200;
        this.battleField=new CreatureLabel[BATTLE_FIELD_WIDTH][BATTLE_FIELD_HEIGHT+2];
        this.creatures=new Hashtable<>();
        this.status=new Hashtable<>();

        this.gameHandler=gamehandler;
        //新建一个布局
        grid = new GridPane();
        //布局居中
        grid.setAlignment(Pos.CENTER);
        //布局距离边界的距离
        grid.setPadding(new Insets(10, 10, 10, 10));
        //初始化布局
        initGrid(grid);
        Image bgImage = new Image(getClass().getResourceAsStream("/background.png"));
        BackgroundSize bgSize=new BackgroundSize(STAGE_WIDTH, STAGE_HEIGHT,
                false,false,false,false);
        Background bg=new Background(new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,bgSize));
        grid.setBackground(bg);
        Scene scene = new Scene(grid);

        this.setScene(scene);
        //设置名称
        this.setTitle("BroBattleGame");
        //设置游戏初始大小
        this.setWidth(STAGE_WIDTH);
        this.setHeight(STAGE_HEIGHT);
        //设置固定大小
        this.setResizable(false);
        this.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                gamehandler.showLoginStage();
                gamehandler.handleGameOver();
            }
        });
    }
    //初始化函数
    private static String getImageAddr(String creature,int i){
        return "/"+creature+i+IMAGE_SUFFIX;
    }

    private void initCreatures(GridPane grid,int col,String creature){
        for(int i=1;i<=BATTLE_FIELD_HEIGHT;i++){
            CreatureLabel creatureLabel=new CreatureLabel();
            Image image = new Image(getClass().getResourceAsStream(getImageAddr(creature,i)));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(LOCATION_SIZE);
            imageView.setFitWidth(LOCATION_SIZE);
            creatureLabel.setGraphic(imageView);
            creatureLabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    creatureLabel.setScaleX(1.2);
                    creatureLabel.setScaleY(1.2);
                }
            });
            creatureLabel.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    creatureLabel.setScaleX(1);
                    creatureLabel.setScaleY(1);
                }
            });

            creatureLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(currentSelectedLabel!=null && currentSelectedLabel instanceof CreatureLabel)
                        ((CreatureLabel) currentSelectedLabel).cancelChosen();
                    currentSelectedLabel=creatureLabel;
                    gameHandler.handleChosen(creatures.get(currentSelectedLabel));
                    BorderStroke borderStroke = new BorderStroke(null,null, Color.WHITE,null, null,null, BorderStrokeStyle.SOLID,null,null, BorderWidths.DEFAULT,new Insets(1));
                    Border border=new Border(borderStroke);
                    creatureLabel.setBorder(border);
                }
            });
            grid.add(creatureLabel,col,i);
            creatures.put(creatureLabel,new Location(col,i));
            battleField[col][i]=creatureLabel;
        }
    }

    private void initBros(GridPane grid){
        initCreatures(grid,0,"Bro");
    }

    private void initMonsters(GridPane grid){
        initCreatures(grid,BATTLE_FIELD_WIDTH-1,"Monster");
    }

    //初始化最上面一行，用填充Label
    private void initBorders(GridPane grid){
        for(int i=0;i<BATTLE_FIELD_WIDTH;i++) {
            Label border=new Label();
            border.setMinSize(LOCATION_SIZE,LOCATION_SIZE+BORDER_EXTRA_LEN);
            border.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(currentSelectedLabel!=null && currentSelectedLabel instanceof CreatureLabel)
                        ((CreatureLabel) currentSelectedLabel).cancelChosen();
                    currentSelectedLabel=null;
                }
            });
            grid.add(border,i,0);
        }
    }

    //初始化最下面一行，有按钮和Label
    private void initButtons(GridPane grid){
        Label border1=new Label();
        border1.setMinSize(LOCATION_SIZE,LOCATION_SIZE+BORDER_EXTRA_LEN);
        grid.add(border1,0,BATTLE_FIELD_HEIGHT+1);
        campLabel=new Label("我方阵营"+"\n");
        campLabel.setFont(new Font("Cambria", 25));
        campLabel.setTextFill(Color.ALICEBLUE);
        stateLabel=new Label();
        stateLabel.setFont(new Font("Cambria", 25));
        stateLabel.setTextFill(Color.ALICEBLUE);

        upBtn=new Button("上移");
        initButton(upBtn);
        leftBtn=new Button("左行");
        initButton(leftBtn);
        downBtn=new Button("下移");
        initButton(downBtn);
        rightBtn=new Button("右行");
        initButton(rightBtn);

        attackBtn=new Button("攻击");
        initButton(attackBtn);
        defendBtn=new Button("防御");
        initButton(defendBtn);
        giveupBtn=new Button("投降");
        initButton(giveupBtn);

        upBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleMove(creatures.get(currentSelectedLabel),DirectionEnum.UP);
            }
        });

        leftBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleMove(creatures.get(currentSelectedLabel),DirectionEnum.LEFT);
            }
        });

        rightBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleMove(creatures.get(currentSelectedLabel),DirectionEnum.RIGHT);
            }
        });

        downBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleMove(creatures.get(currentSelectedLabel),DirectionEnum.DOWN);
            }
        });

        attackBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleAttack(creatures.get(currentSelectedLabel));
            }
        });

        defendBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null)
                    gameHandler.handleDefense(creatures.get(currentSelectedLabel));
            }
        });

        giveupBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameHandler.handleGiveUp();
            }
        });

        grid.add(upBtn,1,BATTLE_FIELD_HEIGHT+1);
        grid.add(leftBtn,2,BATTLE_FIELD_HEIGHT+1);
        grid.add(rightBtn,3,BATTLE_FIELD_HEIGHT+1);
        grid.add(downBtn,4,BATTLE_FIELD_HEIGHT+1);
        grid.add(attackBtn,5,BATTLE_FIELD_HEIGHT+1);
        grid.add(defendBtn,6,BATTLE_FIELD_HEIGHT+1);
        grid.add(giveupBtn,7,BATTLE_FIELD_HEIGHT+1);
        grid.add(stateLabel,8,BATTLE_FIELD_HEIGHT+1);
        grid.add(campLabel,9,BATTLE_FIELD_HEIGHT+1);
    }

    private Label getPadLabel(){
        Label label = new Label();
        label.setMinSize(LOCATION_SIZE,LOCATION_SIZE);
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(currentSelectedLabel!=null && currentSelectedLabel instanceof CreatureLabel)
                    ((CreatureLabel) currentSelectedLabel).cancelChosen();
                currentSelectedLabel=null;
            }
        });
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setVgrow(label, Priority.ALWAYS);
        return label;
    }

    private void initGrid(GridPane grid){
        for(int j=1;j<BATTLE_FIELD_WIDTH;j++)
            for(int i=1;i<=BATTLE_FIELD_HEIGHT;i++) {
                Label location = getPadLabel();
                grid.add(location, j, i, 1, 1);
            }
        initBorders(grid);  initButtons(grid);
        initBros(grid);     initMonsters(grid);
    }

    private CreatureLabel getCreatureFromLoc(Location loc){
        return battleField[loc.getX()][loc.getY()];
    }

    //交互函数
    //ProcessStartMsg的时候用
    public void setCampLabel(String camp){
        campLabel.setText(campLabel.getText()+camp);
    }

    //HandleChosen的时候用
    public void setStateLabel(String state){
        stateLabel.setText(state);
    }

    public void setDefendBtnText(String str){
        this.defendBtn.setText(str);
    }

    public void move(Location srcLoc, Location destLoc){
        CreatureLabel targetCreature=getCreatureFromLoc(srcLoc);
        if(targetCreature!=null && targetCreature instanceof CreatureLabel){
                //同时移动人物和状态
                //先从原位置删除
                grid.getChildren().remove(targetCreature);
                if(status.get(targetCreature)!=null)
                    grid.getChildren().remove(status.get(targetCreature));
                //再从新位置添加
                if(status.get(targetCreature)!=null)
                    grid.add(status.get(targetCreature),destLoc.getX(),destLoc.getY());
                grid.add(targetCreature,destLoc.getX(),destLoc.getY());
                //在原位置上添加填充
                grid.add(getPadLabel(),srcLoc.getX(),srcLoc.getY());
                battleField[srcLoc.getX()][srcLoc.getY()]=null;
                battleField[destLoc.getX()][destLoc.getY()]=targetCreature;
                creatures.get(targetCreature).setLocation(destLoc.getX(),destLoc.getY());
        }
    }

    public void rotateLabel(Location loc,int angle){
        CreatureLabel targetCreature=getCreatureFromLoc(loc);
        targetCreature.setRotate(angle);
    }

    public void setStatusGif(Location loc,String gifAddr){
        ImageView statusGif=new ImageView(new Image(getClass().getResourceAsStream(gifAddr),LOCATION_SIZE,LOCATION_SIZE,false,false));
        CreatureLabel creature=getCreatureFromLoc(loc);
        grid.getChildren().remove(creature);
        if(status.get(creature)!=null){
            grid.getChildren().remove((status.get(creature)));
            status.remove(creature);
        }
        grid.add(statusGif,loc.getX(),loc.getY());
        grid.add(creature,loc.getX(),loc.getY());
        status.put(creature,statusGif);
    }

    public void clearStatusGif(Location loc){
        CreatureLabel creature=getCreatureFromLoc(loc);
        if(status.get(creature)!=null){
            grid.getChildren().remove(status.get(creature));
            status.remove(creature);
        }
    }

}
