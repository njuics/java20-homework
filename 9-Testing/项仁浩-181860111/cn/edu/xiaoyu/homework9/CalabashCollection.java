package cn.edu.xiaoyu.homework9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class CalabashCollection <T extends Calabash>{
    ArrayList<T> list = new ArrayList<>();
    CalabashSortA a = new CalabashSortA();
    CalabashSortB b = new CalabashSortB();
    Random rand = new Random();

    void add(T x){
        list.add(x);
    }

    void ascendingOrder(){
        if(rand.nextBoolean())
            a.ascendingOrder(list);
        else
            b.ascendingOrder(list);
    }
    void descendingOrder(){
        if(rand.nextBoolean())
            a.descendingOrder(list);
        else
            b.descendingOrder(list);
    }

    void outOfOrder(){
        if(rand.nextBoolean())
            a.outOfOrder(list);
        else
            b.outOfOrder(list);
    }

    void printList(){
        for(T x:list)
            System.out.println(x.name+" "+x.gender+":"+x.act());
    }

    Iterator<T> CalabashIterator(){
        return list.iterator();
    }

    ArrayList<String> getName(){
        ArrayList<String> res = new ArrayList<>();
        for(Calabash calabash:list){
            res.add(calabash.name);
        }
        return res;
    }

    ArrayList<Gender> getGender(){
        ArrayList<Gender> res = new ArrayList<>();
        for(Calabash calabash:list){
            res.add(calabash.gender);
        }
        return res;
    }
}
