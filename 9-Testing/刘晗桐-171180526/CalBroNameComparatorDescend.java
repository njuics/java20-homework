package Testing;

import java.util.Comparator;

public class CalBroNameComparatorDescend implements Comparator<CalBro> {
    @Override
    public int compare(CalBro firstBro, CalBro secondBro) {
		return -(firstBro.getName().compareTo(secondBro.getName()));	
    }
}
