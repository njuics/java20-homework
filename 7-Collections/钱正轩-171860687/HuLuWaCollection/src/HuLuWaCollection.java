
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class HuLuWaCollection {

    private static final int HULU_NUM = 20;
    private List<HuLuWa> huLuWList;
    private Logger logger = Logger.getLogger("HuLuWaCollection");

    public HuLuWaCollection() {
        huLuWList = new ArrayList<>();
        for (int i = 0; i < HULU_NUM; i++) {
            huLuWList.add(new HuLuWa());
        }
    }

    public void shuffle() {
        logger.info("shuffling...");
        Collections.shuffle(huLuWList);
    }

    public void sortComparable(Order order, boolean sortByGender) {
        logger.info("sort via Comparable");
        huLuWList.forEach(x -> x.setOrder(order, sortByGender));
        Collections.sort(huLuWList);
    }

    public void sortComparable(Order order) {
        sortComparable(order, false);
    }

    public void sortComparator(Comparator<HuLuWa> comparator) {
        logger.info("sort via Comparator");
        Collections.sort(huLuWList, comparator);
    }

    public Iterable<HuLuWa> getIterable() {
        return this::getIterator;
    }

    public Iterator<HuLuWa> getIterator() {
        return new Iterator<HuLuWa>() {
            private int index = -1;

            @Override
            public HuLuWa next() {
                index++;
                if (index >= huLuWList.size()) {
                    throw new NoSuchElementException();
                }
                return huLuWList.get(index);
            }

            @Override
            public boolean hasNext() {
                return index < (huLuWList.size() - 1);
            }
        };
    }

    public Iterable<HuLuWa> getReverseIterable() {
        return this::getReverseIterator;
    }

    public Iterator<HuLuWa> getReverseIterator() {
        return new Iterator<HuLuWa>() {
            private int index = huLuWList.size();

            @Override
            public HuLuWa next() {
                index--;
                if (index < 0) {
                    throw new NoSuchElementException();
                }
                return huLuWList.get(index);
            }

            @Override
            public boolean hasNext() {
                return index >= 0;
            }
        };
    }
}
