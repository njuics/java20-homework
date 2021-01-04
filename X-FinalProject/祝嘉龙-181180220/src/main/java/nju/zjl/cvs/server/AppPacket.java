package nju.zjl.cvs.server;

import java.io.Serializable;

import nju.zjl.cvs.game.Operation;

public class AppPacket implements Serializable{
    public AppPacket(int type, int logicFrame, Operation[] payload) {
        this.type = type;
        this.logicFrame = logicFrame;
        this.payload = payload;
    }

    protected AppPacket(){
        type = -1;
        logicFrame = -1;
        payload = null;
    }

    public final int type;
    public final int logicFrame;
    public final Operation[] payload;

    private static final long serialVersionUID = -2585837168358002521L;
}
