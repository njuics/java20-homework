package huluwa;

import java.io.IOException;
import java.util.List;

import huluwa.Client.PlayerClient;
import huluwa.Creature.Creature;
import huluwa.Protocol.MoveMsg;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

//将战场上的一个(有生物体的)格子看成该类的一个对象，实际上是一个VBOX盒子
public class BattlefieldGrid {
    public VBox vbox;
    private Button button;  //用鼠标点击该格子即选中之（若存在生物），之后可控制生物进行移动或攻击
    private ProgressBar hpBar;  //进度条控件，显示生物当前血量情况
    //private String name;  //这个格子上对应的生物的姓名
    public Creature creature;  //在这个格子上的生物体
    //public enum Dir{UP, DOWN, LEFT, RIGHT} 用1~4代替上下左右
    private PlayerClient pc;
    
    public BattlefieldGrid(Creature c,PlayerClient pc) {
        this.pc = pc;
        creature = c;
        vbox = new VBox();
        button = new Button();
        hpBar = new ProgressBar();
        
        //设置Button控件
        String fileName = "file:resource//" + creature.getName() + ".png";
        Image image = new Image(fileName);
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(40);
        imageview.setFitWidth(50);
        button.setGraphic(imageview);

        DropShadow shadow = new DropShadow();  //当鼠标移动到Button上时添加阴影效果
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            button.setEffect(shadow);
        });
        button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            button.setEffect(null);
        });

        button.setOnKeyReleased(e -> {
            //移动、攻击，死亡了要干啥干啥
            switch (e.getCode()) {
                case W: {
                    moveWithRecord(1); 
                    MoveMsg msg = new MoveMsg(pc, c, 1, c.getGoodOrBad());
                    pc.getNC().send(msg);
                    break;
                }
                case S: {
                    moveWithRecord(2); 
                    MoveMsg msg = new MoveMsg(pc, c, 2, c.getGoodOrBad());
                    pc.getNC().send(msg);break;
                }
                case A: {
                    moveWithRecord(3); 
                    MoveMsg msg = new MoveMsg(pc, c, 3, c.getGoodOrBad());
                    pc.getNC().send(msg);
                    break;
                }
                case D: {
                    moveWithRecord(4);
                    MoveMsg msg = new MoveMsg(pc, c, 4, c.getGoodOrBad());
                    pc.getNC().send(msg);
                    break;
                }
                case J: {  //攻击（发射子弹）
                    try{
                        Render.recordFile.seek(Render.recordFile.length());  //移动到文件结尾
                        Render.recordFile.writeBytes(creature.getName() + " shoot\n");  //写入数据
                    }catch(IOException e1){
                        e1.printStackTrace();
                    }
                    List<Integer> res = Game.shoot(creature, creature.getBullet()); 
                    pc.getRender().drawBullet(creature, creature.getBullet(), res.get(0), res.get(1), res.get(2), res.get(3), res.get(4));

                    //TODOmsg信息

                    break;
                } 
                case K: {  //攻击（发射子弹）
                    try{
                        Render.recordFile.seek(Render.recordFile.length());  //移动到文件结尾
                    Render.recordFile.writeBytes(creature.getName() + " shoot\n");  //写入数据
                    }catch(IOException e2){
                        e2.printStackTrace();
                    }
                    List<Integer> res = Game.shoot(creature, creature.getBullet()); 
                    pc.getRender().drawBullet(creature, creature.getBullet(), res.get(0), res.get(1), res.get(2), res.get(3), res.get(4));

                    //TODOmsg信息
                    
                    break;
                } 
            }
            update();
        });

        button.setMinSize(50, 40);
        button.setMaxSize(50, 40);
        Tooltip tp = new Tooltip(); //添加工具提示控件
        tp.setText(
            "FullHP: " + creature.getFullHP() + 
            "\nCurrentHP: " + creature.getCurHP() + 
            "\nDefence: "  + creature.getDefence() + 
            "\nBullet: " + creature.getBullet().getPower() 
        );
        button.setTooltip(tp);

        //设置ProgressBar控件即血条
        hpBar.setProgress(creature.getCurHP()/creature.getFullHP());
        hpBar.setMinSize(50, 10);
        hpBar.setMaxSize(50, 10);
        hpBar.setStyle("-fx-accent: red;");

        vbox.setMinSize(50, 40);
        vbox.setMaxSize(50, 40);
        vbox.getChildren().addAll(button, hpBar);

        vbox.setLayoutX(21 + 50*(creature.getPosX() - 1));
        vbox.setLayoutY(39 + 50*(creature.getPosY() - 1));
    }

    public VBox getVBox(){
        return this.vbox;
    }

    public void update(){  //一个生物体的状态发生改变时相应的更新其在战场上的表现（位置，血量等）
        vbox.setLayoutX(21 + 50*(creature.getPosX() - 1));
        vbox.setLayoutY(39 + 50*(creature.getPosY() - 1));
    }

    public void updateHpBarAndTips() { 
        hpBar.setProgress((double) creature.getCurHP() / creature.getFullHP());
        Tooltip tp = new Tooltip(); //添加工具提示控件
        tp.setText(
            "FullHP: " + creature.getFullHP() + 
            "\nCurrentHP: " + creature.getCurHP() + 
            "\nDefence: "  + creature.getDefence() + 
            "\nBullet: " + creature.getBullet().getPower() 
        );
        button.setTooltip(tp);
    }

    public void moveWithRecord(int dir){
        try{
            Render.recordFile.seek(Render.recordFile.length());  //移动到文件结尾
            switch(dir){
                case 1: {
                    if(creature.getPosY()>1 && !Game.existCreature(creature.getPosX(), creature.getPosY()-1)){
                        creature.setPosY(creature.getPosY()-1);
                        Render.recordFile.writeBytes(creature.getName() + " move 1\n");  //写入数据
                    }
                    break;
                }
                case 2: {
                    if(creature.getPosY()<10 && !Game.existCreature(creature.getPosX(), creature.getPosY()+1)){
                        creature.setPosY(creature.getPosY()+1);
                        Render.recordFile.writeBytes(creature.getName() + " move 2\n");  //写入数据
                    }
                    break;
                }
                case 3: {
                    if(creature.getPosX()>1 && !Game.existCreature(creature.getPosX()-1, creature.getPosY())){
                        creature.setPosX(creature.getPosX()-1);
                        Render.recordFile.writeBytes(creature.getName() + " move 3\n");  //写入数据
                    }
                    break;
                }
                case 4: {
                    if(creature.getPosX()<19 && !Game.existCreature(creature.getPosX()+1, creature.getPosY())){
                        creature.setPosX(creature.getPosX()+1);
                        Render.recordFile.writeBytes(creature.getName() + " move 4\n");  //写入数据
                    }
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }   
    }

    public void moveWithoutRecord(int dir){
        switch(dir){
            case 1: {
                if(creature.getPosY()>1 && !Game.existCreature(creature.getPosX(), creature.getPosY()-1)){
                    creature.setPosY(creature.getPosY()-1);
                }
                break;
            }
            case 2: {
                if(creature.getPosY()<10 && !Game.existCreature(creature.getPosX(), creature.getPosY()+1)){
                    creature.setPosY(creature.getPosY()+1);
                }
                break;
            }
            case 3: {
                if(creature.getPosX()>1 && !Game.existCreature(creature.getPosX()-1, creature.getPosY())){
                    creature.setPosX(creature.getPosX()-1);
                }
                break;
            }
            case 4: {
                if(creature.getPosX()<19 && !Game.existCreature(creature.getPosX()+1, creature.getPosY())){
                    creature.setPosX(creature.getPosX()+1);
                }
                break;
            }
        }
    }

}
