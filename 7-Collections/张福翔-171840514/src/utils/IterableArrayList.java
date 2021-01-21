package utils;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableArrayList<E extends Comparable<E>> extends ArrayList<E> implements Iterable<E> {
    public class InOrderIterator implements Iterator<E> {
        private int ptr = 0;
        @Override
        public boolean hasNext() {
            return ptr != size();
        }
        @Override
        public E next() {
            return get(ptr++);
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new InOrderIterator();
    }
}
