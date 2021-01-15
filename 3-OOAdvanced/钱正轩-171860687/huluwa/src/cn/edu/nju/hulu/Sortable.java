package cn.edu.nju.hulu;

public interface Sortable {

    /**
     * 返回待排序元素数量
     * @return 元素数量
     */
    public int size();

    /**
     * 比较两个元素
     * @param a 下标a
     * @param b 下标b
     * @return 返回 a 处元素和 b 处元素的大小关系，小于为负数，等于为 0，大于为正数
     */
    public int compare(int a, int b);

    /**
     * 交换两个元素
     * @param a 下标a
     * @param b 下标b
     */
    public void swap(int a, int b);
}
