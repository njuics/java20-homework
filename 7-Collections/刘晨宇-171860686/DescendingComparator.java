import java.util.Comparator;

/**
 * 降序比较器，将字典序中靠前的排在靠后的位置
 */
public class DescendingComparator implements Comparator<CalabashBrother> {
    @Override
    public int compare(CalabashBrother o1, CalabashBrother o2) {
        return -o1.getName().compareTo(o2.getName());
    }
}
