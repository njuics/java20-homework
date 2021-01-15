package huluwa.tools;

import huluwa.characters.Swappable;

import java.util.Comparator;
import java.util.List;

/**
 * 排序器，实现该接口的类需要实现对给定类的对象的列表进行排序的方法，参数类型T需要
 * 实现Swappable接口
 */
public interface Sorter {
    <T extends Swappable<T>> void sort(List<T> list, Comparator<? super T> comparator);
}