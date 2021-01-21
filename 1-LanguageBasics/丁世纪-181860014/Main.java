package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] a = new int[x];

        for (int i = 0; i < x; i++) {
            a[i] = sc.nextInt();
        }

        sort(a);

        for (int i = 0; i < x; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    public static void sort(int[] a) {

        int l = a.length;

        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

    }
}
