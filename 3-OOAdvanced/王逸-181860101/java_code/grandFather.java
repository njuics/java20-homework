package com.company;

//默认每个葫芦娃的位置即在数组内的位置
public class grandFather extends Huluwa{
    public void sort(Huluwa a[]){
        for(int i = 0;i<a.length-1;i++){
            for(int j = i + 1;j<a.length;j++){
                if(a[i].getStatus() < a[j].getStatus())
                    a[i].exchangeAll(a[j]);
            }
        }
    }
}