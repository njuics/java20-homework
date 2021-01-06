package creature;

import java.util.*;

public class CreatureDescendingComparator <T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T c2, T c1) {
        return c1.getName().compareTo(c2.getName());
    }
}

