import java.util.Iterator;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger("Main");

    public static void printIterable(Iterable<HuLuWa> list) {
        logger.info("print via Iterable");
        for (HuLuWa h : list) {
            System.out.println(h);
        }
    }

    public static void printIterator(Iterator<HuLuWa> it) {
        logger.info("print via Iterator");
        while (it.hasNext()) {
            HuLuWa h = it.next();
            System.out.println(h);
        }
    }

    public static void main(String[] args) {
        HuLuWaCollection huLuWaCollection = new HuLuWaCollection();

        // Print via Iterable and Iterator
        printIterable(huLuWaCollection.getIterable());
        printIterator(huLuWaCollection.getIterator());

        // Sort
        huLuWaCollection.sortComparable(Order.DESC);
        printIterable(huLuWaCollection.getIterable());
        huLuWaCollection.shuffle();

        huLuWaCollection.sortComparable(Order.ASC, true);
        printIterable(huLuWaCollection.getIterable());
        huLuWaCollection.shuffle();

        huLuWaCollection.sortComparator(HuLuWa.getComparator(Order.DESC));
        printIterable(huLuWaCollection.getIterable());
        huLuWaCollection.shuffle();

        huLuWaCollection.sortComparator(HuLuWa.getComparator(Order.ASC, true));
        printIterable(huLuWaCollection.getIterable());
        huLuWaCollection.shuffle();

        huLuWaCollection.sortComparable(Order.RANDOM);
        printIterable(huLuWaCollection.getIterable());
    }
}
