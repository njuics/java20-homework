package com.company;
import java.io.*;
import java.util.*;



public class mySort {
    HuluwaSort myBoy[];
    grandFather yeye;
    mySort(){
        myBoy = new HuluwaSort[7];
        String name[] = new String[]{"老大","老三","老六","老五","老二","老七","老四"};
        int staus[] = new int[]{1,7,6,3,4,2,5};
        for(int i=0;i<7;i++) {
            HuluwaSort tmp = new HuluwaSort(name[i],staus[i],i);
            //tmp.setHuluwa(name[i],staus[i],i);
            myBoy[i] = tmp;
        }
    }
    public static void main(String arg[]) {
        mySort test = new mySort();
        HuluwaSort a = new HuluwaSort();
        a.sortByHuluwa(test.myBoy);
        //a.sortByHuluwa(test.myBoy);
        System.out.println("葫芦娃自己排队(升序)：");
        for(int i=0;i<test.myBoy.length;i++)
            System.out.println(i+1 + ":" + test.myBoy[i].getName() +test.myBoy[i].getStatus());
        test.yeye = new grandFather();
        test.yeye.sort(test.myBoy);
        System.out.println("爷爷让葫芦娃排队（降序）：");
        for(int i=0;i<test.myBoy.length;i++)
            System.out.println(i+1 + ":" + test.myBoy[i].getName() +test.myBoy[i].getStatus());
    }
}
