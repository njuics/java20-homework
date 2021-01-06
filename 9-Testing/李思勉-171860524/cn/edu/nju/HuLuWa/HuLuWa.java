package cn.edu.nju.HuLuWa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HuLuWa extends Creature{
    private static int totalRank = 0;
    private static ArrayList<HuLuWa> huLuWaList = new ArrayList<>();
    private final int rank;
    private final Random random = new Random();
    public HuLuWa(){
        specie = 1;
        rank = totalRank++;
        name = getRandomName();
        gender = random.nextInt(2);
        huLuWaList.add(this);
    }
    public String getRandomName(){
        String albet = "abcdefghijklmnopqrstuvwxyz";
        String name = ""+ Character.toUpperCase(albet.charAt(random.nextInt(26)));
        int nameLength = random.nextInt(3)+2;
        for(int i=0;i<nameLength;i++){
            char c = albet.charAt(random.nextInt(26));
            name = name + c;
        }
        return name;
    }
    public int getRank(){
        return rank;
    }
    public int findFrontPos(BattleField<Creature> battleField){
        if(rank==0){
            return 0;
        }
        ArrayList<Creature> row = battleField.get(rowPos);
        for (Creature c:row){
            if(c.specie==1){
                HuLuWa huLuWa = (HuLuWa) c;
                if(huLuWa.rank==rank-1){
                    return huLuWa.columnPos;
                }
            }
        }
        return -1;
    }
    public static void reInit(){
        totalRank = 0;
        huLuWaList = new ArrayList<>();
    }
    public static ArrayList<HuLuWa> getHuLuWaList(){
        return huLuWaList;
    }
    public static void sortInRow(BattleField<Creature> battleField,int row,boolean reverse){
        Collections.sort(huLuWaList);
        if(reverse){
            Collections.reverse(huLuWaList);
        }
        int column = 1;
        for(HuLuWa huLuWa:huLuWaList){
            huLuWa.walkTo(battleField,row,column++);
        }
    }
    public static void shuffleInRow(BattleField<Creature> battleField,int row){
        Collections.shuffle(huLuWaList);
        int column = 1;
        for(HuLuWa huLuWa:huLuWaList){
            huLuWa.walkTo(battleField,row,column++);
        }
    }
    public static void arrangeInRows(BattleField<Creature> battleField, int row1,int row2,int arrangeMode){
        ArrayList<HuLuWa> list1 = new ArrayList<>();
        ArrayList<HuLuWa> list2 = new ArrayList<>();
        for(HuLuWa huLuWa:huLuWaList){
            if(huLuWa.gender==0){
                list1.add(huLuWa);
            }
            else{
                list2.add(huLuWa);
            }
        }
        if(arrangeMode == 2){
            Collections.shuffle(list1);
            Collections.shuffle(list2);
        }
        else{
            Collections.sort(list1);
            Collections.sort(list2);
            if(arrangeMode == 1){
                Collections.reverse(list1);
                Collections.reverse(list2);
            }
        }

        int column = 1;
        for(HuLuWa huLuWa:list1){
            huLuWa.walkTo(battleField,row1,column++);
        }
        column = 1;
        for(HuLuWa huLuWa:list2){
            huLuWa.walkTo(battleField,row2,column++);
        }
    }

}
