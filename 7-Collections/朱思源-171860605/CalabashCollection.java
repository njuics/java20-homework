import java.util.*;

public class CalabashCollection {

    private static final int LEN=10;
    private List<Calabash> calabashList;

    CalabashCollection() {
        calabashList=new ArrayList<>();
        for(int i=0;i<LEN;i++) {
            calabashList.add(new Calabash());
        }
    }

    CalabashCollection(int len){
        if(len>0){
            calabashList=new ArrayList<>();
            for(int i=0;i<len;i++) {
                calabashList.add(new Calabash());
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(calabashList);
    }

    public void sortViaComparable(ORDER order) {
        sortViaComparable(order,FLAG.SORT_ALL);
    }

    public void sortViaComparable(ORDER order,FLAG flag) {
        for(Calabash item : calabashList){
            item.setSortOption(order,flag);
        }
        Collections.sort(calabashList);
    }

    public void sortViaComparator(Comparator<Calabash> comparator) {
        calabashList.sort(comparator);
    }

    public Iterable<Calabash> getIterable() {
        return this::getIterator;
    }

    public Iterator<Calabash> getIterator() {
        return new Iterator<Calabash>() {
            private int index=-1;

            @Override
            public boolean hasNext() {
                return index+1<calabashList.size();
            }

            @Override
            public Calabash next() {
                index++;
                return calabashList.get(index);
            }
        };
    }
}
