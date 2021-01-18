/*
 * @Author: zb-nju
 * @Date: 2020-11-15 10:20:56
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-23 16:08:44
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import com.nju.cs.wzb.hwA.CalabashBoy;
import com.nju.cs.wzb.hwA.CalabashBoyFactory;
import com.nju.cs.wzb.hwA.MyCollection;
import com.nju.cs.wzb.hwA.Gender;

import com.google.common.collect.Ordering;

public class testCalabashBoy {
    MyCollection<CalabashBoy> CBs;
    Ordering<CalabashBoy> ordering = new Ordering<CalabashBoy>(){
        public int compare(CalabashBoy left,CalabashBoy right){
            return left.compareTo(right);
        }
    };

    public testCalabashBoy(){
        CBs = new MyCollection<CalabashBoy>(new CalabashBoyFactory());
        for(int i = 0; i < 10; i++){
            CBs.insert(new CalabashBoy());
        }
    }

    @Before
    public void shuffle(){
        CBs.sortRandComparator();
    }

    @Test
    public void testSortAscComparator() throws Exception{
        CBs.sortAscComparator();
        assertTrue(ordering.isOrdered(CBs));
    }

    @Test
    public void testSortAscComparable() throws Exception{
        CBs.sortAscComparable();
        assertTrue(ordering.isOrdered(CBs));
    }

    @Test
    public void testSortDescComparator() throws Exception{
        CBs.sortDescComparator();
        assertTrue(ordering.reverse().isOrdered(CBs));
    }

    @Test
    public void testDescAscComparable() throws Exception{
        CBs.sortDescComparable();
        assertTrue(ordering.reverse().isOrdered(CBs));
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
