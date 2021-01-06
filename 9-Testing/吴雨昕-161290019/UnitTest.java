import java.util.List;
import org.junit.*;
// import org.junit.Test;
// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTest {
    CreatureList<CalabashBoy> boyList;
    CreatureList<Monster> monsterList;
    @Test
    public void testCreateCreatureList(){
        boyList = new CreatureList<>(new CalabashFactory());
        monsterList = new CreatureList<>(new MonsterFactory());
        System.out.println("Create Creatrue List test Success");
    }
    @Test
    public void testSortBoys(){
        boyList.sortWithComparable(true);
        for(int i=1;i<boyList.getSize();i++){
            assertTrue(boyList.getCreature(i).getName().compareTo(boyList.getCreature(i-1).getName())>0);
        }
        boyList.shuffleWithComparable();
        boyList.sortWithComparable(false);
        for(int i=1;i<boyList.getSize();i++){
            assertTrue(boyList.getCreature(i).getName().compareTo(boyList.getCreature(i-1).getName())<0);
        }

        monsterList.sortWithComparable(true);
        for(int i=1;i<monsterList.getSize();i++){
            assertTrue(monsterList.getCreature(i).getName().compareTo(monsterList.getCreature(i-1).getName())>0);
        }
        monsterList.shuffleWithComparable();
        monsterList.sortWithComparable(false);
        for(int i=1;i<monsterList.getSize();i++){
            assertTrue(monsterList.getCreature(i).getName().compareTo(monsterList.getCreature(i-1).getName())<0);
        }
        System.out.println("Sorting Creatrue List Success");
    }
    @Test
    public void testSortByGender(){
        boyList.sortByGender();
        List<CalabashBoy> maleList = boyList.getMaleList();
        List<CalabashBoy> femaleList = boyList.getFemaleList();
        for(CalabashBoy i:maleList){
            assertTrue(i.gender);
        }
        for(CalabashBoy i:femaleList){
            assertTrue(!i.gender);
        }
        System.out.println("Sorting Creatrue List By Gender Success");
    }
    @Test(timeout = 10)
    public void testSortHuluWasTime(){
        boyList.shuffleWithComparable();
        boyList.sortWithComparable(true);
        boyList.shuffleWithComparable();
        boyList.sortWithComparator(false);
        boyList.sortByGender();
        monsterList.shuffleWithComparable();
        monsterList.sortWithComparable(true);
        monsterList.shuffleWithComparable();
        monsterList.sortWithComparator(false);
        monsterList.sortByGender();
        System.out.println("Sorting Creatrue List Pressure Test Success");
    }
}