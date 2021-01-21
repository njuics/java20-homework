package com.xjm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CalabashCollectionTest {
    ArrayList<Calabash> Cal1 = new ArrayList<Calabash>();

    @Before
    public void setUp(){
        Cal1 = new ArrayList<Calabash>(){
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            {
                add(new Calabash("a", "male"));
                add(new Calabash("f", "female"));
                add(new Calabash("b", "male"));
                add(new Calabash("g", "female"));
                add(new Calabash("c", "male"));
                add(new Calabash("h", "female"));
                add(new Calabash("d", "male"));
                add(new Calabash("i", "female"));
                add(new Calabash("e", "male"));
                add(new Calabash("j", "female"));
            }
        };
    }

    @After
    public void tearDown(){
        this.Cal1 = null;
    }


    @Test
    public void testsortBySex() throws InstantiationException, IllegalAccessException {
        ArrayList<Calabash> Cal = CalabashCollection.sortBySex(Cal1,"male",Calabash.class);
        Iterator<Calabash> iter = Cal.iterator();
        String sexkind = iter.next().get_sex();
        while(iter.hasNext()) {
			assertEquals(iter.next().get_sex(), sexkind);
		}
       
    }

    @Test
    public void testsortByComparable() {
        CalabashCollection.sortByComparable(Cal1);
        Iterator<Calabash> it = Cal1.iterator();
        assertEquals(it.next().name, "a");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "c");
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "f");
	    assertEquals(it.next().name, "g");
        assertEquals(it.next().name, "h");
        assertEquals(it.next().name, "i");
	    assertEquals(it.next().name, "j");
        assertFalse(it.hasNext());
    }

    @Test
    public void testincSort() {
        CalabashCollection.incSort(Cal1);
        Iterator<Calabash> it = Cal1.iterator();
        assertEquals(it.next().name, "a");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "c");
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "f");
	    assertEquals(it.next().name, "g");
        assertEquals(it.next().name, "h");
        assertEquals(it.next().name, "i");
	    assertEquals(it.next().name, "j");
        assertFalse(it.hasNext());
    }

    @Test
    public void testdecSort() {
        CalabashCollection.decSort(Cal1);
        Iterator<Calabash> it = Cal1.iterator();
	    assertEquals(it.next().name, "j");
        assertEquals(it.next().name, "i");
        assertEquals(it.next().name, "h");
	    assertEquals(it.next().name, "g");
        assertEquals(it.next().name, "f");
        assertEquals(it.next().name, "e");
        assertEquals(it.next().name, "d");
        assertEquals(it.next().name, "c");
        assertEquals(it.next().name, "b");
        assertEquals(it.next().name, "a");
        assertFalse(it.hasNext());
    }


  
}
