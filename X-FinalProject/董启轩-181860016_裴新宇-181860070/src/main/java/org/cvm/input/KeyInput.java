package org.cvm.input;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class KeyInput {

    private final class Unit {
        private boolean pressed;
        private boolean released;
        private boolean held;

        private int typeCount;
        private int typeStore;
        private long typeStamp;

        private static final int TYPE_DURATION = 200;

        private Unit() {

        }

        public void press() {
            if (!held) {
                pressed = true;
                held = true;
            }
        }

        public void release() {
            if (held) {
                released = true;
                held = false;

                typeCount = ++typeStore;
                typeStamp = System.currentTimeMillis();
            }
        }

        public void refresh() {
            pressed = false;
            released = false;

            typeCount = 0;

            if (typeStamp > 0) {
                long now = System.currentTimeMillis();
                long stamp = typeStamp;

                if (now - stamp > TYPE_DURATION) {
                    typeStore = 0;
                    typeStamp = 0;
                }
            }
        }

        public void reset() {
            pressed = false;
            released = false;
            held = false;

            typeCount = 0;
            typeStore = 0;
            typeStamp = 0;
        }
    }

    private final Unit[] units;

    public KeyInput() {
        units = new Unit[Key.values().length];
        for (int i = 0; i < units.length; i++) {
            units[i] = new Unit();
        }
    }

    public boolean isPressed(Key key) {
        return key != null ? units[key.ordinal()].pressed : false;
    }

    public boolean isReleased(Key key) {
        return key != null ? units[key.ordinal()].released : false;
    }

    // 存在bug，暂时也不需要使用
//    public boolean isHeld(Key key) {
//        return key != null ? units[key.ordinal()].held : false;
//    }
//
//    public boolean isTyped(Key key) {
//        return getTypeCount(key) > 0;
//    }
//
//    public int getTypeCount(Key key) {
//        return key != null ? units[key.ordinal()].typeCount : 0;
//    }

    public void install(Stage stage) {
        stage.addEventHandler(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
        stage.addEventHandler(KeyEvent.KEY_RELEASED, this::handleKeyReleased);

        reset();
    }
    public void uninstall(Stage stage) {
        stage.removeEventHandler(KeyEvent.KEY_PRESSED, this::handleKeyPressed);
        stage.removeEventHandler(KeyEvent.KEY_RELEASED, this::handleKeyReleased);

        reset();
    }

    private final void handleKeyPressed(KeyEvent event) {
        press(Key.find(event.getCode()));
        press(Key.find(event.getText()));
    }
    private final void handleKeyReleased(KeyEvent event) {
        release(Key.find(event.getCode()));
        release(Key.find(event.getText()));
    }

    public void press(Key key) {
        if (key != null) {
            units[key.ordinal()].press();
        }
    }
    public void release(Key key) {
        if (key != null) {
            units[key.ordinal()].release();
        }
    }

    public void refresh() {
        for (int i = 0; i < units.length; i++) {
            units[i].refresh();
        }
    }
    public void reset() {
        for (int i = 0; i < units.length; i++) {
            units[i].reset();
        }
    }
}
