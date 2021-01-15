package algorithm;

import java.util.Comparator;

public class Sort {
    public static <T extends Comparable> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T currElement = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(currElement) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currElement;
        }
    }

    public static <T extends Comparable, E extends Comparator> void orchestration(T[] array, E instructor) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (instructor.compare(array[i], array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
        return;
    }

    public static <T extends Comparable> void choreography(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
        return;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tempElement = array[j];
        array[j] = array[i];
        array[i] = tempElement;
    }
}
