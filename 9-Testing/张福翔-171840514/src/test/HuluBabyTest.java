package test;

import creature.Creature;
import creature.HuluBaby;
import org.junit.*;
import utils.comparator.InOrderComparator;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/** 
* HuluBaby Tester. 
* 
* @author sicer
* @since <pre>11月 16, 2020</pre> 
* @version 1.0 
*/ 
public class HuluBabyTest {
    static int sampleNum = 10000;
    static <T> void assertContain(T item, T[]arr) {
        boolean result = false;
        for (T element : arr) {
            if (item.equals(element))
                result = true;
        }
        assertTrue(result);
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Doing HuluBaby test...");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("HuluBaby test ends");
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: sampleGender()
    *
    */
    @Test
    public void testSampleGender() throws Exception {
    //TODO: Test goes here...
        for (int i = 0; i < sampleNum; i++) {
            HuluBaby.Gender gender = HuluBaby.sampleGender();
            assertContain(gender, HuluBaby.Gender.values());
        }
    }

    /**
    *
    * Method: sampleName()
    *
    */
    @Test
    public void testSampleName() throws Exception {
    //TODO: Test goes here...
        for (int i = 0; i < sampleNum; i++) {
            String name = HuluBaby.sampleName();
            assertTrue(name.length() >= 4 && name.length() <= 7);
        }
    }

    /**
    *
    * Method: huluBabiesGreetings(ArrayList<HuluBaby> huluBabies)
    *
    */
    @Test
    public void testHuluBabiesGreetings() throws Exception {
    //TODO: Test goes here...
        System.out.println("Testing huluBabiesGreetings");
        ArrayList<HuluBaby> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            arr.add(new HuluBaby(HuluBaby.HuluOrder.OTHERS, HuluBaby.sampleName(), HuluBaby.sampleGender()));
        HuluBaby.huluBabiesGreetings(arr);
        System.out.println("Test huluBabiesGreetings ends");
    }

    /**
    *
    * Method: compareTo(Creature o)
    *
    */
    @Test
    public void testCompareTo() throws Exception {
    //TODO: Test goes here...
        ArrayList<HuluBaby> arr = new ArrayList<>();
        for (int i = 0; i < sampleNum; i++)
            arr.add(new HuluBaby(HuluBaby.HuluOrder.OTHERS, HuluBaby.sampleName(), HuluBaby.sampleGender()));
        ArrayList<HuluBaby> arr2 = new ArrayList<>(arr);
        Collections.sort(arr);
        arr2.sort(new InOrderComparator<Creature>());
        assertArrayEquals(arr.toArray(), arr2.toArray());
    }


} 
