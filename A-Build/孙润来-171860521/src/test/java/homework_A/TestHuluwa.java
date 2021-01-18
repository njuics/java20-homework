package homework_A;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import com.google.common.collect.Ordering;
import static org.junit.Assert.*;

public class TestHuluwa {
    private static HuluBro<Huluwa> hulu;
    private static final int num = 3000;
    private static final int order = 2;
    @BeforeClass
    public static void init(){
        hulu = new HuluBro<Huluwa>(num,new HFactory());
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
        hulu.sortByComparable(order);
        if(order==1) {
            Ordering<Huluwa> testHulu = new Ordering<Huluwa>() {
                @Override
                public int compare(@Nullable Huluwa huluwa, @Nullable Huluwa t1) {
                    if(huluwa.getGender()!=t1.getGender()){
                        return huluwa.getGender()?-1:1;
                    }
                    return huluwa.getName().compareTo(t1.getName());
                }
            };
            assertTrue(testHulu.isOrdered(hulu.getItertable()));
        }
        else if(order==2){
            Ordering<Huluwa> testHulu = new Ordering<Huluwa>() {
                @Override
                public int compare(@Nullable Huluwa huluwa, @Nullable Huluwa t1) {
                    if(huluwa.getGender()!=t1.getGender()){
                        return huluwa.getGender()?-1:1;
                    }
                    return t1.getName().compareTo(huluwa.getName());
                }
            };
            assertTrue(testHulu.isOrdered(hulu.getItertable()));
        }
    }

    @Test(timeout = 1000)
    public void testSortTime(){
        hulu.sortByComparable(order);
    }
}
