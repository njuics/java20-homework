package org.cvm.test.view;

import javafx.scene.control.Button;
import org.cvm.app.View;
import static org.cvm.Framework.*;

public class PlayView extends View {

    private Button homeBtn;

    @Override
    public void onLaunch() {
        homeBtn = new Button("Home");
        homeBtn.setOnAction((event) -> {
            app.gotoView("Home");
        });

        getChildren().add(homeBtn);
    }

    @Override
    public void onStart() {
        System.out.println("Play Start");
    }

    @Override
    public void onUpdate(double time) {
        System.out.println("Play Update. Time: " + time);
    }

    @Override
    public void onStop() {
        System.out.println("Play Stop");
    }
}
