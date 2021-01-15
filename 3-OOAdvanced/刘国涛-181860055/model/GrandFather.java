package model;

import util.*;


import java.util.Comparator;
public class GrandFather{
 
    public Calabash[] plantCalabash(){
        Calabash[] grandsons = new Calabash[]{
            new Calabash("大娃", 7),
            new Calabash("二娃", 6),
            new Calabash("三娃", 5),
            new Calabash("四娃", 4),
            new Calabash("五娃", 3),
            new Calabash("六娃", 2),
            new Calabash("七娃", 1),
        };
        return grandsons;
    }

    private static Comparator<Calabash> eyes = new Comparator<Calabash>(){
        @Override
        public int compare(Calabash a,Calabash b){
            return b.getAge() - a.getAge();
        }
    };

    private SortStrategy sortStrategy = new BubbleSortStrategy();
    public void sortCalabash(Calabash[] grandsons){
        sortStrategy.sort(grandsons, eyes);
    }


    public void reportInOrder(Calabash[] grandsons){
        for(Calabash a:grandsons){
            a.reportNum();
        }
        System.out.println();
    }
}