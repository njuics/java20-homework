package nju.zjl.cvs.game;

import java.io.Serializable;

public class Instruction implements Serializable{
    enum Action{
        NULL, MOVE, ATTACK    
    }
    
    public static Instruction newNullInst(){
        return new Instruction(Action.NULL, -1, -1);
    }

    public static Instruction newMoveInst(int pos){
        return new Instruction(Action.MOVE, pos, -1);
    }

    public static Instruction newAttackInst(int target){
        return new Instruction(Action.ATTACK, -1, target);
    }

    private Instruction(Action action, int pos, int target){
        this.action = action;
        this.pos = pos;
        this.target = target;
    }

    protected Instruction(){
        this.action = Action.NULL;
        this.pos = -1;
        this.target = -1;
    }
    
    public final Action action;
    public final int pos;
    public final int target;

    private static final long serialVersionUID = -5948987941441837263L;
}
