package order;

public class ascStrategy<T extends Comparable<T>> extends orderStrategy<T>{
    @Override
    public int compare(T a,T b){
        return a.compareTo(b);
    }
}
