package hulu;
import org.junit.*;
import static org.junit.Assert.*;
import com.google.common.collect.*;
import java.util.*;
public class HuluTest {
    //sortGender=0表示男，1表示女，2表示全性别
    //sortType=0表示正序排列，1表示倒序排列，2表示原样输出
    private static int i=0;
    @Before
    public  void beforeMsg() {
        ++i;
        System.out.println(">>> Starting test "+Integer.toString(i));
    }

    @After
    public  void afterMsg() {
        System.out.println(">>> Finished test "+Integer.toString(i));
    }
    @Test
    public void test1() throws Exception {//可以增强的地方
        /*
        sortedCopy(Iterable) 	判断可迭代对象是否已严格按排序器排序：不允许排序值相等的元素。 	immutableSortedCopy
        以及利用ordering重写HuluCase里的比较器Positive等
        */
        Ordering<Comparable> ordering = Ordering.natural();
        List<String> list=Lists.newArrayList(new HuluCase().run(4,new String[] {"AC","BD","BAD","CA"},
                                                   new int[]{0,0,0,0},0,0).toArray(new String[0])
                                                   );
        assertTrue(ordering.isOrdered(list));
        
    }
    @Test
    public void test2() throws Exception {
        assertArrayEquals(new String[] {"CA","BD","BAD","AC"}, 
                            new HuluCase().run(4,new String[] {"AC","BD","BAD","CA"},
                                                   new int[]{0,0,0,0},2,1).toArray(new String[0]));
        
    }
    @Test
    public void test3() throws Exception {
        assertArrayEquals(new String[] {"BD","BAD"}, 
                            new HuluCase().run(4,new String[] {"AC","BD","BAD","CA"},
                                                   new int[]{0,1,1,0},1,1).toArray(new String[0]));
        
    }
    @Test
    public void test4() throws Exception {
        assertArrayEquals(new String[] {"AC","BD","A","BAD","CA"}, 
                            new HuluCase().run(5,new String[] {"AC","BD","A","BAD","CA"},
                                                   new int[]{0,1,0,1,0},2,2).toArray(new String[0]));
        
    }
    @Test
    public void test5() throws Exception {
        assertArrayEquals(new String[] {"A","AC","CA"}, 
                            new HuluCase().run(5,new String[] {"AC","BD","A","BAD","CA"},
                                                   new int[]{0,1,0,1,0},0,0).toArray(new String[0]));
        
    }
    @Test
    public void test6() throws Exception {
        assertArrayEquals(new String[] {"AC","A","CA"}, 
                            new HuluCase().run(5,new String[] {"AC","BD","A","BAD","CA"},
                                                   new int[]{0,1,0,1,0},0,2).toArray(new String[0]));
        
    }
    @Test
    public void test7() throws Exception {
        Ordering<Comparable> ordering = Ordering.natural();
        List<String> list=Lists.newArrayList(new HuluCase().run(26,new String[] {"D","S","X","P","G","N","O","H","K","T","E","L","M","C","Q","R","B","Z","U","W","I","J","Y","F","A","V"},
                                                   new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},0,0).toArray(new String[0]));
                                    
        ordering.isOrdered(list);
        
    }
    @Test
    public void test8() throws Exception {
        Ordering<Comparable> ordering = Ordering.natural().reverse();
        List<String> list=Lists.newArrayList(new HuluCase().run(26,new String[] {"D","S","X","P","G","N","O","H","K","T","E","L","M","C","Q","R","B","Z","U","W","I","J","Y","F","A","V"},
                                                   new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},0,1).toArray(new String[0]));
                                    
        ordering.isOrdered(list);
        
    }
}