package pers.lcy.hulu;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 排序程序的入口，演示基于编排或协同思想进行的排序的整个过程，同时也包含了
 * 对静态变量和静态块的使用
 */
public class Sort {
    private static int nCalabashBrother;
    private static String[] brotherNames;
    private static ArrayList<CalabashBrother> queue;
    
    // 问题情景的初始化在静态块中进行，有七个葫芦娃随机排列成的一条队列
    static {
        nCalabashBrother = 7;
        brotherNames = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        queue = new ArrayList<>();
        for(int i = 0; i < nCalabashBrother; i++) {
            queue.add(new CalabashBrother(brotherNames[i], i));
        }
        Collections.shuffle(queue);
    }

    public static void main(String[] args) {
        // 第一个参数表示使用编排还是协同形式进行排序，第二个参数表示使用冒泡排序还是快速排序
        if(args[0].equals("Orchestration")) {
            Grandpa grandpa = new Grandpa();
            if(args[1].equals("BubbleSort")) {
                grandpa.bubbleSort(queue);
            } else if(args[1].equals("QuickSort")) {
                grandpa.quickSort(queue);
            }
        } else if(args[0].equals("Choreography")) {
            Sorter<CalabashBrother> cSorter = new ChoreographySorter<>();
            if(args[1].equals("BubbleSort")) {
                cSorter.bubbleSort(queue);
            } else if(args[1].equals("QuickSort")) {
                cSorter.quickSort(queue);
            }
        }
        // 排序完成后进行报数
        for(int i = 0; i < nCalabashBrother; i++) {
            queue.get(i).numberOff();
        }
    }
}
