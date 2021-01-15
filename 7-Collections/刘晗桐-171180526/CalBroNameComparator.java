package OOPCollections;

import java.util.Comparator;

public class CalBroNameComparator implements Comparator<CalBro> {
    @Override
    public int compare(CalBro firstBro, CalBro secondBro) {
		return firstBro.getName().compareTo(secondBro.getName());	
    }
}
