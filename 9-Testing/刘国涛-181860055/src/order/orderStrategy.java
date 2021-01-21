package order;

import java.util.Comparator;

public abstract class orderStrategy<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public abstract int compare(T a,T b);
}

