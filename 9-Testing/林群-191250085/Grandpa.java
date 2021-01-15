import java.util.Comparator;

public class Grandpa implements Comparator<Creature> {
    public int compare(Creature o1, Creature o2){
        return o1.getName().compareTo(o2.getName());
    }

}
