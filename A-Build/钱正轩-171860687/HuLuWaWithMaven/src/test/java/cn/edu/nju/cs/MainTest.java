package cn.edu.nju.cs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Ordering;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

    private static List<Creature> cList = new ArrayList<>();
    private static Random random = new Random();
    private Ordering<Creature> byDefault = new Ordering<Creature>(){
        public int compare(Creature left, Creature right) {
            return left.compareTo(right);
        };
    };

    @BeforeClass
    public static void initList() {
        for (int i = 0; i < 12; i++) {
            if (random.nextBoolean()) {
                cList.add(new HuLuWa());
            } else {
                cList.add(new Monster());
            }
        }
    }

    @Before
    public void shuffle() {
        Collections.shuffle(cList);
    }

    @Test
    public void quickSortTest() {
        CustomSort.quickSort(cList);
        assertTrue(byDefault.isOrdered(cList));
    }

    @Test
    public void insertSortTest() {
        CustomSort.insertSort(cList);
        assertTrue(byDefault.isOrdered(cList));
    }
}
