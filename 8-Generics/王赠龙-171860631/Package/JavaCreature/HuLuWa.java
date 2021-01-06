package Package.JavaCreature;
import java.util.*;

public class HuLuWa extends Creature {
    private int rank=0;//表示葫芦娃的排行，1表示老大，2表示老二，以此类推
    //position表示葫芦娃在当前队列中的位置
    private int gender=0;

    public HuLuWa(int tempRank, String tempName,int tempGender){
        name=tempName;
        rank=tempRank;
        gender=tempGender;
    }
    public void setPosition(int tempPosition){
        int temp=getPosition();
        position=tempPosition;
        if(temp!=-1) System.out.println(name+" move from "+temp+" to "+position);
    }
    public void swap(HuLuWa tempHuLu){//与tempHuLu交换位置
        int tempPosition1=getPosition();
        int tempPosition2=tempHuLu.getPosition();
        setPosition(tempPosition2);
        tempHuLu.setPosition(tempPosition1);
    }
    public void numberOff(){
        System.out.print(name+" "+gender+"  ");
    }

    public String getName(){return this.name;}
    public int getGender(){return this.gender;}

    /*
    @Override
    public int compareTo(HuLuWa p)
    {
        if(nameOrderModel==0) return this.getName().compareTo(p.getName());
        else return -this.getName().compareTo(p.getName());
    }*/
}
