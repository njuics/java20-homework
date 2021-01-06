package cn.edu.nju.HuLuWa;

public class Main {
    private static final BattleField<Creature> battleField = new BattleField<>(Creature.class);     //战斗场地
    private static final int mediumRow =battleField.getRowNum()/2;        //战场中央一列
    private static final OldMan oldMan = new OldMan();                    //爷爷
    private static final int huLuWaNum = 20;
    // 初始化
    static void init(){
        battleField.set(mediumRow,0,oldMan);                       // 战斗场地中间一列第一人是爷爷
        for (int i = 0;i<huLuWaNum;i++){
            battleField.set(mediumRow,i+1,new HuLuWa());
        }
    }

    public static void main(String[] args){
        init();
        System.out.println("#########单列排序-正序#########");
        HuLuWa.sortInRow(battleField,mediumRow,false);
        oldMan.countOff(battleField,mediumRow);

        System.out.println("#########单列排序-逆序#########");
        HuLuWa.sortInRow(battleField,mediumRow,true);
        oldMan.countOff(battleField,mediumRow);

        System.out.println("#########单列排序-乱序#########");
        HuLuWa.shuffleInRow(battleField,mediumRow);
        oldMan.countOff(battleField,mediumRow);

        System.out.println("#########分列排序-正序#########");
        HuLuWa.arrangeInRows(battleField,mediumRow-1,mediumRow+1,0);
        System.out.println("列1-女生");
        oldMan.countOff(battleField,mediumRow-1);
        System.out.println("列2-男生");
        oldMan.countOff(battleField,mediumRow+1);

        System.out.println("#########分列排序-逆序#########");
        HuLuWa.arrangeInRows(battleField,mediumRow-1,mediumRow+1,1);
        System.out.println("列1-女生");
        oldMan.countOff(battleField,mediumRow-1);
        System.out.println("列2-男生");
        oldMan.countOff(battleField,mediumRow+1);

        System.out.println("#########单列排序-乱序#########");
        HuLuWa.arrangeInRows(battleField,mediumRow-1,mediumRow+1,2);
        System.out.println("列1-女生");
        oldMan.countOff(battleField,mediumRow-1);
        System.out.println("列2-男生");
        oldMan.countOff(battleField,mediumRow+1);
    }
}
