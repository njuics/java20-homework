package java作业9_Testing;

import java.util.*;
public  class Sorting <T extends Creature> implements Comparator<Creature>{
    List<T> p=new ArrayList<>();
    public Sorting(){}
    public int compare(Creature t1, Creature t2){
        String name1=t1.name;
        String name2=t2.name;
        return name1.compareTo(name2);

    }
    public void add_some(T e){
            p.add(e);
    }
    public void print(){
        for(T i:p){
            System.out.print(i.name+' ');
        }
        System.out.println();
    }
}
