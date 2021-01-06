import java.util.Comparator;

public class NamedComparator<T extends Named> implements Comparator<T>{
	@Override
	public int compare(T x, T y){
		return x.getName().compareTo(y.getName());
	}
}
