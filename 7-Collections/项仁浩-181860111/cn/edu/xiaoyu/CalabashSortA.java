package cn.edu.xiaoyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CalabashSortA {
    public static void ascendingOrder(ArrayList<Calabash> c){
        Collections.sort(c,new Ascending());
    }
    public static void descendingOrder(ArrayList<Calabash> c){
        Collections.sort(c,new Descending());
    }
    public static void outOfOrder(ArrayList<Calabash> c){
        Random rand = new Random();
        Collections.shuffle(c,rand);
    }
}

class Ascending implements Comparator<Calabash>{
    @Override
    public int compare(Calabash o1, Calabash o2) {
        return o1.name.compareTo(o2.name);
    }
}

class  Descending implements  Comparator<Calabash>{
    @Override
    public int compare(Calabash o1, Calabash o2) {
        return o2.name.compareTo(o1.name);
    }
}
