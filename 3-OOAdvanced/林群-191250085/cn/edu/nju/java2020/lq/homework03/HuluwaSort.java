package cn.edu.nju.java2020.lq.homework03;

import java.util.HashSet;
import java.util.Random;

public class HuluwaSort {
    private static int lengthOfQueue;
    private static String[] huluwaName;

    static {
        lengthOfQueue = 7;
        huluwaName = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    }

    //初始化队列，随机站队
    private static void initialize(Huluwa[] queue) {
        Random rand = new Random();
        HashSet<Integer> hashSet = new HashSet();
        int i = 0;

        while (hashSet.size() < 7){
            int tmp = rand.nextInt(7) + 1;
            if (!hashSet.contains(tmp))queue[i++] = new Huluwa(tmp, huluwaName[tmp-1]);
            hashSet.add(tmp);
        }
    }

    public static void main(String[] args) {
        Huluwa[] queue = new Huluwa[lengthOfQueue];
        Grandpa grandPa = new Grandpa();
        SortAlgorithmByPolymorphism mySort1 = new BubbleSortByPolymorphism(); //使用多态的思想
        BubbleSortByInterface mySort2 = new BubbleSortByInterface(); //使用接口的方法

        initialize(queue);
        System.out.println("Orchestration:");
        mySort1.orchestration(queue, grandPa);

        initialize(queue);
        System.out.println("\nChoreography:");
        mySort2.choreography(queue);

    }
}
