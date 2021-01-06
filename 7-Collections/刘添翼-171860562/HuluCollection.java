import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HuluCollection implements Iterable<Hulu> {
    private List<Hulu> list = new LinkedList<Hulu>();

    @Override
    public ListIterator<Hulu> iterator() {
        return list.listIterator();
    }

    @Override
    public String toString() {
        return "HuluCollection [list=" + list + "]";
    }

    public void sort(Comparator<Hulu> comparator) {
        list.sort(comparator);
    }

    public void printContent() {
        for (Hulu hulu : list) {
            System.out.println(hulu);
        }
    }
}
