package cn.edu.nju.hulusort;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;

import com.google.common.collect.Lists;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class HuluwaList<T extends Huluwa> implements Iterable<T> {

    List<T> list = Lists.newArrayList();

    public HuluwaList() {
    }

    public void add(T e) {
        list.add(e);
    }

    public int size() {
        return list.size();
    }

    public T get(int index) {
        return list.get(index);
    }

    public void shuffle() {
        Collections.shuffle(list);
        System.out.println("打乱顺序：");
    }

    public void swap(int i, int j) {
        if (i != j)
            Collections.swap(list, i, j);
    }

    public void sortByName() {
        // 用Ordering实现排序；
        Ordering<T> ordering = Ordering.natural().nullsFirst().onResultOf(
            new Function<T,String>() {
                public String apply(T t) {
                    return t.getName();
                }
            });
        
        list=ordering.sortedCopy(list);
    }

    public void printList() {
        for (Huluwa huluwa : list) {
            huluwa.sayName();
            System.out.print(" ");
        }
        System.out.println("");
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}