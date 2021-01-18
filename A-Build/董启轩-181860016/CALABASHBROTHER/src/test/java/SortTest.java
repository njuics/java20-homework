import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

import java.lang.Integer;
import static org.junit.Assert.*;
public class SortTest {
    CreatureList<CalabashBrother> list=new CreatureList<>();
    @Before
    public void construction(){
        System.out.println("Construciton start...");
        for(int i=3;i<7;i++){
            CalabashBrother bro=new CalabashBrother("brother"+Integer.toString(i),Gender.FEMALE);
            list.add(bro);
        }
        for(int i=0;i<3;i++)
        {
            CalabashBrother bro=new CalabashBrother("brother"+Integer.toString(i),Gender.MALE);
            list.add(bro);
        }
        System.out.println("Construction complete.");
    }

    @Test
    public void testSort()
    {
        System.out.println("SortTest start..."); 
        list.sort(Order.POSITIVE);
        Iterator<CalabashBrother> iter=list.iterator();
        for(int i=0;i<7;i++){
            assertEquals(iter.next().getName(), "brother"+Integer.toString(i));
        }
        assertFalse(iter.hasNext());
        System.out.println("Positive Sort Passed!");
        list.sort(Order.NEGATIVE);
        Iterator<CalabashBrother> riter=list.reverseIterator();
        for(int i=0;i<7;i++){
            assertEquals(riter.next().getName(), "brother"+Integer.toString(i));
        }
        assertFalse(riter.hasNext());
        System.out.println("Negative Sort Passed!");
        System.out.println("SortTest complete."); 
    }

    @Test(timeout=2000)
    public void testRandomsort(){
        System.out.println("RandomsortTest start..."); 
        list.sort(Order.RANDOM);
        System.out.println("RandomsortTest complete."); 
    }
}