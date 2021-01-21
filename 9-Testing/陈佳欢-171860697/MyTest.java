import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//主要测试自己写的排序方法
public class MyTest {
    private static Vector<Position<Creature>> chessboard1 = new Vector<Position<Creature>>(10);
    private static Vector<Position<Creature>> chessboard2 = new Vector<Position<Creature>>(10);

    //测试前初始化两个chessboard
    @BeforeClass
    public static void init() {
        GrandPa grandpa = new GrandPa();
        One_Huluwa one = new One_Huluwa();
        Two_Huluwa two = new Two_Huluwa();
        Three_Huluwa three = new Three_Huluwa();
        Four_Huluwa four = new Four_Huluwa();
        Five_Huluwa five = new Five_Huluwa();
        Six_Huluwa six = new Six_Huluwa();
        Seven_Huluwa seven = new Seven_Huluwa();
        chessboard1.add(new Position<Creature>(0, 0, grandpa));
        chessboard1.add(new Position<Creature>(0, 1, one));
        chessboard1.add(new Position<Creature>(0, 2, two));
        chessboard1.add(new Position<Creature>(0, 3, three));
        chessboard1.add(new Position<Creature>(0, 4, four));
        chessboard1.add(new Position<Creature>(0, 5, five));
        chessboard1.add(new Position<Creature>(0, 6, six));
        chessboard1.add(new Position<Creature>(0, 7, seven));
        chessboard2.add(new Position<Creature>(0, 0, grandpa));
        chessboard2.add(new Position<Creature>(0, 1, one));
        chessboard2.add(new Position<Creature>(0, 2, two));
        chessboard2.add(new Position<Creature>(0, 3, three));
        chessboard2.add(new Position<Creature>(0, 4, four));
        chessboard2.add(new Position<Creature>(0, 5, five));
        chessboard2.add(new Position<Creature>(0, 6, six));
        chessboard2.add(new Position<Creature>(0, 7, seven));
    }

    //测试两个排序方法，之前都把chessboard1打乱
    @Before
    public void shuffle(){
        Collections.shuffle(chessboard1);
    }

    //测试orchestration方法
    @Test
    public void testorchestration() throws Exception {
        MySort sort = new MySort();
        sort.orchestration(chessboard1);
        assertEquals(chessboard2, chessboard1);
    }

    //测试choreography方法
    @Test
    public void testchoreography() throws Exception {
        MySort sort = new MySort();
        sort.choreography(chessboard1);
        assertEquals(chessboard2, chessboard1);
    }
}