import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class GodQueue<T extends Creature> implements Iterable<T> {

    private List<T> array;

    public GodQueue(List<T> list) {
        this.array = list;
    }

    public boolean remove(T o) {
        return this.array.remove(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new GodQueue.Itr();
    }

    public class Itr implements Iterator<T> {

        private int cur;

        public Itr() {
            this.cur = -1;
        }

        @Override
        public boolean hasNext() {
            return this.cur < GodQueue.this.array.size() - 1;
        }

        @Override
        public T next() {
            return GodQueue.this.array.get(++this.cur);
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (var t : array) builder.append(t.toString() + "\n");
        return builder.toString();
    }
}
