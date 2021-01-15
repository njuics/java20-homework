package pers.lcy.hulu;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * OrchestrationSorter是使用编排方式对给定类型的队列进行排序的类，在构建一个该类的
 * 对象时，必须同时提供一个能对将要进行排序的类型进行比较的比较器
 */
public class OrchestrationSorter<T extends Sortable<T>> extends Sorter<T> {
    private Comparator<T> comparator = null;

    public OrchestrationSorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void bubbleSort(ArrayList<T> givenQueue) {
        for(int i = 0; i < givenQueue.size() - 1; i++) {
            for(int j = 0; j < givenQueue.size() - i - 1; j++) {
                T prevElem = givenQueue.get(j);
                T nextElem = givenQueue.get(j + 1);
                if(comparator.compare(prevElem, nextElem) > 0) {
                    prevElem.moveTo(givenQueue, j + 1);
                    nextElem.moveTo(givenQueue, j);
                }
            }
        }
    }

    @Override
    public void quickSort(ArrayList<T> givenQueue) {
        quickSort(givenQueue, 0, givenQueue.size() - 1);
    }

    private void quickSort(ArrayList<T> givenQueue, int left, int right) {
        if(left >= right) {
            return;
        }
        T base = givenQueue.get(left);
        int i = left, j = right;
        while(i < j) {
            T current = givenQueue.get(j);
            while(i < j && comparator.compare(base, current) <= 0) {
                j--;
                current = givenQueue.get(j);
            }
            if(i < j) {
                current.moveTo(givenQueue, i);
                i++;
            }

            current = givenQueue.get(i);
            while(i < j && comparator.compare(base, current) >= 0) {
                i++;
                current = givenQueue.get(i);
            }
            if(i < j) {
                current.moveTo(givenQueue, j);
                j--;
            }
        }
        base.moveTo(givenQueue, i);
        quickSort(givenQueue, left, i - 1);
        quickSort(givenQueue, i + 1, right);
    }
}