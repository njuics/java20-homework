package pers.lcy.hulu;

import java.util.ArrayList;

/**
 * Sorter类的行为是对给定类型的对象组成的队列进行冒泡排序，以及快速排序，
 * 在没有确定使用编排或是协同形式的排序前不能给出这两个方法的具体实现，故它是虚基类，
 * Sorter类要求给定的类型实现了它自己的Sortable接口
 */
public abstract class Sorter<T extends Sortable<T>> {
    public abstract void bubbleSort(ArrayList<T> givenQueue);
    public abstract void quickSort(ArrayList<T> givenQueue);
}
