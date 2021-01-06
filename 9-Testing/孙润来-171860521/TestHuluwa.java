package homework_9;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TestHuluwa {
    private static HuluBro<Huluwa> hulu;
    private static final int num = 3000;
    private static final int order = 2;
    @BeforeClass
    public static void init(){
        hulu = new HuluBro<>(num,new HFactory());
    }

    @AfterClass
    public static void finish(){
        hulu.clear();
    }

    @Test
    public void testHuluwa(){
        Iterator<Huluwa> iterator = hulu.getIerator();
        while(iterator.hasNext()){
            assertTrue(iterator.next() instanceof Huluwa);
        }
    }

    @Test
    public void testSort(){
        Iterator<Huluwa> iterator = hulu.getIerator();
        Huluwa p = iterator.next();
        Huluwa q;
        hulu.sortByComparable(order);
        boolean flag = true;
        if(order==1) {
            while (iterator.hasNext()) {
                q = iterator.next();
                if(p.getGender() != q.getGender()) {
                    p = q;
                    assertTrue(p.getGender());
                    assertFalse(q.getGender());
                    assertTrue(flag);
                    flag = false;
                    continue;
                }
                assertTrue(p.getName().compareTo(q.getName())<=0);
                p = q;
            }
        }
        else if(order==2){
            while (iterator.hasNext()) {
                q = iterator.next();
                if(p.getGender() != q.getGender()) {
                    p = q;
                    continue;
                }
                assertTrue(p.getName().compareTo(q.getName())>=0);
                p = q;
            }
        }
    }

    @Test(timeout = 1000)
    public void testSortTime(){
        hulu.sortByComparable(order);
    }
}
