package pers.lcy.hulu;

import java.util.ArrayList;

/**
 * CalabashBrother类是对问题中“葫芦娃”的抽象，它具有名字、排行两个属性，
 * 行为是给出自己的排行，报数，以及在队列中进行移动
 */
public class CalabashBrother implements Sortable<CalabashBrother> {
    // 属性birthOrder表示这个葫芦娃的排行
    private int birthOrder;

    // 属性name表示这个葫芦娃的名字
    private String name;
    
    // 构造方法，需要给出葫芦娃的排行
    public CalabashBrother(String name, int birthOrder) {
        this.name = name;
        this.birthOrder = birthOrder;
    }

    // 葫芦娃给出自己的排行
    public int getBirthOrder() {
        return birthOrder;
    }
    
    // 葫芦娃进行报数
    public void numberOff() {
        System.out.println(name);
    }

    // 与另一个葫芦娃进行比较，如果自己的排行靠后则返回值＞0
    private int compareTo(CalabashBrother other) {
        return this.birthOrder - other.birthOrder;
    }

    // 葫芦娃在给定的队列中移动到某个位置
    public void moveTo(ArrayList<CalabashBrother> givenQueue, int position) {
        givenQueue.set(position, this);
    }

    /**
     * 在给定的队列中与其他葫芦娃协同，完成冒泡排序
     * @param givenQueue 给定的队列
     * @param lastPosition 在这趟排序中可以移动到的最后一个位置
     */
    private void bubbleSort(ArrayList<CalabashBrother> givenQueue, int lastPosition) {
        // 获取自己的位置
        int thisPosition = givenQueue.indexOf(this);

        // 如果自己不在可移动到的最后一个位置，并且自己比下一个位置的葫芦娃排行靠后，则和它交换位置
        CalabashBrother nextBrother = null;
        while(thisPosition < lastPosition && 
                compareTo(nextBrother = givenQueue.get(thisPosition + 1)) > 0) {
            moveTo(givenQueue, thisPosition + 1);
            nextBrother.moveTo(givenQueue, thisPosition);
            thisPosition++;
        }

        // 如果循环结束后仍不在可移动到的最后一个位置，则向下一个葫芦娃传递消息，让它接替排序过程
        // 如果已经在最后一个位置，则当前趟结束，向队首的葫芦娃传递消息，让它开始下一趟排序
        if(thisPosition < lastPosition) {
            nextBrother.bubbleSort(givenQueue, lastPosition);
        } else if(lastPosition > 0) {
            givenQueue.get(0).bubbleSort(givenQueue, lastPosition - 1);
        }
    }

    /**
     * 在给定的队列中与其他葫芦娃协同，完成快速排序
     * @param givenQueue 给定的队列
     * @param left 当前快速排序左边界
     * @param right 当前快速排序右边界
     * @param base 基准葫芦娃
     * @param forward 当前排序进行的方向，为true时代表从左到右
     * @param vacancy 当前队列中的空位置下标
     */
    private void quickSort(ArrayList<CalabashBrother> givenQueue, int left, int right, 
            CalabashBrother base, boolean forward, int vacancy) {
        // 获取自己的位置
        int thisPosition = givenQueue.indexOf(this);
        
        // 如果排序进行到空位置旁边，则分治算法即将把队列分为两部分
        if(thisPosition + (forward ? 1 : -1) == vacancy) {
            // 通过与基准葫芦娃进行比较，结合当前排序的进行方向，判断是否交换位置
            if(compareTo(base) < 0 ^ forward) {
                moveTo(givenQueue, vacancy);
                vacancy = thisPosition;
            }
            base.moveTo(givenQueue, vacancy);

            // 分治的结束条件，即再分后的队列长度是否不大于1
            if(left < vacancy - 1) {
                CalabashBrother leftSuccessor = givenQueue.get(vacancy - 1);
                CalabashBrother leftBase = givenQueue.get(0);
                leftSuccessor.quickSort(givenQueue, left, vacancy - 1, leftBase, false, 0);
            }
            if(vacancy + 1 < right) {
                CalabashBrother rightSuccessor = givenQueue.get(right);
                CalabashBrother rightBase = givenQueue.get(vacancy + 1);
                rightSuccessor.quickSort(givenQueue, vacancy + 1, right, rightBase, false, vacancy + 1);
            }
        } else {
            // 通过与基准葫芦娃进行比较，结合当前排序的进行方向，判断是否交换位置
            // 如果交换位置，则葫芦娃的当前位置成为新的空位置，并且排序算法将从旧的空位置向反方向进行
            // 如果不交换位置，则排序算法顺当前方向进行到下一个葫芦娃
            if(compareTo(base) < 0 ^ forward) {
                moveTo(givenQueue, vacancy);
                CalabashBrother successor = givenQueue.get(vacancy + (forward ? -1 : 1));
                successor.quickSort(givenQueue, left, right, base, !forward, thisPosition);
            } else {
                CalabashBrother successor = givenQueue.get(thisPosition + (forward ? 1 : -1));
                successor.quickSort(givenQueue, left, right, base, forward, vacancy);
            }
        }
    }

    @Override
    public void bubbleSort(ArrayList<CalabashBrother> givenQueue) {
        bubbleSort(givenQueue, givenQueue.size() - 1);
    }

    @Override
    public void quickSort(ArrayList<CalabashBrother> givenQueue) {
        CalabashBrother base = givenQueue.get(0);
        quickSort(givenQueue, 0, givenQueue.size() - 1, base, false, 0);
    }
}