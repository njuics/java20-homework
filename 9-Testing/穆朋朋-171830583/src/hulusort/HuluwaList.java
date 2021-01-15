package src.hulusort;

import java.util.ArrayList;
import java.util.Collections;

public class HuluwaList<T extends Huluwa> {

    ArrayList<T> list=new ArrayList<>();
    
    public HuluwaList() {}

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
    public void swap(int i,int j) {
        if(i!=j)
            Collections.swap(list,i,j);
    }
    public void printList() {
        for (Huluwa huluwa : list) {
            huluwa.sayName();
            System.out.print(" ");
        }
        System.out.println("");
    }
}