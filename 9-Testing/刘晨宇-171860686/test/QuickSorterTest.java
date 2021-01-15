import huluwa.characters.CalabashBrother;
import huluwa.tools.QuickSorter;
import huluwa.tools.DescendingComparator;
import huluwa.tools.RandomComparator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSorterTest {
    private static final int nCalabashBrothers = 50000;
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

    @Test(timeout = 2000)
    public void testSortAscending() {
        QuickSorter QuickSorter = new QuickSorter();
        QuickSorter.sort(queue, CalabashBrother::compareTo);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(queue.get(i).compareTo(queue.get(i + 1)) <= 0);
        }
    }

    @Test(timeout = 2000)
    public void testSortDescending() {
        QuickSorter QuickSorter = new QuickSorter();
        DescendingComparator comparator = new DescendingComparator();
        QuickSorter.sort(queue, comparator);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(comparator.compare(queue.get(i), queue.get(i + 1)) <= 0);
        }
    }

    @Test(timeout = 2000)
    public void testSortRandom() {
        QuickSorter QuickSorter = new QuickSorter();
        RandomComparator comparator = new RandomComparator();
        QuickSorter.sort(queue, comparator);
        for(int i = 0; i < nCalabashBrothers - 1; i++) {
            assertTrue(comparator.compare(queue.get(i), queue.get(i + 1)) <= 0);
        }
    }
}
