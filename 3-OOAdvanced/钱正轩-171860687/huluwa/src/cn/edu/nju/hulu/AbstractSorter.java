package cn.edu.nju.hulu;

public abstract class AbstractSorter {
    private String name;
    private String complexity;

    /**
     * 构造器
     *
     * @param name       排序算法名
     * @param complexity 排序算法复杂度
     */
    public AbstractSorter(String name, String complexity) {
        this.name = name;
        this.complexity = complexity;
    }

    /**
     * 排序算法，需要派生类重写
     *
     * @param list 待排序的对象
     */
    public abstract void sort(Sortable list);

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Algorithm name: " + name + ", Complexity: " + complexity;
    }
}
