import java.util.Comparator;
import java.util.Random;

public class CalabashComparator implements Comparator<Calabash> {
    @Override
    public int compare(Calabash o1, Calabash o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Comparator<Calabash> reversed() {
        return new Comparator<Calabash>() {
            @Override
            public int compare(Calabash o1, Calabash o2) {
                return o2.compareTo(o1);
            }
        };
    }

    public Comparator<Calabash> random(){
        return new Comparator<Calabash>() {
            @Override
            public int compare(Calabash o1, Calabash o2) {
                return new Random().nextInt() - new Random().nextInt();
            }
        };
    }
}
