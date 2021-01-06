package algorithm;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/** 
* Sort Tester. 
* 
* @author Lin Hao
* @since <pre>11/22/2020</pre>
* @version 1.0 
*/ 
public class SortTest {
    Random r = new Random(47);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        System.out.println("@AfterClass");
    }

    @Before
    public void before() throws Exception {
        System.out.println("Begin Unit Test for Sort");
    }

    @After
    public void after() throws Exception {
        System.out.println("End Unit Test for Sort");
    }

    /**
    *
    * Method: insertionSort(ArrayList<T> array)
    *
    */
    @Test(timeout = 10000)
    public void testInsertionSortArray() throws Exception {
        ArrayList<Integer> arrInt = createIntegerArrayList(100000);
        int arrLength = arrInt.size();
        Sort.insertionSort(arrInt);
        for(int i = 1; i < arrLength; ++i){
            assertTrue("Some pair is inversed!",
                    arrInt.get(i-1) <= arrInt.get(i));
        }
    }

    /**
    *
    * Method: insertionSort(ArrayList<T> array, E instructor)
    *
    */
    @Test(timeout = 10000)
    public void testInsertionSortForArrayInstructor() throws Exception {
        ArrayList<Integer> arrInt = createIntegerArrayList(100000);
        int arrLength = arrInt.size();
        Sort.insertionSort(arrInt, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        for(int i = 1; i < arrLength; ++i){
            assertTrue("Some pair is inversed!",
                    arrInt.get(i-1) <= arrInt.get(i));
        }
    }

    /**
     *
     * Method: quickSort(ArrayList<T> array, int left, int right)
     *
     */
    @Test(timeout = 1000)
    public void testQuickSort() throws Exception{
        ArrayList<Integer> arrInt = createIntegerArrayList(100000);
        int arrLength = arrInt.size();
        Sort.quickSort(arrInt, 0, arrLength - 1);
        for(int i = 1; i < arrLength; ++i){
            assertTrue("Some pair is inversed!",
                    arrInt.get(i-1) <= arrInt.get(i));
        }
    }

    /**
    *
    * Method: create an Integer type ArrayList for Unit Test
    *
     */
    private ArrayList<Integer> createIntegerArrayList(int capacity){
        ArrayList<Integer> arrInt = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; ++i){
            arrInt.add(i, r.nextInt(capacity));
        }
        return arrInt;
    }
}

