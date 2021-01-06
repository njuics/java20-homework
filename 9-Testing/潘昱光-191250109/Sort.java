import java.util.ArrayList;
import java.util.Comparator;
public class Sort {
    public static ArrayList<Huluwa> sort(ArrayList<Huluwa> Huluwas){
        Huluwas.sort(new Comparator<Huluwa>(){
            public int compare(Huluwa o1, Huluwa o2) {
                return o1.compareTo(o2);
            }
        });
        return Huluwas;
    }
}
