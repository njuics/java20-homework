package advancedjava.finalproj.stage;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//游戏中所有Stage的父类，用来初始化按钮
public class MyStage extends Stage {

    protected void initButton(Button btn){
        btn.setMinSize(90,60);
        btn.setAlignment(Pos.CENTER);
        btn.setFont(new Font("Cambria", 30));
        DropShadow shadow = new DropShadow();
        //当鼠标进入按钮时添加阴影特效
        btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                btn.setEffect(shadow);
            }
        });

        //当鼠标离开按钮时移除阴影效果
        btn.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                btn.setEffect(null);
            }
        });
    }
}
