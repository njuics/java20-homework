import cn.edu.nju.wuyuxin.BubbleSort;
import cn.edu.nju.wuyuxin.SelectSort;
import cn.edu.nju.wuyuxin.BoyQueue;

public class Sort {
    public static void main(String[] args) {
        BoyQueue boyQueue = new BoyQueue();
        BubbleSort bubbleSort = new BubbleSort();
        SelectSort selectSort = new SelectSort();
        boyQueue.shuffle();
        boyQueue.show();
        boyQueue.sort(bubbleSort, 1);
        boyQueue.show();
        boyQueue.shuffle();
        boyQueue.sort(selectSort, 1);
        boyQueue.show();
        boyQueue.shuffle();
        boyQueue.sort(selectSort, 2);
        boyQueue.show();
    }
}