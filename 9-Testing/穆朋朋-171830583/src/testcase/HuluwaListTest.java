package src.testcase;

import org.junit.Test;
import static org.junit.Assert.*;

import src.hulusort.Huluwa;
import src.hulusort.HuluwaList;

public class HuluwaListTest {
    @Test
    public void testHuluwaList() {
        // 测试HuluwaList的泛型支持：
        // public class HuluwaList<T extends Huluwa>
        // 应该支持Huluwa和其子类；
        HuluwaList<HuluwaCombat> list=new HuluwaList<>();
        HuluwaCombat huluwa=new HuluwaCombat(0, "大娃", 1000, 10);
        list.add(huluwa);
        assertEquals(1, list.size());   // HuluwaList的泛型应该支持Huluwa的子类，断言加入成功；
        
        HuluwaCombat huluwaGet=list.get(0);
        assertEquals(huluwa, huluwaGet);    // 断言取出来的和加入的相同；
    }
}

// 战斗型葫芦娃类；
class HuluwaCombat extends Huluwa{
    int health;
    int damage;
    HuluwaCombat(int c,String n,int h,int d) {
        super(c,n);
        health=h;
        damage=d;
    }
}