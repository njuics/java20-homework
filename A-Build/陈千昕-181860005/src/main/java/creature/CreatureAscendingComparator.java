package creature;

import java.util.*;

public class CreatureAscendingComparator <T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T c1, T c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
