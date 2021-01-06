package algorithm;

import enums.Order;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
    public static <T extends Comparable> void insertionSort(ArrayList<T> array){
        for (int i = 1; i < array.size(); i++) {
            T currElement = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j).compareTo(currElement) > 0) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, currElement);
        }
    }

    public static <T extends Comparable, E extends Comparator> void insertionSort(ArrayList<T> array, E instructor){
        for (int i = 1; i < array.size(); i++) {
            T currElement = array.get(i);
            int j = i - 1;
            while (j >= 0 && instructor.compare(array.get(j), currElement) > 0) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, currElement);
        }
    }
}
