package cn.edu.nju.HuLuWa;
public class Creature {
    protected int specie;
    protected int pos;
    protected int ID;
    static private int count;
    static{
        count = 0;
    }
    Creature(){
        specie = -1;
        pos = -1;
        ID = count++;
    }
    public void clear(){
        specie = -1;
        pos = -1;
    }
    public void setPos(int pos){
        this.pos = pos;
    }
}
