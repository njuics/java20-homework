import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * 实现了快速排序的排序器
 */
public class QuickSorter implements Sorter {
    Comparator<CalabashBrother> comparator;

    QuickSorter(Comparator<CalabashBrother> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(List<CalabashBrother> list) {
        CalabashBrother base = list.listIterator().next();
        ListIterator<CalabashBrother> leftIt = list.listIterator();
        ListIterator<CalabashBrother> rightIt = list.listIterator(list.size());
        while(leftIt.nextIndex() < rightIt.previousIndex()) {
            while(leftIt.nextIndex() < rightIt.previousIndex()) {
                CalabashBrother rightBrother = rightIt.previous();
                if(comparator.compare(base, rightBrother) >= 0) {
                    base.swap(list, rightBrother);
                    rightIt.next();
                    break;
                }
            }
            while(leftIt.nextIndex() < rightIt.previousIndex()) {
                CalabashBrother leftBrother = leftIt.next();
                if(comparator.compare(base, leftBrother) < 0) {
                    base.swap(list, leftBrother);
                    leftIt.previous();
                    break;
                }
            }
        }
        if(leftIt.nextIndex() - 1 > 0) {
            sort(list.subList(0, leftIt.nextIndex()));
        }
        if(list.size() - leftIt.nextIndex() - 2 > 0) {
            sort(list.subList(leftIt.nextIndex() + 1, list.size()));
        }
    }
}
