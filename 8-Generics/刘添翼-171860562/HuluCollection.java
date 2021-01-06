import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HuluCollection<T extends Hulu> implements Iterable<T> {
    private List<T> list = new LinkedList<T>();

    @Override
    public ListIterator<T> iterator() {
        return list.listIterator();
    }

    @Override
    public String toString() {
        return "HuluCollection [list=" + list + "]";
    }

    public void sort(Comparator<T> comparator) {
        list.sort(comparator);
    }

    public void printContent() {
        for (T hulu : list) {
            System.out.println(hulu);
        }
    }
}
