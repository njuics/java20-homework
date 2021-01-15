import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

public class HuluwaQueue implements Iterable<Huluwa> {

    private ArrayList<Huluwa> queue = new ArrayList<Huluwa>();

    public Iterator<Huluwa> iterator() {
        return new Iterator<Huluwa>() {
            private int index = 0;
            public boolean hasNext() {
                return index < queue.size();
            }
            public Huluwa next() { 
                return queue.get(index++);
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public HuluwaQueue() {

    }

    public int size() {
        return queue.size();
    }

    public void add(Huluwa h) {
        queue.add(h);
    }

    public void add(Collection<Huluwa> c) {
        for (Huluwa h : c)
            queue.add(h);
    }

    public void sortByAsc() {
        Collections.sort(queue);
    }

    public void sortByDesc() {
        Collections.sort(queue);
        Collections.reverse(queue);
    }

    public void shuffle() {
        Collections.shuffle(queue);
    }

    public HuluwaQueue[] divideByGender() {
        HuluwaQueue maleQueue = new HuluwaQueue();
        HuluwaQueue femaleQueue = new HuluwaQueue();
        for (Huluwa h: queue) {
            if (h.getGender() == Gender.male) {
                maleQueue.add(h);
            }
            else {
                femaleQueue.add(h);
            }
        }
        HuluwaQueue[] twoQueue = { maleQueue, femaleQueue };
        return twoQueue;
    }
}