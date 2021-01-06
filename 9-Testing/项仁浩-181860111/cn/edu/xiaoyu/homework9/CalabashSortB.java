package cn.edu.xiaoyu.homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CalabashSortB <T extends Calabash>{
    public void ascendingOrder(ArrayList<T> c){
        Collections.sort(c);
    }
    public void descendingOrder(ArrayList<T> c){
        Collections.sort(c,Collections.reverseOrder());
    }
    public void outOfOrder(ArrayList<T> c){
        Random rand = new Random();
        Collections.shuffle(c,rand);
    }
}
