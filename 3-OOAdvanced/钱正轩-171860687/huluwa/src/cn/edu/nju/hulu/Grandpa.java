package cn.edu.nju.hulu;

public class Grandpa {
    private Sortable sortable;
    private AbstractSorter sorter;

    /**
     * 爷爷的构造器
     *
     * @param sorter 排序器
     */
    public Grandpa(AbstractSorter sorter, Sortable sortable) {
        this.sortable = sortable;
        this.sorter = sorter;
    }

    /**
     * 以编排的形式排序，实际上是将排序调用委托给了排序器
     */
    public void sortByOrchestration() {
        System.out.println(sorter);
        sorter.sort(sortable);
    }

    /**
     * @return the sorter
     */
    public AbstractSorter getSorter() {
        return sorter;
    }

    /**
     * @param sorter the sorter to set
     */
    public void setSorter(AbstractSorter sorter) {
        this.sorter = sorter;
    }

    /**
     * @return the sortable
     */
    public Sortable getSortable() {
        return sortable;
    }

    /**
     * @param sortable the sortable to set
     */
    public void setSortable(Sortable sortable) {
        this.sortable = sortable;
    }
}
