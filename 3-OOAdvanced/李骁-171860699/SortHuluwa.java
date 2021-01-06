package lixiao.sorthuluwa;

import java.util.Random;
import lixiao.grandfather.*;
import lixiao.huluwa.*;

public class SortHuluwa {

    public static void main(String[] args) {
        System.out.println("编舞法排序葫芦娃：");
        SortByOrchestration();

        System.out.print("\n=================\n");

        System.out.println("协同法排序葫芦娃：");
        SortByChoreography();
    }

    //模拟队伍乱序，洗牌算法
    private static void Shuffle(Object[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int rand = random.nextInt(i);
            Object temp = array[i];
            array[i] = array[rand];
            array[rand] = temp;
        }
    }

    //编舞法排序
    private static void SortByOrchestration() {
        //七个葫芦娃的队伍
        Huluwa[] queue = { new Dawa(), new Erwa(), new Sanwa(), new Siwa(), 
                           new Wuwa(), new Liuwa(), new Qiwa()};
        //初始乱序
        Shuffle(queue);
        //乱序队伍报数
        System.out.println("初始乱序队伍报数：");
        for (Huluwa h : queue) {
            h.reportNumber();
            System.out.print(" ");
        }
        //爷爷负责排序
        Grandfather.getInstance().sortHuluwa(queue);
        System.out.println("\n排序后的队伍报数：");
        //有序队伍报数
        for (Huluwa h : queue) {
            h.reportNumber();
            System.out.print(" ");
        }
    }

    //协同法排序
    private static void SortByChoreography() {
        //七个葫芦娃的队伍
        Huluwa[] queue = { new Dawa(), new Erwa(), new Sanwa(), new Siwa(), 
            new Wuwa(), new Liuwa(), new Qiwa()};
        //初始乱序
        Shuffle(queue);
        //乱序队伍报数
        System.out.println("初始乱序队伍报数：");
        for (Huluwa h : queue) {
            h.reportNumber();
            System.out.print(" ");
        }
        //葫芦娃查看自己的位置，如果不同于自己的编号，就和编号位置上的葫芦娃换位
        //并为换位后的葫芦娃重复这个过程
        for (int i = 0; i < queue.length; i++) {
            int j = i;
            while (j != queue[j].order - 1) {
                //System.out.println(queue[j].name + "与" + queue[queue[j].order-1].name + "换位");
                int temp = queue[j].order-1;
                queue[j].swap(queue[queue[j].order-1]);
            }
        }
        //葫芦娃报数
        System.out.println("\n排序后的队伍报数：");
        for (Huluwa h : queue) {
            h.reportNumber();
            System.out.print(" ");
        }
    }
}