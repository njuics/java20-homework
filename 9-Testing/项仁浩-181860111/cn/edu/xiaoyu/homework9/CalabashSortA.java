package cn.edu.xiaoyu.homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CalabashSortA <T extends Calabash>{
    public void ascendingOrder(ArrayList<T> c){
        Collections.sort(c,new Ascending());
    }
    public void descendingOrder(ArrayList<T> c){
        Collections.sort(c,new Descending());
    }
    public void outOfOrder(ArrayList<T> c){
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

