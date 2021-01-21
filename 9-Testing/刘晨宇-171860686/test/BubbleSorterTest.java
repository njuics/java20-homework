import huluwa.characters.CalabashBrother;
import huluwa.tools.BubbleSorter;
import huluwa.tools.DescendingComparator;
import huluwa.tools.RandomComparator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSorterTest {
    private static final int nCalabashBrothers = 1000;
    private static ArrayList<CalabashBrother> queue;

    @BeforeClass
    public static void initQueue() {
        queue = new ArrayList<>(nCalabashBrothers);
        for(int i = 0; i < nCalabashBrothers; i++) {
            queue.add(new CalabashBrother());
        }
    }

    @Before
    public void shuffle() {
        Collections.shuffle(queue);
    }

    @Test
    public void testSortAscending() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(queue, CalabashBrother::compareTo);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(queue.get(i).compareTo(queue.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortDescending() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        DescendingComparator comparator = new DescendingComparator();
        bubbleSorter.sort(queue, comparator);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(comparator.compare(queue.get(i), queue.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testSortRandom() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        RandomComparator comparator = new RandomComparator();
        bubbleSorter.sort(queue, comparator);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(comparator.compare(queue.get(i), queue.get(i + 1)) <= 0);
        }
    }
}
