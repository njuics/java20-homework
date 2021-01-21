package pers.lcy.hulu;

import java.util.ArrayList;

/**
 * ChoreographySorter是使用协同方式对给定类型的队列进行排序的类
 */
public class ChoreographySorter<T extends Sortable<T>> extends Sorter<T> {
    @Override
    public void bubbleSort(ArrayList<T> givenQueue) {
        T frontElem = givenQueue.get(0);
        frontElem.bubbleSort(givenQueue);
    }

    @Override
    public void quickSort(ArrayList<T> givenQueue) {
        T backElem = givenQueue.get(givenQueue.size() - 1);
        backElem.quickSort(givenQueue);
    } 
}
