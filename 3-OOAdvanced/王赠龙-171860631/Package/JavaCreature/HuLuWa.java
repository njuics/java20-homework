package Package.JavaCreature;
import java.util.*;

public class HuLuWa extends Creature{
    private int rank=0;//表示葫芦娃的排行，1表示老大，2表示老二，以此类推
    //position表示葫芦娃在当前队列中的位置
    public HuLuWa(int tempRank, String tempName){
        super(tempName);
        rank=tempRank;
    }
    public void setPosition(int tempPosition){
        int temp=getPosition();
        super.setPosition(tempPosition);
        if(temp!=-1) System.out.println(name+" move from "+temp+" to "+position);
    }
    public void swap(HuLuWa tempHuLu){//与tempHuLu交换位置
        int tempPosition1=getPosition();
        int tempPosition2=tempHuLu.getPosition();
        setPosition(tempPosition2);
        tempHuLu.setPosition(tempPosition1);
    }
    public void numberOff(){
        System.out.print(name+" ");
    }
}
