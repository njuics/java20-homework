package huluwa;
import java.util.ArrayList;
import java.util.Comparator;

import com.google.common.collect.Comparators;
public class Sort {
    public static ArrayList<Huluwa> sort(ArrayList<Huluwa> huluwas){
        huluwas.sort(new Comparator<Huluwa>(){
            public int compare(Huluwa o1, Huluwa o2) {
                return o1.compareTo(o2);
            }
        });
        return huluwas;
    }
    public static Huluwa getMax(ArrayList<Huluwa> huluwas){
        return huluwas.stream().collect(Comparators.greatest(1, new Comparator<Huluwa>(){
            @Override
            public int compare(Huluwa h1,Huluwa h2){
                return h1.compareTo(h2);
            }
        })).get(0);
    }
}
