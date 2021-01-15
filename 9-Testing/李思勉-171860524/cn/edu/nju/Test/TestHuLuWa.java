package cn.edu.nju.Test;
import cn.edu.nju.HuLuWa.BattleField;
import cn.edu.nju.HuLuWa.Creature;
import cn.edu.nju.HuLuWa.HuLuWa;
import cn.edu.nju.HuLuWa.OldMan;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class TestHuLuWa {
    private static final BattleField<Creature> battleField = new BattleField<>(Creature.class,3,10000);
    private static final int mediumRow =battleField.getRowNum()/2;
    private static final int huLuWaNum = 1000;
    private static final OldMan oldMan = new OldMan();
    @BeforeClass
    public static void init(){
        battleField.set(mediumRow,0,oldMan);
        for (int i = 0;i<huLuWaNum;i++){
            battleField.set(mediumRow,i+1,new HuLuWa());
        }
    }

    @AfterClass
    public static void clear(){
        HuLuWa.reInit();
        battleField.clear();
    }

    @Test(timeout = 1000)
    public void testSortTime(){
        HuLuWa.sortInRow(battleField,mediumRow,false);
    }

    @Test
    // 确保排序正确
    public void testSortInRow()  {
        HuLuWa.sortInRow(battleField,mediumRow,false);
        ArrayList<Creature> array = battleField.getSpecieArray(mediumRow,1);
        assertHuLuWa(array);
        assertSorted(array,false);
    }
    @Test
    public void testSortInRows(){
        HuLuWa.arrangeInRows(battleField,mediumRow-1,mediumRow+1,0);
        ArrayList<Creature> array1 = battleField.getSpecieArray(mediumRow-1,1);
        ArrayList<Creature> array2 = battleField.getSpecieArray(mediumRow+1,1);
        assertHuLuWa(array1);
        assertHuLuWa(array2);
        assertGirl(array1);
        assertBoy(array2);
        assertSorted(array1,false);
        assertSorted(array2,false);
    }

    private void assertSorted(ArrayList<Creature> array, boolean reverse) {
        Creature c = array.get(1);
        for(int i = 2;i<array.size();i++){
            Creature c2 = array.get(i);
            if(reverse){
                assertTrue(c.compareTo(c2)>=0);
            }
            else{
                assertTrue(c.compareTo(c2)<=0);
            }
            c = c2;
        }
    }

    private void assertBoy(ArrayList<Creature> array){
        for(Creature c:array){
            assertTrue(c.isBoy());
        }
    }

    private void assertGirl(ArrayList<Creature> array){
        for(Creature c:array){
            assertTrue(c.isGirl());
        }
    }

    private void assertHuLuWa(ArrayList<Creature> array){
        for(Creature c:array){
            assertTrue(c.isHuLuWa());
        }
    }
}
