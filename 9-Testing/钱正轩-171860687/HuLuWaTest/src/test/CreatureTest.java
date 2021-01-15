import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CreatureTest {
    @Test
    public void testHuLuWa() {
        Creature a = new HuLuWa("A");
        Creature b = new HuLuWa("B");
        Creature c = new HuLuWa("C");
        Creature aa = new HuLuWa("A");

        assertTrue(b.compareTo(b) == 0);
        assertTrue(b.compareTo(a) > 0);
        assertTrue(b.compareTo(c) < 0);
        assertEquals(a, aa);
    }

    @Test
    public void testMonster() {
        Creature a = new Monster("A", 10);
        Creature b = new Monster("B", 9);
        Creature c = new Monster("A", 8);
        Creature aa = new Monster("A", 10);

        assertTrue(b.compareTo(a) > 0);
        assertTrue(a.compareTo(c) > 0);
        assertEquals(a, aa);
    }

    @Test
    public void hybridTest() {
        Creature a = new HuLuWa("A");
        Creature b = new Monster("B", 15);
        assertTrue(a.compareTo(b) < 0);
    }
}
