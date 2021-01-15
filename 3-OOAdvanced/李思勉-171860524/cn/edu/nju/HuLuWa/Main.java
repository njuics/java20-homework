package cn.edu.nju.HuLuWa;
import java.util.*;

public class Main {
    private static BattleField battleField = new BattleField();     //战斗场地
    private static HuLuWa[] huLuWas = new HuLuWa[7];                //七个葫芦娃
    private static OldMan oldMan = new OldMan();                    //爷爷
    private static int sortMode = 0;
    // 初始化
    static void init(){
        battleField.grid[0] = oldMan;
        for (int i = 0;i<7;i++){
            huLuWas[i] = new HuLuWa(i);
        }
        //葫芦娃随机在1-8号格子占位
        Random random = new Random();
        Set<Integer> randIntSet = new HashSet<>();
        for(int i=0;i<7;i++){
            int randInt = random.nextInt(7);
            while(randIntSet.contains(randInt)){
                randInt = random.nextInt(7);
            }
            randIntSet.add(randInt);
            battleField.grid[i+1] = huLuWas[randInt];
            huLuWas[randInt].setPos(i+1);
        }
    }

    // 监管排序
    static void osSort(){
        oldMan.commandLine(battleField);    //爷爷发号施令让他们排成一列
        oldMan.countOff(battleField);       //爷爷让他们报数
    }

    // 协同排序
    static void cgSort(){
        // 从大娃开始，葫芦娃们依次寻找自己前面一个人的位置，并由此确定自己的位置
        for(HuLuWa huLuWa: huLuWas){
            int frontPos = huLuWa.findFrontPos(battleField);
            huLuWa.walkTo(battleField,frontPos+1);
        }
        // 报数
        for (Creature c:battleField.grid){
            if(c.specie==1){
                HuLuWa huLuWa = (HuLuWa)c;
                huLuWa.tellRank();
            }
        }
    }
    public static void main(String[] args){
        init();
        if (sortMode==0){
            osSort();
        }
        else{
            cgSort();
        }
    }
}
