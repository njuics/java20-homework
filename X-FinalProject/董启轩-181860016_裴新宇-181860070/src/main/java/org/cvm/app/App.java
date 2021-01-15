package org.cvm.app;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import org.cvm.Framework;
import org.cvm.input.KeyInput;
import org.cvm.net.FINISH_MSG;
import org.cvm.net.NetClient;
import org.cvm.output.PlayFile;
import org.cvm.view.PlayView;
import org.cvm.world.Team.CalabashbrotherTeam;
import org.cvm.world.Team.MonsterTeam;

import java.io.File;
import java.util.HashMap;

public class App {

    private final Stage stage;
    private final Scene scene;
    private final Pane root;

    private final HashMap<String, View> viewMap;
    private final ObjectProperty<View> currentView;

    private final Engine engine;

    private final KeyInput keyInput;

    OnLaunch onLaunch;
    OnFinish onFinish;
    OnExit onExit;

    private File file;

    private PlayFile playFile;

    private CalabashbrotherTeam calabashbrotherTeam;
    private MonsterTeam monsterTeam;

    private NetClient netClient;

    public App(Stage stage) {
        file = null;

        this.stage = stage;

        root = new StackPane();
        scene = new Scene(root);
        stage.setScene(scene);

        viewMap = new HashMap<>();
        currentView = new SimpleObjectProperty<>();

        engine = new Engine();

        keyInput = new KeyInput();

        calabashbrotherTeam = new CalabashbrotherTeam();
        monsterTeam = new MonsterTeam();
        netClient = new NetClient();

        playFile = new PlayFile();

        initFramework();
        initApp();
        initEngine();

        engine.start();
    }

    private final void initFramework() {
        Framework.app = this;
        Framework.engine = engine;
        Framework.keyInput = keyInput;
        Framework.calabashbrotherTeam = calabashbrotherTeam;
        Framework.monsterTeam = monsterTeam;
        Framework.netClient = netClient;
        Framework.playFile = playFile;
    }

    private final void initApp() {
        scene.setFill(Color.WHITE);
        root.setBackground(Background.EMPTY);

        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,(event) -> {
            if(onExit != null && !onExit.handle()) {
                event.consume();
            }
        });

        currentView.addListener((o, ov, nv) -> {
            if(ov != null) {
                ov.onLeave();
                root.getChildren().remove(ov.getPane());
            }
            if(nv != null) {
                root.getChildren().add(nv.getPane());
                nv.onEnter();
            }
        });

    }

    private final void initEngine() {
        engine.onStart = () -> {
            for (View view : viewMap.values()) {
                view.onStart();
            }
            keyInput.install(stage);
        };
        engine.onUpdate = (time) -> {
            View view = getCurrentView();
            if (view != null) {
                view.onUpdate(time);
            }
            keyInput.refresh();
        };
        engine.onStop = () -> {
            for( View view : viewMap.values()) {
                view.onStop();
            }
            keyInput.uninstall(stage);
        };
//        stage.focusedProperty().addListener((o,ov,nv) -> {
//            if(nv) {
//                engine.start();
//            }
//            else {
//                engine.stop();
//            }
//        });
    }

    public Stage getStage() {
        return stage;
    }

    public Scene getScene() {
        return scene;
    }


    public String getTitle() {
        return stage.getTitle();
    }
    public void setTitle(String title) {
        stage.setTitle(title);
    }
    public StringProperty titleProperty() {
        return stage.titleProperty();
    }


    public double getWidth() {
        return root.getMinWidth();
    }
    public void setWidth(double width) {
        root.setMinWidth(width);
    }
    public DoubleProperty widthProperty() {
        return root.minWidthProperty();
    }

    public double getHeight() {
        return root.getMinHeight();
    }
    public void setHeight(double height) {
        root.setMinHeight(height);
    }
    public DoubleProperty heightProperty() {
        return root.minHeightProperty();
    }


    public void regView(String name, View view) {
        viewMap.put(name, view);
    }
    public View getView(String name) {
        return viewMap.get(name);
    }
    public void unregView(String name) {
        View view = viewMap.remove(name);
        if (view != null && view == getCurrentView()) {
            currentView.set(null);
            System.out.println("Error: Current page has been deleted.");
        }
    }
    public View getCurrentView() {
        return currentView.get();
    }
    public ReadOnlyObjectProperty<View> currentViewProperty() {
        return currentView;
    }
    public void gotoView(String name) {
        View view = viewMap.get(name);
        if(view != null) {
            //view.onLaunch();
            currentView.set(view);
        }
    }

    void launch() {
        if(onLaunch != null) {
            onLaunch.handle();
        }

        for (View view: viewMap.values()) {
            view.onLaunch();
        }

        stage.requestFocus();//窗口申请焦点，便于键盘输入
        stage.show();
    }

    void finish() {
        for (View view: viewMap.values()) {
            view.onFinish();
        }

        if(onFinish != null) {
            onFinish.handle();
        }
    }

    public void exit() {
        Platform.exit();
    }

    static interface OnLaunch {
        void handle();
    }
    static interface OnFinish {
        void handle();
    }
    static interface OnExit {
        boolean handle();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }
}
