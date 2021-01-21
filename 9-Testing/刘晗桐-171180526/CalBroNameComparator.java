package Testing;

import java.util.Comparator;

public class CalBroNameComparator implements Comparator<Character> {
    public int compare(Character firstBro, Character secondBro) {
		return firstBro.getName().compareTo(secondBro.getName());	
    }
}
