package huluwa.tools;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import huluwa.characters.Swappable;

/**
 * 实现了冒泡排序的排序器，基于List, Iterator和Comparator接口
 */
public class BubbleSorter implements Sorter {
    @Override
    public <T extends Swappable<T>> void sort(List<T> list, Comparator<? super T> comparator) {
        if(list.size() <= 1) {
            return;
        }
        for(int i = 0; i < list.size() - 1; i++) {
            ListIterator<T> curIt = list.listIterator();
            ListIterator<T> nextIt = list.listIterator(1);
            for(int j = 0; j < list.size() - i - 1; j++) {
                T curElem = curIt.next();
                T nextElem = nextIt.next();
                if(comparator.compare(curElem, nextElem) > 0) {
                    int curIndex = curIt.nextIndex() - 1;
                    int nextIndex = nextIt.nextIndex() - 1;
                    curElem.swap(list, nextElem, curIndex, nextIndex);
                }
            }
        }
    }
}
