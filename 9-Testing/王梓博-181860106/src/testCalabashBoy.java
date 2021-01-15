/*
 * @Author: zb-nju
 * @Date: 2020-11-15 10:20:56
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-15 12:41:31
 */
import org.junit.Test;

import hw9.*;

import org.junit.Before;

import static org.junit.Assert.*;


public class testCalabashBoy {
    MyCollection<CalabashBoy> CBs;
    String []name = {"a", "b", "c", "d"};

    public testCalabashBoy(){
        CBs = new MyCollection<CalabashBoy>(new CalabashBoyFactory());
        CBs.insert(new CalabashBoy(name[0], Gender.MALE));
        CBs.insert(new CalabashBoy(name[1], Gender.FEMALE));
        CBs.insert(new CalabashBoy(name[2], Gender.MALE));
        CBs.insert(new CalabashBoy(name[3], Gender.FEMALE));
    }

    @Before
    public void shuffle(){
        CBs.sortRandComparator();
    }

    @Test
    public void testSortAscComparator() throws Exception{
        CBs.sortAscComparator();
        int i = 0;
        for(CalabashBoy c:CBs){
            assertEquals(name[i++],c.getName());
        }
    }

    @Test
    public void testSortAscComparable() throws Exception{
        CBs.sortAscComparable();
        int i = 0;
        for(CalabashBoy c:CBs){
            assertEquals(name[i++],c.getName());
        }
    }

    @Test
    public void testSortDescComparator() throws Exception{
        CBs.sortDescComparator();
        int i = name.length - 1;
        for(CalabashBoy c:CBs){
            assertEquals(name[i--],c.getName());
        }
    }

    @Test
    public void testDescAscComparable() throws Exception{
        CBs.sortDescComparable();
        int i = name.length - 1;
        for(CalabashBoy c:CBs){
            assertEquals(name[i--],c.getName());
        }
    }

    @Test
    public void testDivideByGender(){
        MyCollection<CalabashBoy> CBmales = CBs.divideByGender(Gender.MALE);
        for(CalabashBoy c:CBmales){
            assertEquals(Gender.MALE, c.getGender());
        }

        MyCollection<CalabashBoy> CBfemales = CBs.divideByGender(Gender.FEMALE);
        for(CalabashBoy c:CBfemales){
            assertEquals(Gender.FEMALE, c.getGender());
        }
    }
}
