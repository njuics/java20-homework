import java.util.Comparator;

public class NewComparator implements Comparator<GourdBaby> {
    public int compare(GourdBaby obj1, GourdBaby obj2) {
        return obj1.getRank() - obj2.getRank();
    }
}
