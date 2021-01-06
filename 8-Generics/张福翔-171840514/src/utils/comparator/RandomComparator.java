package utils.comparator;

import java.util.Comparator;

public class RandomComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int rand = (int)(Math.random() * 2);
        return rand > 1 ? 1 : -1;
    }
}
