import java.util.*;

public class IterableQueue<T extends Creature> {
    private List<T> c;

    public IterableQueue(List<T> c){
        this.c = c;

    }

    public List<T> getC() {
        return c;
    }

    public Iterable<T> inorder(){
        return c;
    }

    public Iterable<T> reversed() {
        return () -> new Iterator<T>() {
            int current = c.size() - 1;
            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return c.get(current--);
            }
        };
    }

    public Iterable<T> randomized() {
        List<T> shuffled = new ArrayList<>(c);
        Collections.shuffle(shuffled,new Random(42));
        return shuffled;
    }


}
