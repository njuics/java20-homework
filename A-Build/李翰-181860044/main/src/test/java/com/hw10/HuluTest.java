package com.hw10;

import org.junit.Test;
import static org.junit.Assert.*;

public class HuluTest {
    @Test
    public void testCreature() throws Exception {
        Hulu c = new Hulu("ccc");
        Hulu d = new Hulu("ddd");
        assertEquals("ccc", c.getName());
        assertEquals("ddd", d.getName());
    }

    @Test
    public void testCompareTo() throws Exception {
        Hulu a = new Hulu("abcd");
        Hulu b = new Hulu("abdc");
        Hulu c = new Hulu("abcd");
        assertEquals(-1, a.compareTo(b));
        assertEquals(0, a.compareTo(c));
        assertEquals(1, b.compareTo(c));
    }
}
