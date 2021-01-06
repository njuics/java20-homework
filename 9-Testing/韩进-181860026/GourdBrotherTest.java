import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class GourdBrotherTest
{
    CreatureFamily<GourdBrother> gourdFamily = new CreatureFamily<>();

    @Before
    public void setupBeforeTest()
    {
        GourdBrother gb1 = new GourdBrother("a", true);
        GourdBrother gb2 = new GourdBrother("b", true);
        GourdBrother gb3 = new GourdBrother("c", true);
        GourdBrother gb4 = new GourdBrother("d", false);
        GourdBrother gb5 = new GourdBrother("e", false);
        GourdBrother gb6 = new GourdBrother("f", false);
        gourdFamily.add(gb6);
        gourdFamily.add(gb1);
        gourdFamily.add(gb5);
        gourdFamily.add(gb2);
        gourdFamily.add(gb4);
        gourdFamily.add(gb3);
    }


    @Test
    public void testPositiveSort()
    {
        Iterator<GourdBrother> it = gourdFamily.iterator();
        assertEquals(it.next().name, "a");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "c");
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "f");
        assertFalse(it.hasNext());
    }

    @Test
    public void testReverseSort()
    {
        Iterator<GourdBrother> it = gourdFamily.reverseIterator().iterator();
        assertEquals(it.next().name, "f");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "c");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "a");
        assertFalse(it.hasNext());
    }

    @Test
    public void testMaleSort()
    {
        Iterator<GourdBrother> it = gourdFamily.maleIterator().iterator();
        assertEquals(it.next().name, "a");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "c");
        assertFalse(it.hasNext());
    }

    @Test
    public void testFemaleSort()
    {
        Iterator<GourdBrother> it = gourdFamily.femaleIterator().iterator();
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "f");
        assertFalse(it.hasNext());
    }
}
