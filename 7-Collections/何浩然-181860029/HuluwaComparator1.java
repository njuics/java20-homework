
import java.util.Comparator;
public class HuluwaComparator1 implements Comparator<Huluwa>{//实现Comparator接口
    public int compare(Huluwa h1, Huluwa h2){
        String name1=h1.name;
        String name2=h2.name;
        return -name1.compareTo(name2);

    }
}