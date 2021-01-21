package com;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static ArrayList<Hulu> huluBrothers;
    private static Grandpa grandpa;

    static {
        huluBrothers = new ArrayList<Hulu>();
        for (int i = 0; i < 10; ++i) {//初始化10个葫芦娃
            Hulu huluwa = new Hulu(getRandomName(), getRandomGender());
            huluBrothers.add(huluwa);
        }
        grandpa = new Grandpa();
    }

    public static void main(String[] args) {
        System.out.println("【以orchestration方式排序】");
        sortBy(grandpa);
        System.out.println("【以choreography方式排序】");
        sortBy(huluBrothers.get(0));
    }

    private static void sortBy(Sort<Hulu> s) {//动态绑定到不同的sort函数
        s.shuffle(huluBrothers);
        System.out.print("乱序：\n");
        s.sort(huluBrothers, 0);
        System.out.print("正序：\n");
        s.sort(huluBrothers, 1);
        System.out.print("逆序：\n");
        s.sort(huluBrothers, 2);
    }


    private static String getRandomName() {//随机生成姓名
        int hightPos;
        int lowPos;
        byte[] b = new byte[2];
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();
        String str = null;
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "葫" + str + str;
    }

    private static gender getRandomGender() {//随机生成性别
        Random random = new Random();
        if (random.nextInt() % 2 == 0) return gender.MALE;
        else return gender.FEMALE;
    }
}
