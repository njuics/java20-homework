package org.cvm.input;

import javafx.scene.input.KeyCode;

public enum Key {

    // Numbers
    NUM0(KeyCode.DIGIT0, "0"),
    NUM1(KeyCode.DIGIT1, "1"),
    NUM2(KeyCode.DIGIT2, "2"),
    NUM3(KeyCode.DIGIT3, "3"),
    NUM4(KeyCode.DIGIT4, "4"),
    NUM5(KeyCode.DIGIT5, "5"),
    NUM6(KeyCode.DIGIT6, "6"),
    NUM7(KeyCode.DIGIT7, "7"),
    NUM8(KeyCode.DIGIT8, "8"),
    NUM9(KeyCode.DIGIT9, "9"),

    // Letters
    A(KeyCode.A, "A"),
    B(KeyCode.B, "B"),
    C(KeyCode.C, "C"),
    D(KeyCode.D, "D"),
    E(KeyCode.E, "E"),
    F(KeyCode.F, "F"),
    G(KeyCode.G, "G"),
    H(KeyCode.H, "H"),
    I(KeyCode.I, "I"),
    J(KeyCode.J, "J"),
    K(KeyCode.K, "K"),
    L(KeyCode.L, "L"),
    M(KeyCode.M, "M"),
    N(KeyCode.N, "N"),
    O(KeyCode.O, "O"),
    P(KeyCode.P, "P"),
    Q(KeyCode.Q, "Q"),
    R(KeyCode.R, "R"),
    S(KeyCode.S, "S"),
    T(KeyCode.T, "T"),
    U(KeyCode.U, "U"),
    V(KeyCode.V, "V"),
    W(KeyCode.W, "W"),
    X(KeyCode.X, "X"),
    Y(KeyCode.Y, "Y"),
    Z(KeyCode.Z, "Z"),

    // Functions
    F1(KeyCode.F1,"F1"),
    F2(KeyCode.F2,"F2"),
    F3(KeyCode.F3,"F3"),
    F4(KeyCode.F4,"F4"),
    F5(KeyCode.F5,"F5"),
    F6(KeyCode.F6,"F6"),
    F7(KeyCode.F7,"F7"),
    F8(KeyCode.F8,"F8"),
    F9(KeyCode.F9,"F9"),
    F10(KeyCode.F10,"F10"),
    F11(KeyCode.F11,"F11"),
    F12(KeyCode.F12,"F12"),

    // White Spaces
    SPACE(KeyCode.SPACE," "),
    ENTER(KeyCode.ENTER,"\n"),
    TAB(KeyCode.TAB,"\t"),

    // Arrows
    UP(KeyCode.UP,"UP"),
    DOWN(KeyCode.DOWN,"DOWN"),
    LEFT(KeyCode.LEFT,"LEFT"),
    RIGHT(KeyCode.RIGHT,"RIGHT"),

    // ESCAPE
    ESCAPE(KeyCode.ESCAPE,"ESC");

    private final KeyCode code;
    private final String text;

    private Key(KeyCode code, String text) {
        this.code = code;
        this.text = text;
    }

    public KeyCode getCode() {
        return code;
    }
    public String getText() {
        return text;
    }

    public static Key find(KeyCode code) {
        for (Key k : values()) {
            if(k.code != null && k.code == code) {
                return k;
            }
        }
        return null;
    }

    public static Key find(String text) {
        for (Key k : values()) {
            if(k.text != null && k.text.equalsIgnoreCase(text)) {
                return k;
            }
        }
        return null;
    }
}
