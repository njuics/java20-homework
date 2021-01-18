package com.HuluwaGame;

import java.util.Vector;

public class Main {

    private static Vector<Position<Creature>> chessboard = new Vector<Position<Creature>>(10);

    public static void init() {
        GrandPa grandpa = new GrandPa();
        HuLuWa first_huluwa = new HuLuWa("大娃",1);
        HuLuWa second_huluwa = new HuLuWa("二娃",2);
        HuLuWa third_huluwa = new HuLuWa("三娃",3);
        HuLuWa fourth_huluwa = new HuLuWa("四娃",4);
        HuLuWa fifth_huluwa = new HuLuWa("五娃",5);
        HuLuWa sixth_huluwa = new HuLuWa("六娃",6);
        HuLuWa seven_huluwa = new HuLuWa("七娃",7);
        chessboard.add(new Position<Creature>(0, 0, grandpa));
        chessboard.add(new Position<Creature>(0,1,first_huluwa));
        chessboard.add(new Position<Creature>(0,2,second_huluwa));
        chessboard.add(new Position<Creature>(0,3,third_huluwa));
        chessboard.add(new Position<Creature>(0,4,fourth_huluwa));
        chessboard.add(new Position<Creature>(0,5,fifth_huluwa));
        chessboard.add(new Position<Creature>(0,6,sixth_huluwa));
        chessboard.add(new Position<Creature>(0,7,seven_huluwa));
    }

    static void print() {
        String output = "";
        for(int i=0;i<chessboard.size();i++){
            output += chessboard.get(i).get_creature().get_name();
            if(i != chessboard.size()-1) {
                output += " ";
            }
        }
        System.out.println(output);
    }
}

