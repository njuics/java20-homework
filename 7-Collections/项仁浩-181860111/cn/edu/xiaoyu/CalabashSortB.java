package cn.edu.xiaoyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CalabashSortB {
    public static void ascendingOrder(ArrayList<Calabash> c){
        Collections.sort(c);
    }
    public static void descendingOrder(ArrayList<Calabash> c){
        Collections.sort(c,Collections.reverseOrder());
    }
    public static void outOfOrder(ArrayList<Calabash> c){
        Random rand = new Random();
        Collections.shuffle(c,rand);
    }
}
