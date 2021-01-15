import java.util.Comparator;
public class HuluwaAscendingComparator implements Comparator<Huluwa>{
    public int compare(Huluwa o1, Huluwa o2){
        return o1.getName().compareTo(o2.getName());
    }
    public boolean equals(Object obj){
        throw new UnsupportedOperationException();
    }
}