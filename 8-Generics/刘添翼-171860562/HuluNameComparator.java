import java.util.Comparator;

public class HuluNameComparator<T extends Hulu> implements Comparator<T> {
    @Override
    public int compare(T arg0, T arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
}