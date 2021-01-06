package cn.edu.nju.HuLuWa;
public class OldMan extends Creature implements Action{
    OldMan(){
        this.specie = 0;
        pos = 0;
    }
    public void walkTo(BattleField battleField,int pos){
        System.out.println("爷爷无法移动！");
    }
    private  int askRank(HuLuWa huLuWa){
        return huLuWa.getRank();
    }
    // 爷爷为该葫芦娃安排位置
    private  void arrangePos(BattleField battleField,HuLuWa huLuWa){
        int rank = askRank(huLuWa);                 //葫芦娃回答自己的编号
        int currentPos = huLuWa.pos;
        if(currentPos==rank+1){                     //位置已经正确，不做修改
            return;
        }
        Creature tempC = battleField.grid[rank+1];
        huLuWa.walkTo(battleField,rank+1);      //爷爷安排他与目标地点的生物换位置
        if(tempC.specie==1){
            arrangePos(battleField,(HuLuWa)tempC); //若被换位置的是葫芦娃，则为其找新位置
        }
    }
    // 老人依次找到葫芦娃，询问葫芦娃的编号，并将他们安排在战场指定位置上
    public void commandLine(BattleField battleField){
        int max = battleField.getMax();
        for(int i = 0;i<max;i++){
            Creature c = battleField.grid[i];
            if(c.specie==1){
                arrangePos(battleField,(HuLuWa)c);
            }
        }
    }
    // 老人大喊一声”报数“，从站在自己面前的第一个葫芦娃开始向后报数
    public void countOff(BattleField battleField){
        for (Creature c:battleField.grid){
            if(c.specie==1){
                HuLuWa huLuWa = (HuLuWa)c;
                huLuWa.tellRank();
            }
        }
    }

}
