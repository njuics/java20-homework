import java.util.Comparator;

public class HuluNameComparator implements Comparator<Hulu> {
    @Override
    public int compare(Hulu arg0, Hulu arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
}