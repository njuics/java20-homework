package src.testcase;

import org.junit.Test;
import static org.junit.Assert.*;

import src.hulusort.*;

import java.util.ArrayList;
import java.util.Collections;

public class HuluSortTest {
    @Test
    public void testHuluSort() {
        // 引入ArrayList是为了不使用huluwaList.shuffle()方法，只使用被测试的sort方法；
        ArrayList<Huluwa> huluwaList=new ArrayList<>();
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

        HuluwaList<Huluwa> huluwaListExpected=new HuluwaList<>();
        
        for (int i = 0; i < 7; i++) {
            huluwaListExpected.add(huluwaList.get(i));
        }
        // 打乱
        Collections.shuffle(huluwaList);
        
        HuluwaList<Huluwa> huluwaListActual1=new HuluwaList<>();
        HuluwaList<Huluwa> huluwaListActual2=new HuluwaList<>();
        HuluwaList<Huluwa> huluwaListActual3=new HuluwaList<>();
        for (int i = 0; i < 7; i++) {
            huluwaListActual1.add(huluwaList.get(i));
            huluwaListActual2.add(huluwaList.get(i));
            huluwaListActual3.add(huluwaList.get(i));
        }

        // 排序并对比是否一致；

        // 排序1
        SortHuluwaList sortByAlgo=new SortByAlgo(); //算法排序；
        sortByAlgo.sort(huluwaListActual1);
        for (int i = 0; i < 7; i++) {
            assertEquals(huluwaListExpected.get(i), huluwaListActual1.get(i));
        }

        // 排序2
        SortHuluwaList grandpa=new Grandpa(); // Orchestration排序
        grandpa.sort(huluwaListActual2);
        for (int i = 0; i < 7; i++) {
            assertEquals(huluwaListExpected.get(i), huluwaListActual2.get(i));
        }

        // 排序3
        SortHuluwaList sortChoreography=new SortChoreography(); // Choreography排序
        sortChoreography.sort(huluwaListActual3);
        for (int i = 0; i < 7; i++) {
            assertEquals(huluwaListExpected.get(i), huluwaListActual3.get(i));
        }
    }
}