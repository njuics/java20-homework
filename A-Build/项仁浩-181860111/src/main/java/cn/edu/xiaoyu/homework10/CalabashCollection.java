package cn.edu.xiaoyu.homework10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import com.google.common.collect.Ordering;

public class CalabashCollection <T extends Calabash>{
    ArrayList<T> list = new ArrayList<T>();
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

    public Iterator<T> ascendingIterator(){
        return Ordering.from(new Ascending()).sortedCopy(list).iterator();
    }
    public Iterator<T> decendingIterator(){
        return Ordering.from(new Descending()).reverse().sortedCopy(list).iterator();
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
        ArrayList<String> res = new ArrayList<String>();
        for(Calabash calabash:list){
            res.add(calabash.name);
        }
        return res;
    }

    ArrayList<Gender> getGender(){
        ArrayList<Gender> res = new ArrayList<Gender>();
        for(Calabash calabash:list){
            res.add(calabash.gender);
        }
        return res;
    }
}
