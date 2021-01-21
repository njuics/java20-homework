import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

    private static List<Creature> cList = new ArrayList<>();
    private static Random random = new Random();

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
        List<Creature> cpList = new ArrayList<>(cList);
        CustomSort.quickSort(cList);
        Collections.sort(cpList);
        assertEquals(cpList, cList);
    }

    @Test
    public void insertSortTest() {
        List<Creature> cpList = new ArrayList<>(cList);
        CustomSort.insertSort(cList);
        Collections.sort(cpList);
        assertEquals(cpList, cList);
    }
}
