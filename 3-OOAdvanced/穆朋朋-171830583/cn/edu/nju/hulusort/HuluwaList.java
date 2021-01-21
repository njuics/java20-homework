package cn.edu.nju.hulusort;

import java.util.ArrayList;
import java.util.Collections;

public class HuluwaList{

    ArrayList<Huluwa> list=new ArrayList<>();
    
    public HuluwaList() {
        // 创造7个葫芦娃出来；
        for (int i = 0; i < 7; i++) {
            switch(i) {
                case 0: list.add(new Huluwa(i,"老大"));break;
                case 1: list.add(new Huluwa(i,"老二"));break;
                case 2: list.add(new Huluwa(i,"老三"));break;
                case 3: list.add(new Huluwa(i,"老四"));break;
                case 4: list.add(new Huluwa(i,"老五"));break;
                case 5: list.add(new Huluwa(i,"老六"));break;
                case 6: list.add(new Huluwa(i,"老七"));break;
                default: list.add(new Huluwa(i,"老大"));break;
            }
        }
        System.out.println("葫芦娃队列初始化完毕!\n共创建的葫芦娃数量为"+Huluwa.numHuluwa);
        printList();
    }
    public int size() {
        return list.size();
    }
    public Huluwa get(int index) {
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