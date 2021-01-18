import java.util.*;

public class TDescendingComparator <T extends Creature> implements Comparator<T>{
    @Override
    public int compare(T h1, T h2) {
        if(h1.get_name().compareTo(h2.get_name())>0) 
            return -1;
        else if(h1.get_name().compareTo(h2.get_name())>0)
            return 0;
        else
            return 1;
    }
}