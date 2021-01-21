package com.HuluwaGame;

import java.util.Collections;
import java.util.Vector;

public class MyTest {
    private static Vector<Position<Creature>> chessboard1 = new Vector<Position<Creature>>(10);
    private static Vector<Position<Creature>> chessboard2 = new Vector<Position<Creature>>(10);

    @BeforeClass
    public static void init() {
        GrandPa grandpa = new GrandPa();
        HuLuWa first_huluwa = new HuLuWa("大娃",1);
        HuLuWa second_huluwa = new HuLuWa("二娃",2);
        HuLuWa third_huluwa = new HuLuWa("三娃",3);
        HuLuWa fourth_huluwa = new HuLuWa("四娃",4);
        HuLuWa fifth_huluwa = new HuLuWa("五娃",5);
        HuLuWa sixth_huluwa = new HuLuWa("六娃",6);
        HuLuWa seven_huluwa = new HuLuWa("七娃",7);
        chessboard1.add(new Position<Creature>(0, 0, grandpa));
        chessboard1.add(new Position<Creature>(0,1,first_huluwa));
        chessboard1.add(new Position<Creature>(0,2,second_huluwa));
        chessboard1.add(new Position<Creature>(0,3,third_huluwa));
        chessboard1.add(new Position<Creature>(0,4,fourth_huluwa));
        chessboard1.add(new Position<Creature>(0,5,fifth_huluwa));
        chessboard1.add(new Position<Creature>(0,6,sixth_huluwa));
        chessboard1.add(new Position<Creature>(0,7,seven_huluwa));
    }

    @Before
    public void shuffle(){
        Collections.shuffle(chessboard1);
    }

    @Test
    public void testorchestration() throws Exception {
        MySort sort = new MySort();
        sort.orchestration(chessboard1);
        assertEquals(chessboard2, chessboard1);
    }

    @Test
    public void testchoreography() throws Exception {
        MySort sort = new MySort();
        sort.choreography(chessboard1);
        assertEquals(chessboard2, chessboard1);
    }
}