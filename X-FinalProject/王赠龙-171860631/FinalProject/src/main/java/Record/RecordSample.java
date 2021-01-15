package Record;

import java.io.Serializable;

/*用于记录每一帧每一个生物需要记录的信息来写到文件中*/
public class RecordSample implements Serializable {
    public int posX;
    public int posY;
    public double hp;
    public double maxHp;
    public boolean isControlled;
    public String name;//用户回放时与图片对应
    public RecordSample(int posX,int posY,double hp,double maxHp,boolean isControlled,String name){
        this.posX=posX;
        this.posY=posY;
        this.hp=hp;
        this.maxHp=maxHp;
        this.isControlled=isControlled;
        this.name=name;
    }
}
