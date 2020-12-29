import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Stopwatch;
public class Main {
    public static void main(String[] args){
        Stopwatch stopwatch = Stopwatch.createStarted();
        Grandpa grandpa = new Grandpa();
        ArrayList<Calabash>calabashArrayList = grandpa.getCalabash();

        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa.random());
        System.out.println(calabashArrayList);
        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa);
        System.out.println(calabashArrayList);
        new Sort<Calabash, Comparator<Calabash>>().sort(calabashArrayList,grandpa.reversed());
        System.out.println(calabashArrayList);

        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(nanos);
    }
}
