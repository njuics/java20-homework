package pers.lcy.hulu;

import java.util.ArrayList;

/**
 * Sortable接口表示实现该接口的类可使用编排和协同两种方式进行排序，因此它包含以下行为：
 * 移动到队列中的给定位置上，抽象为方法moveTo；能够在队列中协同进行冒泡排序和快速排序，
 * 抽象为方法bubbleSort和quickSort
 */
public interface Sortable<T> {
    void moveTo(ArrayList<T> givenQueue, int position);
    void bubbleSort(ArrayList<T> givenQueue);
    void quickSort(ArrayList<T> givenQueue);
}
