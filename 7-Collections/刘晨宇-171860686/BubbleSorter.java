import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 实现了冒泡排序的排序器，基于List, Iterator和Comparator接口
 */
public class BubbleSorter implements Sorter {
    Comparator<CalabashBrother> comparator;

    BubbleSorter(Comparator<CalabashBrother> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(List<CalabashBrother> list) {
        if(list.size() <= 1) {
            return;
        }
        for(int i = 0; i < list.size() - 1; i++) {
            Iterator<CalabashBrother> curIt = list.listIterator();
            Iterator<CalabashBrother> nextIt = list.listIterator(1);
            for(int j = 0; j < list.size() - i - 1; j++) {
                CalabashBrother curBrother = curIt.next();
                CalabashBrother nextBrother = nextIt.next();
                if(comparator.compare(curBrother, nextBrother) > 0) {
                    curBrother.swap(list, nextBrother);
                }
            }
        }
    }
}
