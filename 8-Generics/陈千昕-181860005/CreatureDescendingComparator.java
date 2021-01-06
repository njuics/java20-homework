import java.util.*;

public class CreatureDescendingComparator <T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T c1, T c2) {
        return c2.getName().compareTo(c1.getName());
    }
}

