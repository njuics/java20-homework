
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
* Calabash Tester. 
*
*/ 
public class CalabashTest {
    int lenOfQueue;
    SortAdapter<Calabash> sortAdapter;
    Rand.RandName N;
    Rand.RandGender G;
    IterableQueue<Calabash> queue;

@Before
public void before() {
    lenOfQueue = 10;
    List<Calabash> q = new ArrayList<>();
    sortAdapter = new SortAdapter<>();
    N = new Rand.RandName();
    G = new Rand.RandGender();
    while (q.size() < lenOfQueue)q.add(new Calabash(N.get(),G.get(),new Position(q.size())));
    queue = new IterableQueue<>(q);
} 


/** 
* 
* Test instance of Calabash
* 
*/ 
@Test
public void testCalabash() throws Exception {
   for (Creature c : queue.getC())
       assertTrue(c instanceof Calabash);
} 

/** 
* 
* test order
* 
*/ 
@Test
public void testOrder() throws Exception {
    sortAdapter.sortByComparator(queue);
    List<Calabash> l = queue.getC();
    Iterator<Calabash> it = l.iterator();
    Calabash tmp = it.next();
    while (it.hasNext()){
        Calabash now = it.next();
        assertTrue (now.getName().compareTo(tmp.getName()) >= 0);
        tmp = now;
    }
}

/**
 * test efficiency of sorting
 */
@Test(timeout = 1000)
public void testEfficiency() throws Exception{
    sortAdapter.sortByComparable(queue);
}

} 
