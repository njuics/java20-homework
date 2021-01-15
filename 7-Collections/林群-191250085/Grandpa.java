import java.util.Comparator;

public class Grandpa implements Comparator<Calabash> {
    public int compare(Calabash o1, Calabash o2){
        return o1.getName().compareTo(o2.getName());
    }

}
