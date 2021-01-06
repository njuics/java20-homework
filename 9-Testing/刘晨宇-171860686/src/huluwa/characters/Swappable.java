package huluwa.characters;

import java.util.List;

/**
 * Swappable接口，实现该接口的类的对象，可以在一个该类对象的List中与另一个对象交换位置
 * @param <T> 与实现该接口的类相同
 */
public interface Swappable<T extends Swappable<T>> {
    void swap(List<T> list, T o, int thisIndex, int otherIndex);
}
