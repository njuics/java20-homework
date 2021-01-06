package org.cvm.app;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.Observable;

public abstract class View {

    private final Pane pane;

    public View() {
        pane = new StackPane();
        pane.setBackground(Background.EMPTY);
    }

    public Pane getPane() {
        return pane;
    }

    public ObservableList<Node> getChildren() {
        return pane.getChildren();
    }

    public abstract void onLaunch();

    public void onEnter() {
        // Do something in subclass.
    }

    public void onStart() {
        // Do something in subclass.
    }
    public void onUpdate(double time) {
        // Do something in subclass.
    }

    public void onStop() {
        // Do something in subclass.
    }

    public void onLeave() {
        onLaunch();
        // 离开页面时重置页面
    }

    public void onFinish() {
        // Do something in subclass.
    }
}
