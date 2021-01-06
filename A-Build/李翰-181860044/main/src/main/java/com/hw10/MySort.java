package com.hw10;

import java.util.*;
import com.google.common.collect.Ordering;

public class MySort{
    MySort(){
    }

    public <T extends Creature> void printInfo(List<T> list){
        for(int i=0; i<list.size(); ++i){
            System.out.println(list.get(i).getName());
        } 
        System.out.println();
    }

    public <T extends Creature> void outOfOrder(List<T> list){
        Collections.shuffle(list);
        System.out.println("---OutOfOrder Result:");
        printInfo(list);
    }

    public <T extends Creature> void positiveOrder(List<T> list){
        Ordering<T> ordering = new Ordering<T>(){
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            };
        };
        List<T> tmp=ordering.sortedCopy(list);
        list.clear();
        list.addAll(tmp);
        System.out.println("---PositiveOrder Result:");
        printInfo(list);
    }

    public <T extends Creature> void negativeOrder(List<T> list){
        Ordering<T> ordering = new Ordering<T>(){
            public int compare(T t1, T t2) {
                return t1.compareTo(t2);
            };
        }.reverse();
        List<T> tmp=ordering.sortedCopy(list);
        list.clear();
        list.addAll(tmp);
        System.out.println("---PositiveOrder Result:");
        printInfo(list);
    }

    public <T extends Creature> void genderSort(List<T> list, boolean flag){   // flag: 0 for positive, 1 for negative
        List<T> male= new ArrayList<>();
        List<T> female = new ArrayList<>();
        for(int i=0;i<list.size();++i){
            if(list.get(i).getGender()==true){
                male.add(list.get(i));
            }
            else{
                female.add(list.get(i));
            }
        }
        System.out.println("---DividedByGender Result:");
        if(flag == false){
            System.out.println("---->male:");
            positiveOrder(male);
            System.out.println("---->female:");
            positiveOrder(female);
        }
        else{
            System.out.println("---->male:");
            negativeOrder(male);
            System.out.println("---->female:");
            negativeOrder(female);
        }
        list.clear();
        list.addAll(male);
        list.addAll(female);
    }

}
