import java.util.ArrayList;
import java.util.Collections;

/**
 * Choreography类是程序的入口，它演示基于协同思想进行的排序的整个过程
 */
public class Choreography {
    public static void main(String[] args) {
        // 常量nCalabashBrothers，表示问题中葫芦娃的个数
        final int nCalabashBrothers = 7;

        // 构建出问题的初始情景，有七个随机排列的葫芦兄弟
        ArrayList<Integer> initQueueOrder = new ArrayList<>();
        for(int i = 0; i < nCalabashBrothers; i++) {
            initQueueOrder.add(i);
        }
        Collections.shuffle(initQueueOrder);
        Queue queue = new Queue(initQueueOrder);

        /* 向队首的葫芦娃传递消息(调用方法)，让它开始协同排序
           如果每个葫芦娃都是一个进程，可以不需要这个初始消息，
           而是由各个葫芦娃检查自己在队伍中的位置，队首(或队尾)的葫芦娃自动开始排序 */
        if(args[0].equals("BubbleSort")) {
            CalabashBrother frontBrother = queue.getBrother(0);
            frontBrother.bubbleSort(queue, queue.length() - 1);
        } else if(args[0].equals("QuickSort")) {
            CalabashBrother backBrother = queue.getBrother(queue.length() - 1);
            CalabashBrother base = queue.getBrother(0);
            backBrother.quickSort(queue, 0, queue.length() - 1, base, false, 0);
        }
        
        // 排序完成后，葫芦娃们从第一个到最后一个报数
        for(int i = 0; i < nCalabashBrothers; i++) {
            queue.getBrother(i).numberOff();
        }
    }
}

/**
 * CalabashBrother类是对问题中“葫芦娃”的抽象，它具有名字、排行两个属性，
 * 行为是与另一个葫芦娃进行比较，报数，在队列中进行移动，以及最重要的，在队列中与
 * 其他葫芦娃协同完成排序
 */
class CalabashBrother {
    // 常量names是葫芦娃类的属性，它记录各个排行的葫芦娃的名称
    private static final String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

    // 属性birthOrder是一个葫芦娃的属性，表示这个葫芦娃的排行
    private int birthOrder;

    // 构造方法，需要给出葫芦娃的排行
    CalabashBrother(int birthOrder) {
        this.birthOrder = birthOrder;
    }

    // 与另一个葫芦娃进行比较，如果自己的排行靠后则返回值＞0
    private int compareTo(CalabashBrother other) {
        return this.birthOrder - other.birthOrder;
    }

    // 葫芦娃在给定的队列中移动到某个位置
    private void moveTo(Queue givenQueue, int position) {
        givenQueue.setBrother(this, position);
    }

    /**
     * 在给定的队列中与其他葫芦娃协同，完成冒泡排序
     * @param givenQueue 给定的队列
     * @param lastPosition 在这趟排序中可以移动到的最后一个位置
     */
    public void bubbleSort(Queue givenQueue, int lastPosition) {
        // 获取自己的位置
        int thisPosition = givenQueue.getPosition(this);

        // 如果自己不在可移动到的最后一个位置，并且自己比下一个位置的葫芦娃排行靠后，则和它交换位置
        CalabashBrother nextBrother = null;
        while(thisPosition < lastPosition && 
                compareTo(nextBrother = givenQueue.getBrother(thisPosition + 1)) > 0) {
            moveTo(givenQueue, thisPosition + 1);
            nextBrother.moveTo(givenQueue, thisPosition);
            thisPosition++;
        }

        // 如果循环结束后仍不在可移动到的最后一个位置，则向下一个葫芦娃传递消息，让它接替排序过程
        // 如果已经在最后一个位置，则当前趟结束，向队首的葫芦娃传递消息，让它开始下一趟排序
        if(thisPosition < lastPosition) {
            nextBrother.bubbleSort(givenQueue, lastPosition);
        } else if(lastPosition > 0) {
            givenQueue.getBrother(0).bubbleSort(givenQueue, lastPosition - 1);
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
    public void quickSort(Queue givenQueue, int left, int right, 
            CalabashBrother base, boolean forward, int vacancy) {
        // 获取自己的位置
        int thisPosition = givenQueue.getPosition(this);
        
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
                CalabashBrother leftSuccessor = givenQueue.getBrother(vacancy - 1);
                CalabashBrother leftBase = givenQueue.getBrother(0);
                leftSuccessor.quickSort(givenQueue, left, vacancy - 1, leftBase, false, 0);
            }
            if(vacancy + 1 < right) {
                CalabashBrother rightSuccessor = givenQueue.getBrother(right);
                CalabashBrother rightBase = givenQueue.getBrother(vacancy + 1);
                rightSuccessor.quickSort(givenQueue, vacancy + 1, right, rightBase, false, vacancy + 1);
            }
        } else {
            // 通过与基准葫芦娃进行比较，结合当前排序的进行方向，判断是否交换位置
            // 如果交换位置，则葫芦娃的当前位置成为新的空位置，并且排序算法将从旧的空位置向反方向进行
            // 如果不交换位置，则排序算法顺当前方向进行到下一个葫芦娃
            if(compareTo(base) < 0 ^ forward) {
                moveTo(givenQueue, vacancy);
                CalabashBrother successor = givenQueue.getBrother(vacancy + (forward ? -1 : 1));
                successor.quickSort(givenQueue, left, right, base, !forward, thisPosition);
            } else {
                CalabashBrother successor = givenQueue.getBrother(thisPosition + (forward ? 1 : -1));
                successor.quickSort(givenQueue, left, right, base, forward, vacancy);
            }
        }
    }

    // 葫芦娃进行报数
    public void numberOff() {
        System.out.println(names[birthOrder]);
    }
}

/**
 * Queue是对葫芦娃们组成的队列的抽象，它记录队列当前的状态，即队列中的
 * 各个位置与葫芦娃的对应关系；它的行为是给出队列的状态，改变队列的状态
 */
class Queue {
    // queueInfo属性以有序集合形式记录队列的状态
    private ArrayList<CalabashBrother> queueInfo;

    // 构造方法，需要提供开始时队列中葫芦娃们的排行
    Queue(ArrayList<Integer> birthOrderList) {
        queueInfo = new ArrayList<>();
        for(int birthOrder : birthOrderList) {
            queueInfo.add(new CalabashBrother(birthOrder));
        }
    }

    // 给出队列的长度
    public int length() {
        return queueInfo.size();
    }

    // 给出队列中给定位置上当前的葫芦娃信息
    public CalabashBrother getBrother(int position) {
        return queueInfo.get(position);
    }

    // 队列的给定位置上的葫芦娃变为给定葫芦娃
    public void setBrother(CalabashBrother brother, int position) {
        queueInfo.set(position, brother);
    }

    // 指定某个葫芦娃，给出它在队列中的当前位置
    public int getPosition(CalabashBrother brother) {
        int position = -1;
        for(int i = 0; i < queueInfo.size(); i++) {
            if(queueInfo.get(i) == brother) {
                position = i;
                break;
            }
        }
        return position;
    }
}