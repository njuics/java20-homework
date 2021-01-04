package sample;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
    样式： textname: 矩形框，框内填充颜色 这里
    信息类：显示血条和蓝条; （有时间或许还能做个进度条？）
    暂时没想到应该放哪，想把这个实现了然后看看普通攻击是否正常工作
    属性：(血值显示图，蓝值显示图)显示条,血条，蓝条，宽度，高度,提示，可见性
    构造器：
        正在学习如何显示，默认构造器里先放一些如何使用的代码
    方法：
        显示
        隐藏
*/

class Info extends Pane{
    //属性-------------------------------
    // ImageView HPview;
    // ImageView MPview;
    Rectangle HPbar;
    // Rectangle MPbar;
    final int width = 90;
    final int height = 5;
    // Text textname;
    AtomicBoolean visible=new AtomicBoolean(true);
    Lock lock = new ReentrantLock();

    //构造器------------------------------
    public Info()
    {
        HPbar = new Rectangle(width,height);
        Stop[] stops = new Stop[] { new Stop(0, Color.RED), new Stop(1, Color.RED)};
        LinearGradient lg1 = new LinearGradient( 0,0,1,0,true, CycleMethod.NO_CYCLE,stops);
        HPbar.setFill(lg1);
        setMaxSize(width,height);
        HPbar.setWidth(width);
        HPbar.setHeight(height);
        HPbar.setArcWidth(1);
        HPbar.setArcHeight(1);
        getChildren().add(HPbar);
        //文本
        // textname = new Text();
        // textname.setText("HP");
        // textname.setFont(Font.font ("Verdana", 5));
        // textname.setFill(Color.RED);
        // textname.setTextAlignment(TextAlignment.CENTER);//中点对齐
        // // System.out.printf("%s,%s",width,height);
        // // textname.setLayoutY(height);
        // getChildren().add(textname);

    }
    //方法-----------------------------
    public void setBar(Creature role){
        if (role.HP==role.maxHP)
            return;
        float ratio = (float)role.HP/(float)role.maxHP;
        Stop[] stops = new Stop[] { new Stop(0, Color.rgb(255,0,0)), new Stop(ratio,Color.rgb(255, 153, 18,0.5)),
                new Stop(1, Color.rgb(255,255,255,0)) };
        LinearGradient lg1 = new LinearGradient( 0,0,1,0,true, CycleMethod.NO_CYCLE,stops);
        HPbar.setFill(lg1);

    }

    public void showBar(){
        double dy = width/10;
        new Thread(()->{
            lock.lock();
            if (visible.get() == true) //已经是显示状态
                return;
            visible.set(true);
            double cury = getLayoutY();
            for (int i = 0; i < 10; i++) {
                cury -= dy;
                double y = cury;
                Platform.runLater(()-> {
                    relocate(getLayoutX(), y);
                });
                try {
                    Thread.sleep(700 / 36);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();
    }

    public void hideBar(){
        double dy = width;
        new Thread(()->{
            lock.lock();
            if(visible.get() == false) {
                return;
            }
            visible.set(false);
            double cury = getLayoutY();
            for (int i = 0; i < 36; i++) {
                cury += dy;
                double y = cury;
                Platform.runLater(()-> {
                    relocate(getLayoutX(), y);
                });
                try {
                    Thread.sleep(700 / 36);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();
    }

}