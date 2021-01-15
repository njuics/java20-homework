// package java20homework.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GrandQueue<T extends Comparable<T>> implements Iterable<T> {

    private List<T> array;

    public GrandQueue(List<T> list) {
        this.array = list;
    }

    public void setArray(List<T> list) {
        this.array = list;
    }

    public boolean remove(T o) {
        return this.array.remove(o);
    }

    public void shuffle() {
        Collections.shuffle(this.array);
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var t : array)
            builder.append(t.toString() + "\n");
        return builder.toString();
    }

    public class Itr implements Iterator<T> {

        private int cur;

        public Itr() {
            this.cur = -1;
        }

        @Override
        public boolean hasNext() {
            return this.cur < GrandQueue.this.array.size() - 1;
        }

        @Override
        public T next() {
            return GrandQueue.this.array.get(++this.cur);
        }

    }
}
