package lixiao.huluwa;

import lixiao.mycomparable.*;

public class Huluwa implements MyComparable {
    public int order;
    public String name;

    protected Huluwa() {}

    /* public Huluwa(int order, String name) {
        this.order = order;
        this.name = name;
    } */

    public final void reportNumber() {
        System.out.print(name);
    }

    public final void swap(Huluwa other) {
        int temp = order;
        order = other.order;
        other.order = temp;

        String temp2 = name;
        name = other.name;
        other.name = temp2;
    }

    public int compareTo(Object o) {
        Huluwa h = (Huluwa)o;
        return order - h.order;
    }

}