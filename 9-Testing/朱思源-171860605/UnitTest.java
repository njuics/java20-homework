import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void testCreature(){
        System.out.println("Test compareTo() start.");
        Creature a=new Calabash("A");
        Creature b=new Calabash("B");
        Creature c=new Calabash("C");
        assertTrue(b.compareTo(a)>0);
        assertTrue(b.compareTo(b)==0);
        assertTrue(b.compareTo(c)<0);
        System.out.println("Test compareTo() success!");
    }

    @Test
    public void testSort(){
        System.out.println("Test quickSort() start.");

        final int TEST_LEN=10;

        List<Creature> creatures=new ArrayList<>();
        List<Calabash> calabashes=new ArrayList<>();
        List<Monster> monsters =new ArrayList<>();

        Random random=new Random();
        for(int i=0;i<TEST_LEN;i++){
            monsters.add(new Monster());
            calabashes.add(new Calabash());
            if(random.nextInt()>0){
                creatures.add(new Monster());
            }else{
                creatures.add(new Calabash());
            }
        }

        Main.quickSort(creatures);
        Main.quickSort(calabashes);
        Main.quickSort(monsters);

        for(int i=0;i<TEST_LEN-1;i++)
        {
            assertTrue(creatures.get(i).compareTo(creatures.get(i+1))<=0);
            assertTrue(calabashes.get(i).compareTo(calabashes.get(i+1))<=0);
            assertTrue(monsters.get(i).compareTo(monsters.get(i+1))<=0);
        }

        System.out.println("Test quickSort success");
    }
}
