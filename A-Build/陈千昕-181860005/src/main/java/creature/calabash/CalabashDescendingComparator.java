package creature.calabash;

import java.util.*;

public class CalabashDescendingComparator implements Comparator<Calabash>{
    @Override
    public int compare(Calabash c2, Calabash c1) {
        int result = c1.getName().compareTo(c2.getName());
        if (result == 0 && c1 instanceof Calabash){
            boolean c1g = ((Calabash)c1).getGender();
            boolean c2g = ((Calabash)c2).getGender();
            if(c1g == c2g) result = 0;
            else result = (!c1g && c2g) ? 1 : -1;
        }
        return result;
    }
}