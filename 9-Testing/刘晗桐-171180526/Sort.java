package Testing;

import java.util.*;

/*
 * Reference [1]: https://www.baeldung.com/java-comparator-comparable
 * Reference [2]: https://www.techiedelight.com/differences-between-iterator-and-iterable-in-java
 * Reference [3]: https://www.javatpoint.com/string-comparison-in-java
 */

public class Sort implements SortModes<CalBro>{
	// using comparable and iterable
	public void SortAscendable(List<CalBro> oneList) {
		List<CalBro> newBros = new ArrayList<CalBro>();
		for(CalBro bro : oneList)
			newBros.add(bro);	
		Collections.sort(newBros);
		Collections.copy(oneList, newBros);
	}
	 
	// using comparator and iterator
	public void SortAscnedator(List<CalBro> oneList) {
		// iterator
		List<CalBro> newBros = new ArrayList<CalBro>();
		Iterator<CalBro> calIterator = oneList.iterator();
		while (calIterator.hasNext()){
			newBros.add(calIterator.next());
		}
		// comparator
		CalBroNameComparator nameComparator = new CalBroNameComparator();
		Collections.sort(newBros, nameComparator);
		Collections.copy(oneList, newBros);
	}
	
	// descend sorting using comparator
	public void SortDescend(List<CalBro> oneList) {
		CalBroNameComparatorDescend nameComparator = new CalBroNameComparatorDescend();
		Collections.sort(oneList, nameComparator);
	}
	
	public void SortDisorder(List<CalBro> oneList) {
		Collections.shuffle(oneList);
	}
}
