package com.company;

public class Main {

    public static void main(String[] args) {
	    int []a = {6, 1, 9, 8, 2, 3, 5, 4, 7};
	    for(int i = 0; i < a.length-1; ++i){
	        for(int j = 0; j < a.length-i-1; ++j){
	            if(a[j]>a[j+1]){
	                int tmp = a[j];
	                a[j] = a[j+1];
	                a[j+1] = tmp;
                }
            }
        }
	    for(int i = 0; i < a.length;++i){
	        System.out.print(a[i]);
	        System.out.print(' ');
        }
    }
}