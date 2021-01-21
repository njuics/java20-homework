package org.cvm.test;

import static org.cvm.Framework.*;

import javafx.stage.Stage;
import org.cvm.app.Game;
import org.cvm.test.view.HomeView;
import org.cvm.test.view.PlayView;

public class TestGame extends Game {

    @Override
    public void onLaunch() {
        app.setTitle("Test Game");
        app.setWidth(800);
        app.setHeight(600);

        app.regView("Home", new HomeView());
        app.regView("Play", new PlayView());
        app.gotoView("Home");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void onFinish() {
        System.out.println("Finish");
    }

    @Override
    public boolean onExit() {
        System.out.println("Exit");
        return true;
    }
}
