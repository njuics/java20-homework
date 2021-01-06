import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;

public class HuluwaTest {

    private int huluNumber = 7;

    @Test
    public void testSortByAsc() {
        //new HuluwaQueue and add huluwa
        HuluwaQueue queue = new HuluwaQueue();
        for (int i = 0; i < huluNumber; i++) {
            queue.add(new Huluwa());
        }
        //call function to be tested
        queue.sortByAsc();
        //test
        Boolean isAsc = true;
        Iterator<Huluwa> slowIter = queue.iterator();
        Iterator<Huluwa> fastIter = queue.iterator();
        if (fastIter.hasNext()) {
            fastIter.next();
        }
        while (fastIter.hasNext()) {
            Huluwa current = slowIter.next();
            Huluwa next = fastIter.next();
            if (current.compareTo(next) > 0) {
                isAsc = false;
                break;
            }
        }
        //assert
        assertEquals(isAsc, true);
    }

    @Test
    public void testSortByDesc() {
        //new HuluwaQueue and add huluwa
        HuluwaQueue queue = new HuluwaQueue();
        for (int i = 0; i < huluNumber; i++) {
            queue.add(new Huluwa());
        }
        //call function to be tested
        queue.sortByDesc();
        //test
        Boolean isDesc = true;
        Iterator<Huluwa> slowIter = queue.iterator();
        Iterator<Huluwa> fastIter = queue.iterator();
        if (fastIter.hasNext()) {
            fastIter.next();
        }
        while (fastIter.hasNext()) {
            Huluwa current = slowIter.next();
            Huluwa next = fastIter.next();
            if (current.compareTo(next) < 0) {
                isDesc = false;
                break;
            }
        }
        //assert
        assertEquals(isDesc, true);
    }

    @Test
    public void testDivideByGender() {
        //new HuluwaQueue
        HuluwaQueue queue = new HuluwaQueue();
        for (int i = 0; i < 4*huluNumber; i++) {
            queue.add(new Huluwa());
        }
        //call function to be tested
        HuluwaQueue[] twoQueue = queue.divideByGender();
        //test
        HuluwaQueue maleQueue = twoQueue[0];
        HuluwaQueue femaleQueue = twoQueue[1];
        boolean isAllMale = true, isAllFemale = true;
        Iterator<Huluwa> maleIter = maleQueue.iterator();
        Iterator<Huluwa> femaleIter = femaleQueue.iterator();
        while (maleIter.hasNext()) {
            if (maleIter.next().getGender() == Gender.female) {
                isAllMale = false;
            }
        }
        while (femaleIter.hasNext()) {
            if (femaleIter.next().getGender() == Gender.male) {
                isAllFemale = false;
            }
        }
        assertEquals(isAllMale, true);
        assertEquals(isAllFemale, true);
    }
}