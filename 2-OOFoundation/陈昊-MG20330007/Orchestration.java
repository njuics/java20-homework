import java.util.List;

public class Orchestration implements SortStrategy{
    GrandFather gfather;

    Orchestration(GrandFather gfather) {
        this.gfather = gfather;
    }

    @Override
    public void sort(List<CalabashBrother> queue) {
        gfather.instruct(queue);
    }
}
