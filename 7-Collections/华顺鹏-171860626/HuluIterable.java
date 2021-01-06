import java.util.Iterator;
import java.util.List;

public class HuluIterable implements Iterable<Hulu> {
    private Hulu[] ranks;
    HuluIterable(List<Hulu> huluranks){
        ranks = huluranks.toArray(new Hulu[0]);
    }
    @Override
    public Iterator<Hulu> iterator() {
        return new Iterator<Hulu>(){
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<ranks.length;
            }

            @Override
            public Hulu next() {
                return ranks[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<Hulu> reverseIterator() {
        return new Iterator<Hulu>() {
            private int index = ranks.length - 1;
            @Override
            public boolean hasNext() {
                return index>-1;
            }

            @Override
            public Hulu next() {
                return ranks[index--];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
