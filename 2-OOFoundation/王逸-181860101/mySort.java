package com.company;
import java.io.*;
import java.util.*;

public class mySort {
    Huluwa myBoy[];
    grandFather yeye;
    public void tellMe(){
        myBoy = new Huluwa[7];
        String name[] = new String[]{"老大","老三","老六","老五","老二","老七","老四"};
        int staus[] = new int[]{1,7,6,3,4,2,5};
        for(int i=0;i<7;i++) {
            Huluwa tmp= new Huluwa();
            tmp.setHuluwa(name[i],staus[i],i);
            myBoy[i] = tmp;
        }
    }
    public void sortByHuluwa(){
        for(int i=0;i<myBoy.length;i++){
            Huluwa tmp = new Huluwa();
            tmp = myBoy[i];
            tmp.findMyPos(myBoy);
            myBoy[i] = tmp;
        }
    }
    public static void main(String arg[]) {
        mySort test = new mySort();
        test.tellMe();
        test.sortByHuluwa();
        System.out.println("葫芦娃自己排队(升序)：");
        for(int i=0;i<test.myBoy.length;i++){
            System.out.print(i+1);
            System.out.print(":");
            System.out.print(test.myBoy[i].name);
            System.out.println(test.myBoy[i].status);
        }
        test.yeye = new grandFather();
        test.yeye.sort(test.myBoy);
        System.out.println("爷爷让葫芦娃排队（降序）：");
        for(int i=0;i<test.myBoy.length;i++){
            System.out.print(i+1);
            System.out.print(":");
            System.out.print(test.myBoy[i].name);
            System.out.println(test.myBoy[i].status);
        }
    }
}
