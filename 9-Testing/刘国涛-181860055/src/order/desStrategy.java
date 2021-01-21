package order;

public class desStrategy<T extends Comparable<T>> extends orderStrategy<T>{
    @Override
    public int compare(T a,T b){
        return b.compareTo(a);
    }
}

