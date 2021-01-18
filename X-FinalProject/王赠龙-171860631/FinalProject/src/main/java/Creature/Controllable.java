package Creature;

public interface Controllable {
    boolean getIsControlled();
    void setControlled(boolean controlFlag);
    boolean canBeControlled();
    void controlledMove(Direction dir);
}
