package Package.MyComparator;
import Package.JavaCreature.Creature;

import java.util.Comparator;

public class OrderCreatureComparator <T extends Creature> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
