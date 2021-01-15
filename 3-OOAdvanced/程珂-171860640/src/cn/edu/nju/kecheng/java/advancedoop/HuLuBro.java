package cn.edu.nju.kecheng.java.advancedoop;

enum Color {
    RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PUPRLE
}

public class HuLuBro extends Man{
    private Color color;
    HuLuBro(Color color){
        super(color.toString(), color.ordinal());
        this.color=color;
    }
    //自己走
    public void moveTo(int loc,HuLuBro[] grid){
       if(this.loc==loc)return ;
       HuLuBro another=grid[loc];
       another.loc=this.loc;
       this.loc=loc;
       grid[another.loc]=another;
       grid[this.loc]=this;
    }
    //走回他本身的地方
    public void moveToOrdinal(HuLuBro[] grid){
        moveTo(this.color.ordinal(),grid);
    }
    public void setLoc(int loc){this.loc=loc;}

    public int getColorByRank(){
        return this.color.ordinal();
    }
}



