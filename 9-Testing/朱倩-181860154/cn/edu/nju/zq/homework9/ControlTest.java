package cn.edu.nju.zq.homework9;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ControlTest{

    ArrayList<HuLuWa> queue;

    @Before
    public void setUp() {
        //random order
        queue=new ArrayList<>();
        for(int i=0;i<7;i++){
            queue.add(HuLuWa.getNewHuluwa());
        }
    }

    @Test
    public void testAscSort() throws Exception{
        Control.ascSort(queue);
        for(int i=0;i<6;i++){
            assertTrue(queue.get(i).compareTo(queue.get(i+1))<=0);
        }
    }

    @Test
    public void testDescSort() throws Exception{
        Control.descSort(queue);
        for(int i=0;i<6;i++){
            assertTrue(queue.get(i).compareTo(queue.get(i+1))>=0);
        }
    }
}