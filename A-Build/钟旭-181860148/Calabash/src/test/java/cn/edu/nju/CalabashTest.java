package cn.edu.nju;

import org.junit.Test;

import cn.edu.nju.Creature.Gender;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;

public class CalabashTest {
    
    static QLine<Creature> bros;

    @BeforeClass
    public static void init(){
        bros=new QLine<>();
        for(int i=0;i<20;i++){
            CalabashBoy a=new CalabashBoy();
            bros.add(a);
        }
        
    }
    @Before
    public void Testnumber(){
        assertEquals(bros.number, bros.brothers.size());
    }
    @Test
    public void TestInstance(){
        for(Creature c:bros){
            assertTrue(c instanceof CalabashBoy);
        }
    }

    @Test
    public void testSort(){
        bros.Sort();
        for(int i=1;i<bros.number;i++){
            assertTrue(bros.brothers.get(i-1).compareTo(bros.brothers.get(i))<=0);
        }
    }
    @Test
    public void testReverse(){
        bros.Reverse();
        for(int i=1;i<bros.number;i++){
            assertTrue((bros.brothers.get(i-1).compareTo(bros.brothers.get(i)))>=0);
        }
    }

    @Test
    public void testDivided(){
        bros.DividedByGender();
        for(int i=0;i<bros.maleline.size();i++){
            assertTrue(bros.maleline.get(i).gender==Gender.MALE);
        }
        for(int i=0;i<bros.femaleline.size();i++){
            assertTrue(bros.femaleline.get(i).gender==Gender.FEMALE);
        }
    }
}
