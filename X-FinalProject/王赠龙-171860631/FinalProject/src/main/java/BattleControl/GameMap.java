package BattleControl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import Creature.Creature;
import Creature.Type;
import Record.FrameRecord;
import Record.RecordSample;
import javafx.util.Duration;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class GameMap implements BattleConfig{
    private GraphicsContext gc;//在canvas上的绘图工具
    private GameState gameState;
    private Image background;
    private Image evilWin;
    private Image justiceWin;
    private Image gamePause;
    private Creature[][] creatureArray;//16*12,为了保证canvas的坐标系与作业要求的坐标系一致
    private HashMap<String,Image> stringImageHashMap;
    private ObjectOutputStream logWriter;//每次刷新就向文件写
    private ObjectInputStream logReader;
    private Timeline reviewTimeline;

    public GameMap(GraphicsContext gc,GameState gameState){
        creatureArray=new Creature[COLUMN_NUM][ROW_NUM];
        this.gc=gc;
        background=new Image(this.getClass().getClassLoader().getResource("picture/scene/background.jpg").toString());
        evilWin=new Image(this.getClass().getClassLoader().getResource("picture/scene/EvilWin.png").toString());
        justiceWin=new Image(this.getClass().getClassLoader().getResource("picture/scene/JusticeWin.png").toString());
        gamePause=new Image(this.getClass().getClassLoader().getResource("picture/scene/GamePause.png").toString());
        this.gameState=gameState;

        stringImageHashMap=new HashMap<String,Image>();
        stringImageHashMap.put("Grandpa",new Image(this.getClass().getClassLoader().getResource("picture/creature/Grandpa.png").toString()));
        stringImageHashMap.put("Scorpion",new Image(this.getClass().getClassLoader().getResource("picture/creature/Scorpion.png").toString()));
        stringImageHashMap.put("Snake",new Image(this.getClass().getClassLoader().getResource("picture/creature/Snake.png").toString()));
        for(int i=1;i<=7;i++){
            stringImageHashMap.put("No"+i,new Image(this.getClass().getClassLoader().getResource("picture/creature/No"+i+".png").toString()));
        }
        for(int i=1;i<=10;i++){
            stringImageHashMap.put("Centipede"+i,new Image(this.getClass().getClassLoader().getResource("picture/creature/Centipede"+i+".png").toString()));
        }
    }
    public void initCreatureArray(ArrayList<Creature> startCreatureArray){
        for(Creature creature:startCreatureArray){
            setCreature(creature.getPosX(),creature.getPosY(),creature);
        }
       // initBackGround();
        display();
    }
    public boolean isInMap(int x,int y){
        if(x>=0&&x<COLUMN_NUM&&y>=0&&y<ROW_NUM)return true;
        return false;
    }
    private void initBackGround(){//绘制背景图片与坐标格线
        gc.drawImage(background,0,0,CANVAS_WIDTH,CANVAS_HEIGHT);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(GRID_LINE_WIDTH);
        for(int i=0;i<=ROW_NUM;i++){
            gc.strokeLine(0,i*UNIT_SIZE,CANVAS_WIDTH,i*UNIT_SIZE);
        }
        for(int i=0;i<=COLUMN_NUM;i++){
            gc.strokeLine(i*UNIT_SIZE,0,i*UNIT_SIZE,CANVAS_HEIGHT);
        }
    }
    public void setCreature(int x,int y,Creature creature){
        //synchronized (creatureArray) {
            if (isInMap(x, y) && creatureArray[x][y] == null) {
                creatureArray[x][y] = creature;
            }
       // }
    }
    public boolean noCreatureAt(int x,int y){
        //synchronized (creatureArray) {
            return creatureArray[x][y] == null;
       // }
    }
    public Creature getCreature(int x,int y){
        //synchronized (creatureArray) {
            if (isInMap(x, y) && !noCreatureAt(x, y)) return creatureArray[x][y];
            return null;
       // }
    }
    public void clearMap(){
        for(int i=0;i<COLUMN_NUM;i++){
            for(int j=0;j<ROW_NUM;j++)
                creatureArray[i][j]=null;
        }
    }
    public void removeCreature(int x,int y){
        //synchronized (creatureArray) {
            if (isInMap(x, y)) creatureArray[x][y] = null;
      //  }
    }
    public void display() {
        initBackGround();
        int justiceCreatureNum=0;
        int evilCreatureNum=0;
        FrameRecord frameRecord=new FrameRecord();

        synchronized (this){
        if (!gameState.getIsReviewed()) {//非回放时的显示
                if (!gameState.getIsStart() || (gameState.getIsStart() && !gameState.getIsPaused())) {//未开始或者游戏已经开始但是未暂停
                    //  synchronized (creatureArray) {
                    for (int i = 0; i < COLUMN_NUM; i++) {
                        for (int j = 0; j < ROW_NUM; j++) {
                            Creature tempCreature=creatureArray[i][j];
                            if( tempCreature!= null) {
                                synchronized (tempCreature) {
                                    if (creatureArray[i][j].isAlive()) {
                                        RecordSample recordSample=new RecordSample(i,j,tempCreature.getHp(),tempCreature.getMaxHp(),tempCreature.getIsControlled(),tempCreature.getName());
                                        frameRecord.frameArraylist.add(recordSample);
                                        if(tempCreature.getType().equals(Type.JUSTICE))justiceCreatureNum++;
                                        else evilCreatureNum++;
                                        double startX = i * UNIT_SIZE;
                                        double startY = j * UNIT_SIZE;
                                        gc.drawImage(creatureArray[i][j].getImage(), startX, startY, UNIT_SIZE, UNIT_SIZE);
                                        if (creatureArray[i][j].getIsControlled()) {
                                            gc.setFill(Color.rgb(0, 255, 0, 0.3));
                                            gc.fillRect(startX, startY, UNIT_SIZE - 1, UNIT_SIZE - 1);
                                        }
                                        double greenLength = creatureArray[i][j].getHp() /creatureArray[i][j].getMaxHp()  * (UNIT_SIZE - 2);//计算人物血条中绿色的长度
                                        gc.setFill(Color.rgb(0, 255, 0, 1));
                                        gc.fillRect(startX + 1, startY, greenLength, 5);
                                        gc.setFill(Color.rgb(255, 0, 0, 1));
                                        gc.fillRect(startX + 1 + greenLength, startY, UNIT_SIZE - 2 - greenLength, 5);
                                    } else {
                                        removeCreature(i, j);
                                    }
                                }
                            }
                        }
                    }
                    //   }
                } else if (gameState.getIsStart() && gameState.getIsPaused()) {//游戏开始之后暂停则绘制暂停图片
                    gc.drawImage(gamePause, (CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
                }
                /*
                else if (gameState.getGameOver()) {
                    if (gameState.getWinner().equals(Type.JUSTICE)) {
                        gc.drawImage(justiceWin, (CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
                    } else {
                        gc.drawImage(evilWin, (CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
                    }
                }*/
            }
        }
        if(justiceCreatureNum==0||evilCreatureNum==0){
            gameState.setGameOver(true);
            gameState.setIsStarted(false);

            frameRecord.isGameEnd=true;
            if(justiceCreatureNum==0){
                gameState.setWinner(Type.EVIL);
                frameRecord.winner=Type.EVIL;
                gc.drawImage(evilWin,(CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
            }
            else{
                gameState.setWinner(Type.JUSTICE);
                frameRecord.winner=Type.JUSTICE;
                gc.drawImage(justiceWin,(CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
            }

            try {
                logWriter.writeObject(frameRecord);
                System.out.println("写入最后一帧");
            } catch (IOException e) {
                e.printStackTrace();
            }
            synchronized (gameState) {
                gameState.notifyAll();//唤醒侦听线程
            }
            return;
        }
        if(gameState.getIsStart() && !gameState.getIsPaused()) {
            try {
                logWriter.writeObject(frameRecord);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void setLogWriter(ObjectOutputStream logWriter){
        this.logWriter=logWriter;
    }
    public void setLogReader(ObjectInputStream logReader){
        this.logReader=logReader;
    }
    public void startReview(){
        reviewTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FrameRecord record=getRecord();
                        reviewPlay(record);
                    }
                }), new KeyFrame(Duration.millis(1000 / REFRESH_RATE))
        );
        reviewTimeline.setCycleCount(Timeline.INDEFINITE);
        reviewTimeline.play();
    }
    public FrameRecord getRecord(){
        FrameRecord record=null;
        try{
            record=(FrameRecord)logReader.readObject();
        }
        catch(EOFException e){//文件读完了
            reviewTimeline.stop();
            gameState.setIsReviewed(false);
            try {
                logReader.close();
            } catch (IOException ee) {
                ee.printStackTrace();
            }
            return null;
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return record;
    }
    public void reviewPlay(FrameRecord record){
        if(record==null)return;
        initBackGround();
        for(RecordSample sample:record.frameArraylist){
            double startX=sample.posX*UNIT_SIZE;
            double startY=sample.posY*UNIT_SIZE;
            Image tempImage=stringImageHashMap.get(sample.name);
            gc.drawImage(tempImage,startX,startY,UNIT_SIZE,UNIT_SIZE);
            if (sample.isControlled) {
                gc.setFill(Color.rgb(0, 255, 0, 0.3));
                gc.fillRect(startX, startY, UNIT_SIZE - 1, UNIT_SIZE - 1);
            }
            double greenLength = sample.hp/ sample.maxHp * (UNIT_SIZE - 2);//计算人物血条中绿色的长度
            gc.setFill(Color.rgb(0, 255, 0, 1));
            gc.fillRect(startX + 1, startY, greenLength, 5);
            gc.setFill(Color.rgb(255, 0, 0, 1));
            gc.fillRect(startX + 1 + greenLength, startY, UNIT_SIZE - 2 - greenLength, 5);
        }
        if(record.isGameEnd){
            System.out.println("review end");
            if(record.winner.equals(Type.JUSTICE)){
                gc.drawImage(justiceWin,(CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
            }
            else{
                gc.drawImage(evilWin,(CANVAS_WIDTH - SCENE_WIDTH) / 2, (CANVAS_HEIGHT - SCENE_HEIGHT) / 2, SCENE_WIDTH, SCENE_HEIGHT);
            }
        }

    }
    public int posXByName(String name){
        for (int i = 0; i < COLUMN_NUM; i++) {
            for (int j = 0; j < ROW_NUM; j++) {
                if(creatureArray[i][j]!=null&&creatureArray[i][j].getName().equals(name))  {
                    return i;
                }
            }
        }
        return -1;
    }
    public int posYByName(String name){
        for (int i = 0; i < COLUMN_NUM; i++) {
            for (int j = 0; j < ROW_NUM; j++) {
                if(creatureArray[i][j]!=null&&creatureArray[i][j].getName().equals(name))  {
                    return j;
                }
            }
        }
        return -1;
    }

}
