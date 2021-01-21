import java.util.ArrayList;
import java.util.Collections;

/**
 * Orchestration类是程序的入口，它演示基于编排思想进行的排序的整个过程
 */
class Orchestration {
    public static void main(String[] args) {
        // 常量nCalabashBrothers，表示问题中葫芦娃的个数
        final int nCalabashBrothers = 7;

        // 构建出问题的初始情景，有一个老爷爷
        Grandpa grandpa = new Grandpa();

        // 还有七个随机排列的葫芦兄弟
        ArrayList<Integer> initQueueOrder = new ArrayList<>();
        for(int i = 0; i < nCalabashBrothers; i++) {
            initQueueOrder.add(i);
        }
        Collections.shuffle(initQueueOrder);
        Queue queue = new Queue(initQueueOrder);

        // 老爷爷指挥葫芦娃们进行排序
        if(args[0].equals("BubbleSort")) {
            grandpa.commandBubbleSort(queue);
        } else if(args[0].equals("QuickSort")) {
            grandpa.commandQuickSort(queue, 0, queue.length() - 1);
        }

        // 排序完后，葫芦娃们从第一个到最后一个报数
        for(int i = 0; i < nCalabashBrothers; i++) {
            queue.getBrother(i).numberOff();
        }
    }
}

/**
 * Grandpa类是对问题中“老爷爷”的抽象，它的行为是比较两个葫芦娃的大小，
 * 以及指挥队列中的葫芦娃进行排序
 */
class Grandpa {
    // 老爷爷可以对两个葫芦娃按排行进行比较，如果brother1排行靠后则返回值＞0
    int compare(CalabashBrother brother1, CalabashBrother brother2) {
        return brother1.getBirthOrder() - brother2.getBirthOrder();
    }

    // 老爷爷可以指挥给定队列中的葫芦娃按照排行从大到小进行排序(冒泡排序)
    void commandBubbleSort(Queue givenQueue) {
        for(int i = 0; i < givenQueue.length() - 1; i++) {
            for(int j = 0; j < givenQueue.length() - i - 1; j++) {
                // 观察队伍中两个相邻的葫芦娃，对他们进行比较
                CalabashBrother prevBrother = givenQueue.getBrother(j);
                CalabashBrother nextBrother = givenQueue.getBrother(j + 1);
                // 如果需要交换位置，则让他们移动到对方的位置
                if(compare(prevBrother, nextBrother) > 0) {
                    prevBrother.moveTo(givenQueue, j + 1);
                    nextBrother.moveTo(givenQueue, j);
                }
            }
        }
    }

    // 老爷爷可以指挥给定队列中的葫芦娃按照排行从大到小进行排序(快速排序)
    void commandQuickSort(Queue givenQueue, int left, int right) {
        if(left >= right) {
            return;
        }
        CalabashBrother base = givenQueue.getBrother(left);
        int i = left, j = right;
        while(i < j) {
            CalabashBrother current = givenQueue.getBrother(j);
            while(i < j && compare(base, current) <= 0) {
                j--;
                current = givenQueue.getBrother(j);
            }
            if(i < j) {
                current.moveTo(givenQueue, i);
                i++;
            }

            current = givenQueue.getBrother(i);
            while(i < j && compare(base, current) >= 0) {
                i++;
                current = givenQueue.getBrother(i);
            }
            if(i < j) {
                current.moveTo(givenQueue, j);
                j--;
            }
        }
        base.moveTo(givenQueue, i);
        commandQuickSort(givenQueue, left, i - 1);
        commandQuickSort(givenQueue, i + 1, right);
    }
}

/**
 * CalabashBrother类是对问题中“葫芦娃”的抽象，它具有名字、排行两个属性，
 * 行为是给出自己的排行，报数，以及在队列中进行移动
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

    // 葫芦娃给出自己的排行
    public int getBirthOrder() {
        return birthOrder;
    }
    
    // 葫芦娃进行报数
    public void numberOff() {
        System.out.println(names[birthOrder]);
    }

    // 葫芦娃在给定的队列中移动到某个位置
    public void moveTo(Queue givenQueue, int position) {
        givenQueue.setBrother(this, position);
    }
}

/**
 * Queue类是对葫芦娃们组成的队列的抽象，它记录队列当前的状态，即队列中的
 * 各个位置与葫芦娃的对应关系；它的行为是给出队列的状态，以及改变队列的状态
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
}