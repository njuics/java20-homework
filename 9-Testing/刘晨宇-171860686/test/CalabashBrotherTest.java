import huluwa.characters.CalabashBrother;
import huluwa.tools.DescendingComparator;
import huluwa.tools.NotInQueueException;
import huluwa.tools.RandomComparator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testBubbleSortAscending() throws Exception {
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, bubbleSortQueue.size() - 1,
                CalabashBrother::compareTo);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(bubbleSortQueue.get(i).compareTo(bubbleSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testBubbleSortDescending() throws Exception {
        DescendingComparator comparator = new DescendingComparator();
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, bubbleSortQueue.size() - 1, comparator);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(comparator.compare(bubbleSortQueue.get(i), bubbleSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testBubbleSortRandom() throws Exception {
        RandomComparator comparator = new RandomComparator();
        bubbleSortQueue.get(0).bubbleSort(bubbleSortQueue, bubbleSortQueue.size() - 1, comparator);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(comparator.compare(bubbleSortQueue.get(i), bubbleSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test(expected = NotInQueueException.class)
    public void testBubbleSortException() throws Exception {
        CalabashBrother outsider = new CalabashBrother();
        outsider.bubbleSort(bubbleSortQueue, bubbleSortQueue.size() - 1, CalabashBrother::compareTo);
    }

    @Test(timeout = 2000)
    public void testQuickSortAscending() throws Exception {
        CalabashBrother base = quickSortQueue.get(0);
        quickSortQueue.get(quickSortQueue.size() - 1).quickSort(quickSortQueue, base, 0,
                false, CalabashBrother::compareTo);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(quickSortQueue.get(i).compareTo(quickSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test(timeout = 2000)
    public void testQuickSortDescending() throws Exception {
        CalabashBrother base = quickSortQueue.get(0);
        DescendingComparator comparator = new DescendingComparator();
        quickSortQueue.get(quickSortQueue.size() - 1).quickSort(quickSortQueue, base, 0,
                false, comparator);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(comparator.compare(quickSortQueue.get(i), quickSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test(timeout = 2000)
    public void testQuickSortRandom() throws Exception {
        CalabashBrother base = quickSortQueue.get(0);
        RandomComparator comparator = new RandomComparator();
        quickSortQueue.get(quickSortQueue.size() - 1).quickSort(quickSortQueue, base, 0,
                false, comparator);
        for(int i = 0; i < nBubbleSort - 1; i++) {
            assertTrue(comparator.compare(quickSortQueue.get(i), quickSortQueue.get(i + 1)) <= 0);
        }
    }

    @Test(expected = NotInQueueException.class)
    public void testQuickSortException() throws Exception {
        CalabashBrother outsider = new CalabashBrother();
        CalabashBrother base = quickSortQueue.get(0);
        outsider.quickSort(quickSortQueue, base, 0,
                false, CalabashBrother::compareTo);
    }
}
