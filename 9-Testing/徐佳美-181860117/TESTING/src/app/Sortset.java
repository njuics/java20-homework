package app;

import java.util.Comparator;

abstract class Sortset<T extends Comparable<? super T>> implements Comparator<T> {
    @Override
    public abstract int compare(T a,T b);
}