import org.junit.Test;
import static org.junit.Assert.*;

import creature.*;
import creature.calabash.*;
import creature.monster.*;
import java.util.*;
import org.apache.commons.lang3.RandomStringUtils;

public class MyTest {
    @Test
    public void testCalabashEqual() throws Exception {
        Calabash c1 = new Calabash("aaaa", true);
        Calabash c2 = new Calabash("aaaa", true);
        assertEquals(c1, c2);

        c2 = new Calabash("aaaa", false);
        assertNotEquals(c1, c2);

        Calabash c3 = new Calabash("aaaaa", true);
        assertNotEquals(c1, c3);

        Monster c4 = new Monster("aaaa", 1 ,1);
        assertNotEquals(c1, c4);
    }

    @Test
    public void testCalabashSort() throws Exception {
        LinkedList<Calabash> testList = new LinkedList<Calabash> ();
        testList.add(new Calabash("a4", true));
        testList.add(new Calabash("a1", true));
        testList.add(new Calabash("zj", true));
        testList.add(new Calabash("bg", true));
        testList.add(new Calabash("bgg", true));
        testList.add(new Calabash("zx", true));
        testList.add(new Calabash("123", true));
        testList.add(new Calabash("123", false));
        testList.add(new Calabash("666", false));

        LinkedList<Calabash> expectedList = new LinkedList<Calabash> ();
        expectedList.add(new Calabash("123", true));
        expectedList.add(new Calabash("123", false));
        expectedList.add(new Calabash("666", false));
        expectedList.add(new Calabash("a1", true));
        expectedList.add(new Calabash("a4", true));
        expectedList.add(new Calabash("bg", true));
        expectedList.add(new Calabash("bgg", true));
        expectedList.add(new Calabash("zj", true));
        expectedList.add(new Calabash("zx", true));

        CreatureSort.doCalabashSort(testList, 0);
        assertEquals(expectedList, testList);

        LinkedList<Calabash> expectedList2 = new LinkedList<Calabash> ();
        CreatureSort.doCalabashSort(testList, 1);
        for (Calabash c : expectedList) {
            expectedList2.addFirst(c);
        }
        assertEquals(expectedList2, testList);
    }

    @Test
    public void testCalabashRandomNameSort() throws Exception{
        Random rd = new Random();
        int total = rd.nextInt(20) + 1; //1~20人
        LinkedList<String> stringList = new LinkedList<String> ();
        LinkedList<Calabash> testList = new LinkedList<Calabash> ();
        for(int i = 0; i < total; i++) {
            int length =  rd.nextInt(5) + 1;
            String tempName = RandomStringUtils.random(length, true, false);
            boolean tempGender = true;
            tempGender = (int)(rd.nextInt(2)) == 1 ? true : false;
            testList.add(new Calabash(tempName, tempGender));
            stringList.add(tempName);
        }

        Collections.sort(stringList);
        CreatureSort.doCalabashSort(testList, 0);
        for(int i = 0; i < total; i++){
            assertEquals(stringList.get(i), testList.get(i).getName());
        }

        Collections.sort(stringList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
        }
        );
        CreatureSort.doCalabashSort(testList, 1);
        for(int i = 0; i < total; i++){
            assertEquals(stringList.get(i), testList.get(i).getName());
        }
    }

    @Test
    public void testCalabashBoys() throws Exception {
        CalabashBoys cBoys = new CalabashBoys(10);
        LinkedList<String> stringList = new LinkedList<String> ();

        for (Calabash c: cBoys.set){
            stringList.add(c.getName());
        }
        Collections.sort(stringList);
        cBoys.sort(0);
        for(int i = 0; i < cBoys.set.size(); i++){
            assertEquals(stringList.get(i), cBoys.set.get(i).getName());
        }

        Collections.sort(stringList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
        }
        );
        cBoys.sort(1);
        for(int i = 0; i < cBoys.set.size(); i++){
            assertEquals(stringList.get(i), cBoys.set.get(i).getName());
        }
    }

    @Test
    public void testCalabashGender() throws Exception {
        LinkedList<Calabash> testList = new LinkedList<Calabash> ();
        testList.add(new Calabash("a4", true));
        testList.add(new Calabash("a1", true));
        testList.add(new Calabash("zj", false));
        testList.add(new Calabash("bg", true));
        testList.add(new Calabash("bgg", false));
        testList.add(new Calabash("zx", true));
        testList.add(new Calabash("123", true));
        testList.add(new Calabash("123", false));
        testList.add(new Calabash("666", false));

        CalabashBoys cBoys = new CalabashBoys(testList);

        LinkedList<Calabash> expectedList = new LinkedList<Calabash> ();
        expectedList.add(new Calabash("a4", true));
        expectedList.add(new Calabash("a1", true));
        expectedList.add(new Calabash("bg", true));
        expectedList.add(new Calabash("zx", true));
        expectedList.add(new Calabash("123", true));

        LinkedList<Calabash> expectedList2 = new LinkedList<Calabash> ();
        expectedList2.add(new Calabash("zj", false));
        expectedList2.add(new Calabash("bgg", false));
        expectedList2.add(new Calabash("123", false));
        expectedList2.add(new Calabash("666", false));

        assertEquals(expectedList, cBoys.getBoyCalabashs().set);
        assertEquals(expectedList2, cBoys.getGirlCalabashs().set);

    }

    @Test
    public void testCreatureSort() throws Exception {
        LinkedList<Creature> testList = new LinkedList<Creature> ();
        testList.add(new Calabash("a4", true));
        testList.add(new Monster("a1", 100, 114514));
        testList.add(new Calabash("zj", true));
        testList.add(new Calabash("bg", true));
        testList.add(new Calabash("bgg", true));
        testList.add(new Monster("zx", 1, 1));
        testList.add(new Calabash("123", true));
        testList.add(new Calabash("666", false));

        LinkedList<Creature> expectedList = new LinkedList<Creature> ();
        expectedList.add(new Calabash("123", true));
        expectedList.add(new Calabash("666", false));
        expectedList.add(new Monster("a1", 100, 114514));
        expectedList.add(new Calabash("a4", true));
        expectedList.add(new Calabash("bg", true));
        expectedList.add(new Calabash("bgg", true));
        expectedList.add(new Calabash("zj", true));
        expectedList.add(new Monster("zx", 1, 1));

        CreatureSort.doCreatureSort(testList, 0);
        assertEquals(expectedList, testList);

        LinkedList<Creature> expectedList2 = new LinkedList<Creature> ();
        CreatureSort.doCreatureSort(testList, 1);
        for (Creature c : expectedList) {
            expectedList2.addFirst(c);
        }
        assertEquals(expectedList2, testList);

    }
}