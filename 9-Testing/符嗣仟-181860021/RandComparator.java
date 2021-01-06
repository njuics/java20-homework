import java.util.Comparator;
import java.util.Random;

public class RandComparator <T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        Random random = new Random();
        return random.nextInt();
    }
}