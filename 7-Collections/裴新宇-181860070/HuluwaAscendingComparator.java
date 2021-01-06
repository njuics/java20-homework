import java.util.*;

public class HuluwaAscendingComparator implements Comparator<Huluwa>{
    @Override
    public int compare(Huluwa h1, Huluwa h2) {
        if(h1.get_name().compareTo(h2.get_name())>0) 
            return 1;
        else if(h1.get_name().compareTo(h2.get_name())>0)
            return 0;
        else
            return -1;
    }
}