package huluwa.tools;

import huluwa.characters.Swappable;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * 实现了快速排序的排序器
 */
public class QuickSorter implements Sorter {
    @Override
    public <T extends Swappable<T>> void sort(List<T> list, Comparator<? super T> comparator) {
        T base = list.listIterator().next();
        ListIterator<T> leftIt = list.listIterator();
        ListIterator<T> rightIt = list.listIterator(list.size());
        while(leftIt.nextIndex() < rightIt.previousIndex()) {
            while(leftIt.nextIndex() < rightIt.previousIndex()) {
                T rightElem = rightIt.previous();
                if(comparator.compare(base, rightElem) >= 0) {
                    base.swap(list, rightElem);
                    rightIt.next();
                    break;
                }
            }
            while(leftIt.nextIndex() < rightIt.previousIndex()) {
                T leftElem = leftIt.next();
                if(comparator.compare(base, leftElem) < 0) {
                    base.swap(list, leftElem);
                    leftIt.previous();
                    break;
                }
            }
        }
        if(leftIt.nextIndex() - 1 > 0) {
            sort(list.subList(0, leftIt.nextIndex()), comparator);
        }
        if(list.size() - leftIt.nextIndex() - 2 > 0) {
            sort(list.subList(leftIt.nextIndex() + 1, list.size()), comparator);
        }
    }

}
