package org.cvm.test.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.cvm.app.View;
import org.cvm.input.Key;
import org.cvm.input.KeyInput;

import static org.cvm.Framework.*;

public class HomeView extends View {

    private Button playBtn;
    private Button exitBtn;

    @Override
    public void onLaunch() {
        playBtn = new Button("Play");
        playBtn.setOnAction((event) -> {
            app.gotoView("Play");
        });

        exitBtn = new Button("Exit");
        exitBtn.setOnAction((event) -> {
            app.exit();
        });

        VBox box = new VBox(playBtn, exitBtn);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);

        getChildren().add(box);
    }

    @Override
    public void onUpdate(double time) {
        if (keyInput.isPressed(Key.A)) {
            System.out.println("Pressed A");
        }
        if (keyInput.isReleased(Key.B)) {
            System.out.println("Released B");
        }
    }
}
