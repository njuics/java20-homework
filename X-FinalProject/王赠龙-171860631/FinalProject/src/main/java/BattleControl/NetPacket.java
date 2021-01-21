package BattleControl;

import java.io.Serializable;

public class NetPacket implements Serializable {
  //  int prePosX;
   // int prePosY;
    private boolean type=true;
    private String name;
    private int newPosX;
    private int newPosY;
    private double hp;
    private boolean camp;
    public NetPacket(boolean type,String name,int newPosX,int newPosY,double hp){
      this.type=type;
      this.name=name;
      this.newPosX=newPosX;
      this.newPosY=newPosY;
      this.hp=hp;
    }
    public NetPacket(boolean camp){
      this.camp=camp;
    }
    public String getName(){return name;}
    public int getNewPosX(){return newPosX;}
    public int getNewPosY(){return newPosY;}
    public double getHp(){return hp;}
    public boolean getType(){return type;}
    public boolean getCamp(){return camp;}
}
