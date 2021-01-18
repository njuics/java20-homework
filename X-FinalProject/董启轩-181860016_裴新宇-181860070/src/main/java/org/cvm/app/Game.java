package org.cvm.app;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Game extends Application {

    private App app;

    public abstract void onLaunch();

    public void onFinish() {
        // Do something in subclass.
    }

    public boolean onExit() {
        // Do something in subclass.
        return true;//可以用来实现退出弹窗功能
    }


    @Override
    public final void start(Stage primaryStage) throws Exception {
        app = new App(primaryStage);
        app.onLaunch = this::onLaunch;
        app.onFinish = this::onFinish;
        app.onExit = this::onExit;

        app.launch();
    }

    @Override
    public final void stop() throws Exception {
        app.finish();//项目退出的处理
    }
}
