package cn.edu.nju.HuLuWa;

import java.util.ArrayList;

public class OldMan extends Creature{
    public OldMan(){
        this.specie = 0;
        rowPos = 0;
        columnPos = 0;
        name = "爷爷";
    }
    public void walkTo(BattleField<Creature> battleField,int row,int column){
        System.out.println("爷爷:\"我的老寒腿啊！\"[爷爷的速度为0，无法移动]");
    }
    private  int askRank(HuLuWa huLuWa){
        return huLuWa.getRank();
    }
    // 爷爷为该葫芦娃安排位置
    private  void arrangePos(BattleField<Creature> battleField,HuLuWa huLuWa){
        int rank = askRank(huLuWa);                 //葫芦娃回答自己的编号
        int currentPos = huLuWa.columnPos;
        if(currentPos==rank+1){                     //位置已经正确，不做修改
            return;
        }
        Creature tempC = battleField.get(rowPos,rank+1);
        huLuWa.walkTo(battleField,rowPos,rank+1);      //爷爷安排他与目标地点的生物换位置
        if(tempC.specie==1){
            arrangePos(battleField,(HuLuWa)tempC); //若被换位置的是葫芦娃，则为其找新位置
        }
    }
    // 老人依次找到葫芦娃，询问葫芦娃的编号，并将他们安排在战场指定位置上
    public void commandLine(BattleField<Creature> battleField){
        ArrayList<Creature> array = battleField.get(rowPos);
        for(Creature c:array){
            if(c.specie==1){
                arrangePos(battleField,(HuLuWa)c);
            }
        }
    }
    // 老人大喊一声”报数“，指定列葫芦娃开始报数
    public void countOff(BattleField<Creature> battleField,int row){
        ArrayList<Creature> array = battleField.get(row);
        //int count = 1;
        for (Creature c:array){
            if(c.specie==1){
                HuLuWa huLuWa = (HuLuWa)c;
                //System.out.print(String.valueOf(count++)+" ");
                huLuWa.tellName();
            }
        }
        System.out.println();
    }
}
