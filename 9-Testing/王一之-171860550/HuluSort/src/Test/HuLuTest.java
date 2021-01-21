package Test;

import characters.*;
import org.junit.*;

import java.util.Random;

import static org.junit.Assert.*;

public class HuLuTest {
    HuLuWa h1;
    HuLuWa h2;

    @Before
    public void setUp() {
        h1 = new HuLuWa(1, HuLuWa.HuLuColor.RED);
        h2 = new HuLuWa(2, HuLuWa.HuLuColor.ORANGE);
    }

    //HuLuWa方法测试
    @Test
    public void testGetRandomString() {
        for (int i = 0; i < 20; ++i)
            assertEquals(i, HuLuWa.getRandomString(i).length());
    }

    @Test
    public void testCompareTo() {

        Monster m = new Monster();
        assertEquals(0, h1.compareTo(m));//是否正确识别不是葫芦娃的比较
        assertEquals(h1.compareTo(h2), -h2.compareTo(h1));
    }

    //Tile方法测试
    @Test
    public void testSwap() {
        Tile t1 = new Tile(h1);
        Tile t2 = new Tile(h2);
        Tile t3 = new Tile();
        Tile t4 = new Tile();

        assertEquals(h1, t1.getMember());//两个非空交换
        assertEquals(h2, t2.getMember());
        Tile.swap(t1, t2);
        assertEquals(h1, t2.getMember());
        assertEquals(h2, t1.getMember());

        assertTrue(t4.isEmpty());//空交换
        assertNull(t3.getMember());
        Tile.swap(t3, t4);
        assertTrue(t3.isEmpty());
        assertNull(t4.getMember());

        Tile.swap(t2, t3);//空与非空
        assertEquals(h1, t3.getMember());
        assertTrue(t2.isEmpty());
        assertNull(t2.getMember());

    }

    @Test
    public void testLeave() {
        Tile t1 = new Tile(h1);
        assertEquals(h1, t1.leave());
        assertTrue(t1.isEmpty());
    }

    @Test
    public void testEnter() {
        Tile t1 = new Tile();
        assertTrue(t1.enter(h1));
        assertEquals(h1, t1.getMember());
        assertFalse(t1.enter(h2));
    }

    //Ground方法测试
    @Test
    public void testDivideByGender() {
        Ground ground = new Ground(2);//2列

        HuLuWa[] hulu = new HuLuWa[100];
        for(int i=0;i<100;++i){
            hulu[i]=new HuLuWa(i);
        }
        ground.init(0,hulu);
        ground.divideByGender(0);
        for (Tile t : ground.getColumn(0))
            assertEquals(HuLuWa.Gender.MALE, ((HuLuWa) t.getMember()).gender);
        for (Tile t : ground.getColumn(1))
            assertEquals(HuLuWa.Gender.FEMALE, ((HuLuWa) t.getMember()).gender);
    }

    @Test(timeout = 200)
    public void testSort() {
        Ground ground = new Ground(2);//2列
        HuLuWa[] hulu = new HuLuWa[100000];
        for(int i=0;i<100000;++i){
            hulu[i]=new HuLuWa(i);
        }
        ground.init(0,hulu);
        ground.sort(0,1);
    }


}

