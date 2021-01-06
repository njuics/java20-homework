package huluwa.tools;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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
            Iterator<T> curIt = list.listIterator();
            Iterator<T> nextIt = list.listIterator(1);
            for(int j = 0; j < list.size() - i - 1; j++) {
                T curElem = curIt.next();
                T nextElem = nextIt.next();
                if(comparator.compare(curElem, nextElem) > 0) {
                    curElem.swap(list, nextElem);
                }
            }
        }
    }
}
