package com.company;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int []arr = {10,8,11,6,9,12,5,7,131};
        bubblesort(arr);
        for(int i:arr){
            System.out.print(i);
            System.out.print(' ');
        }
    }

    public static void bubblesort(int []arr){
        for(int i=0;i<arr.length-1;i++) {
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}






















