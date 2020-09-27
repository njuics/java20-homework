package cn.edu.nju.kecheng.java.advancedoop;
import java.util.Random;

public class Field {
    HuLuBro[] grid;
    static public int BRO_NUM;
    static{
        BRO_NUM=Color.values().length;
    }
    Field(HuLuBro[] bros){
        grid=new HuLuBro[BRO_NUM];
        Random random=new Random();
        int loc=0;
        for(int i=0;i< BRO_NUM;i++){
            do { loc = random.nextInt(BRO_NUM); }while(grid[loc]!=null);
            grid[loc]=bros[i];
            bros[i].setLoc(loc);
        }
    }
}


