package cn.edu.nju.hulu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HuLuBrothers implements Sortable {
    private static final int HULUWA_NUM;
    private static final HuLuWa BOUND;

    static{
        HULUWA_NUM = 7;
        BOUND = new HuLuWa(Order.NULL, "空");
    }

    private static HuLuBrothers huLuBrothers;
    private final List<HuLuWa> hulu;

    /**
     * 单例模式。获取葫芦兄弟实例
     */
    public static HuLuBrothers getHuLuBrothers() {
        if (huLuBrothers == null) {
            huLuBrothers = new HuLuBrothers();
        }
        return huLuBrothers;
    }

    /**
     * 将葫芦兄弟打乱顺序
     */
    public void shuffle() {
        System.out.println("shuffling...");
        Collections.shuffle(hulu);
        setAdj();
    }

    /**
     * 令葫芦兄弟挨个报数
     */
    public void print() {
        System.out.println("==========报数==========");
        HuLuWa head = null;
        for (HuLuWa h : hulu) {
            if (h.getLeft().equals(BOUND)) {
                head = h;
            }
        }
        if (head == null) {
            System.out.println("Error!");
            return;
        }
        while (!head.equals(BOUND)) {
            System.out.println(head);
            head = head.getRight();
        }
    }

    /**
     * 使用协同的方式排序
     */
    public void sortByChoreography() {
        boolean flag = true;
        for (HuLuWa h : hulu) {
            flag = true;
            while (flag) {
                if (!h.getLeft().equals(BOUND) && h.compareTo(h.getLeft()) < 0) {
                    h.swap(h.getLeft());
                } else if (!h.getRight().equals(BOUND) && h.compareTo(h.getRight()) > 0) {
                    h.swap(h.getRight());
                } else {
                    flag = false;
                }
            }
        }
    }

    private HuLuBrothers() {
        hulu = new ArrayList<>(Arrays.asList(new HuLuWa(Order.FIRST, "老大"), new HuLuWa(Order.SECOND, "老二"),
                new HuLuWa(Order.THIRD, "老三"), new HuLuWa(Order.FOURTH, "老四"), new HuLuWa(Order.FIFTH, "老五"),
                new HuLuWa(Order.SIXTH, "老六"), new HuLuWa(Order.SEVENTH, "老七")));
    }

    private void setAdj() {
        for (int i = 0; i < hulu.size(); i++) {
            hulu.get(i).setLeft(i > 0 ? hulu.get(i - 1) : BOUND);
            hulu.get(i).setRight((i < hulu.size() - 1) ? hulu.get(i + 1) : BOUND);
        }
    }

    @Override
    public int compare(int a, int b) {
        return hulu.get(a).compareTo(hulu.get(b));
    }

    @Override
    public int size() {
        return HuLuBrothers.HULUWA_NUM;
    }

    @Override
    public void swap(int a, int b) {
        hulu.get(a).swap(hulu.get(b));
        Collections.swap(hulu, a, b);
    }

}
