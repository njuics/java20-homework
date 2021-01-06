package lixiao.sortalgorithm;

import lixiao.mycomparable.*;

public class SortAlgorithm {
    public static void sort(Object[] objs) {
        for (int i = 0; i < objs.length; i++) {
            for (int j = objs.length-1; j > i; j--) {
                MyComparable a = (MyComparable)objs[j];
                MyComparable b = (MyComparable)objs[i];
                if (a.compareTo(b) < 0) {
                    Object temp = objs[i];
                    objs[i] = objs[j];
                    objs[j] = temp;
                }
            }
        }
    }
}