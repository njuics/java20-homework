import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.Before;

public class HuluwaTest {
    LinkedList<Huluwa> huluwaList = new LinkedList<Huluwa>();

    @Before
    public void initList() {
        // 初始化七个葫芦娃
        huluwaList.add(new Huluwa("dawa",0));
        huluwaList.add(new Huluwa("erwa",1));
        huluwaList.add(new Huluwa("sjwa",0));
        huluwaList.add(new Huluwa("siwa",1));
        huluwaList.add(new Huluwa("wuwa",0));
        huluwaList.add(new Huluwa("lqwa",1));
        huluwaList.add(new Huluwa("qiwa",0));
    }
    @Test
    public void testSort1() {
        // 正序排队
        TAscendingComparator hac = new TAscendingComparator();
        Collections.sort(huluwaList,hac);
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("dawa","erwa", "lqwa","qiwa", "siwa","sjwa","wuwa"));
        int i = 0;
        for(Huluwa it: huluwaList) {
            assertEquals(it.get_name(),list1.get(i));
            i++;
        }
    }
    @Test
    public void testSort2() {
        // 反序排队
        TDescendingComparator hdc = new TDescendingComparator();
        Collections.sort(huluwaList,hdc);
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("wuwa","sjwa", "siwa","qiwa", "lqwa","erwa","dawa"));
        int i = 0;
        for(Huluwa it: huluwaList) {
            assertEquals(it.get_name(),list2.get(i));
            i++;
        }
    }
}