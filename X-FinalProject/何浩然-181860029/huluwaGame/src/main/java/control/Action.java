package control;

public abstract class Action {
    protected long time;
    public Action(long time){
        this.time = time;
    }
    public long getTime() {
        return time;
    }
    public abstract String getType();
}
