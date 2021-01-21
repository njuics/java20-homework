import java.util.*;

public class CalabashQueue implements Iterable<Calabash> {
    private ArrayList<Calabash> list = new ArrayList<>();

    public void add(Calabash calabash) {
        list.add(calabash);
    }

    public void sort() {
        Collections.sort(list);
    }

    public void sort(Comparator<Calabash> calabashComparator) {
        Collections.sort(list, calabashComparator);
    }

    public void add(Collection<Calabash> calabashCollections, Gender gender) {
        for (Calabash calabash : calabashCollections) {
            if (calabash.getGender() == gender)
                add(calabash);
        }

    }

    @Override
    public Iterator<Calabash> iterator() {
        return new Iterator<Calabash>() {
            private Iterator<Calabash> it = list.listIterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Calabash next() {
                return it.next();
            }
        };
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
