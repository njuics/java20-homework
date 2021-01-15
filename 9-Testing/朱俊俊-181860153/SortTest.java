import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class SortTest {

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Test begin.");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Test end.");
    }


    @Test
    public void testInt() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 8, 9));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 8, 9));

        new Sort<Integer, Comparator<Integer>>().sort(arrayList);
        for (int i = 0; i < 6; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

    @Test
    public void testIntComparator() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 8, 9));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(9, 8, 6, 4, 2, 1));
        new Sort<Integer, Comparator<Integer>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 6; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

    @Test
    public void testDouble() {
        ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(4.5, 5.7, 2.8, 3.0, 1.3));
        ArrayList<Double> testList = new ArrayList<>(Arrays.asList(1.3, 2.8, 3.0, 4.5, 5.7));

        new Sort<Double, Comparator<Double>>().sort(arrayList);
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }

    }

    @Test
    public void testDoubleComparator() {
        ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(4.5, 5.7, 2.8, 3.0, 1.3));
        ArrayList<Double> testList = new ArrayList<>(Arrays.asList(5.7,4.5,3.0,2.8,1.3));

        new Sort<Double, Comparator<Double>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

    @Test
    public void testString() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("ac", "bd", "ae", "bbc", "cnn"));
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("ac", "ae", "bbc", "bd", "cnn"));

        new Sort<String, Comparator<String>>().sort(arrayList);
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

    @Test
    public void testStringComparator() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("ac", "bd", "ae", "bbc", "cnn"));
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("cnn", "bd", "bbc", "ae", "ac"));

        new Sort<String, Comparator<String>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }
}