import java.util.List;

public class Choreography implements SortStrategy {
    @Override
    public void sort(List<CalabashBrother> queue) {
        queue.sort((b1, b2) -> b1.compareTo(b2));
    }
}
