import java.util.Iterator;
import java.util.List;

public class HuluRanks<T extends Hulu> implements Iterable<T> {
    private int size;
    private Object[] ranks;
    HuluRanks(List<T> ranktmp){
        size = ranktmp.size();
        ranks = new Object[size];
        for (int i = 0; i < size; i++) {
            ranks[i] = ranktmp.get(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<ranks.length;
            }

            @Override
            public T next() {
                return (T)ranks[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
