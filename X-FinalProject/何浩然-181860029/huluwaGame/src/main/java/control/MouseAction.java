package control;

public class MouseAction extends Action{
    private int x;
    private int y;
    public MouseAction(long time,int x,int y) {
        super(time);
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String getType() {
        return "MOUSE";
    }
}
