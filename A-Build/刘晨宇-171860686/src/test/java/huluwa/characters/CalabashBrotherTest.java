package huluwa.characters;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;

public class CalabashBrotherTest {
    private static final int nBubbleSort = 1000;
    private static final int nQuickSort = 50000;
    private static ArrayList<CalabashBrother> bubbleSortQueue;
    private static ArrayList<CalabashBrother> quickSortQueue;

    @BeforeClass
    public static void initQueue() {
        bubbleSortQueue = new ArrayList<>(nBubbleSort);
        quickSortQueue = new ArrayList<>(nQuickSort);
        for(int i = 0; i < nBubbleSort; i++) {
            bubbleSortQueue.add(new CalabashBrother());
        }
        for(int i = 0; i < nQuickSort; i++) {
            quickSortQueue.add(new CalabashBrother());
        }
    }

    @Before
    public void shuffle() {
        Collections.shuffle(bubbleSortQueue);
        Collections.shuffle(quickSortQueue);
    }

    @Test
    public void testBubbleSortAscending() {
        Ordering<CalabashBrother> natural = Ordering.natural();
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, 0, bubbleSortQueue.size() - 1,
                natural);
        assertTrue(natural.isOrdered(bubbleSortQueue));
    }

    @Test
    public void testBubbleSortDescending() {
        Ordering<CalabashBrother> natural = Ordering.natural();
        Ordering<CalabashBrother> descending = natural.reverse();
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, 0, bubbleSortQueue.size() - 1, descending);
        assertTrue(descending.isOrdered(bubbleSortQueue));
    }

    @Test
    public void testBubbleSortRandom() {
        Ordering<? super CalabashBrother> random = Ordering.arbitrary();
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, 0, bubbleSortQueue.size() - 1, random);
        assertTrue(random.isOrdered(bubbleSortQueue));
    }

    @Test(timeout = 2000)
    public void testQuickSortAscending() {
        CalabashBrother base = quickSortQueue.get(0);
        int startIndex = quickSortQueue.size() - 1;
        Ordering<CalabashBrother> natural = Ordering.natural();
        quickSortQueue.get(startIndex).quickSort(quickSortQueue, startIndex, base, 0,
                false, natural);
        assertTrue(natural.isOrdered(quickSortQueue));
    }

    @Test(timeout = 2000)
    public void testQuickSortDescending() {
        CalabashBrother base = quickSortQueue.get(0);
        Ordering<CalabashBrother> natural = Ordering.natural();
        Ordering<CalabashBrother> descending = natural.reverse();
        int startIndex = quickSortQueue.size() - 1;
        quickSortQueue.get(startIndex).quickSort(quickSortQueue, startIndex, base, 0,
                false, descending);
        assertTrue(descending.isOrdered(quickSortQueue));
    }

    @Test(timeout = 2000)
    public void testQuickSortRandom() {
        CalabashBrother base = quickSortQueue.get(0);
        Ordering<? super CalabashBrother> random = Ordering.arbitrary();
        int startIndex = quickSortQueue.size() - 1;
        quickSortQueue.get(startIndex).quickSort(quickSortQueue, startIndex, base, 0,
                false, random);
        assertTrue(random.isOrdered(quickSortQueue));
    }
}
