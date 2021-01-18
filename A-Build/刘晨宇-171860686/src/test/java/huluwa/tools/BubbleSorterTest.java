package huluwa.tools;

import huluwa.characters.CalabashBrother;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.collect.Ordering;

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
        Ordering<CalabashBrother> natural = Ordering.natural();
        bubbleSorter.sort(queue, natural);
        assertTrue(natural.isOrdered(queue));
    }

    @Test
    public void testSortDescending() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        Ordering<CalabashBrother> natural = Ordering.natural();
        Ordering<CalabashBrother> descending = natural.reverse();
        bubbleSorter.sort(queue, descending);
        assertTrue(descending.isOrdered(queue));
    }

    @Test
    public void testSortRandom() {
        BubbleSorter bubbleSorter = new BubbleSorter();
        Ordering<? super CalabashBrother> random = Ordering.arbitrary();
        bubbleSorter.sort(queue, random);
        assertTrue(random.isOrdered(queue));
    }
}
