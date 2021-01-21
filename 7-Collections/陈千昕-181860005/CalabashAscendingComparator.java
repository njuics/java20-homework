import java.util.*;

public class CalabashAscendingComparator implements Comparator<Calabash>{
    @Override
    public int compare(Calabash c1, Calabash c2) {
        if(c1.getName().compareTo(c2.getName()) > 0) 
            return 1;
        else if(c1.getName().compareTo(c2.getName()) > 0)
            return 0;
        else
            return -1;
    }
}
