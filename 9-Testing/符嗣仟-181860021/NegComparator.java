import java.util.Comparator;

public class NegComparator <T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return b.compareTo(a);
    }
}