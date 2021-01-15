import java.util.List;

/**
 * 排序器，实现该接口的类需要实现对葫芦娃列表进行排序的方法，注意它是Orchestration方法的排序器，
 * 因为Choreography方法不需要额外的排序器
 */
public interface Sorter {
    public void sort(List<CalabashBrother> list);
}
