package huluwa.tools;

import huluwa.characters.CalabashBrother;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.collect.Ordering;

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
        Ordering<CalabashBrother> natural = Ordering.natural();
        QuickSorter.sort(queue, natural);
        assertTrue(natural.isOrdered(queue));
    }

    @Test(timeout = 2000)
    public void testSortDescending() {
        QuickSorter QuickSorter = new QuickSorter();
        Ordering<CalabashBrother> natural = Ordering.natural();
        Ordering<CalabashBrother> descending = natural.reverse();
        QuickSorter.sort(queue, descending);
        assertTrue(descending.isOrdered(queue));
    }

    @Test(timeout = 2000)
    public void testSortRandom() {
        QuickSorter QuickSorter = new QuickSorter();
        Ordering<? super CalabashBrother> random = Ordering.arbitrary();
        QuickSorter.sort(queue, random);
        assertTrue(random.isOrdered(queue));
    }
}
