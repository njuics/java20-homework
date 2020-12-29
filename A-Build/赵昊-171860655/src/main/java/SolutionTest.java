import character.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
public class SolutionTest {
    static ArrayList<CalabashBrother> brothersArray = new ArrayList<>();
    static GrandFather grandFather;
    @Before
    public void beforeTest(){
        System.out.println("开始测试");
    }
    @After
    public void afterTest(){
        System.out.println("结束测试");
    }
    @Test
    public void testGrandFather(){
        CalabashBrother t1 = new CalabashBrother(1,"abc",1);
        CalabashBrother t2 = new CalabashBrother(2,"gsdg",1);
        CalabashBrother t3 = new CalabashBrother(3,"tyer",1);
        CalabashBrother t4 = new CalabashBrother(4,"ncgg",1);
        CalabashBrother t5 = new CalabashBrother(5,"qrwer",1);
        CalabashBrother t6 = new CalabashBrother(6,"sdggs",1);
        CalabashBrother t7 = new CalabashBrother(7,"afegr",1);
        brothersArray.add(t1);
        brothersArray.add(t2);
        brothersArray.add(t3);
        brothersArray.add(t4);
        brothersArray.add(t5);
        brothersArray.add(t6);
        brothersArray.add(t7);

        grandFather=new GrandFather();
        grandFather.SortBrothers(brothersArray);

        assertEquals(t1,brothersArray.get(0));
        assertEquals(t2,brothersArray.get(2));
        assertEquals(t3,brothersArray.get(6));
        assertEquals(t4,brothersArray.get(3));
        assertEquals(t5,brothersArray.get(4));
        assertEquals(t6,brothersArray.get(5));
        assertEquals(t7,brothersArray.get(1));

    }
}
