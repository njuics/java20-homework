package JUnitTest.utils;

import JUnitTest.characters.Human;

import java.util.List;

public interface HumanController<T extends Human>{

    void add(T t);

    void addAll(List<T> t);

    void remove(T t);

    void sort(boolean reverse);

    void clear();

    void printAll();

}
