package cn.edu.nju.hulusort;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class HuluSortByNameTest {
    @Test
    public void testHuluSortByName() {
        HuluwaList<Huluwa> huluwaList=new HuluwaList<>();
        for (int i = 0; i < 7; i++) {
            switch(i) {
                case 0: huluwaList.add(new Huluwa(i,"老大"));break;
                case 1: huluwaList.add(new Huluwa(i,"老二"));break;
                case 2: huluwaList.add(new Huluwa(i,"老三"));break;
                case 3: huluwaList.add(new Huluwa(i,"老四"));break;
                case 4: huluwaList.add(new Huluwa(i,"老五"));break;
                case 5: huluwaList.add(new Huluwa(i,"老六"));break;
                case 6: huluwaList.add(new Huluwa(i,"老七"));break;
                default: huluwaList.add(new Huluwa(i,"老大"));break;
            }
        }

        huluwaList.sortByName();
        
        ArrayList<Huluwa> list=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(huluwaList.get(i));
        }
        // 利用Ordering判断list有序；
        Ordering<Huluwa> ordering = Ordering.natural().nullsFirst().onResultOf(
            new Function<Huluwa,String>() {
                public String apply(Huluwa t) {
                    return t.getName();
                }
            });
        assertTrue(ordering.isOrdered(list));
    }
}