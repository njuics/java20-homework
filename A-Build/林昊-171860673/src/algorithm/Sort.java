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

    public static <T extends Comparable> void quickSort(ArrayList<T> array, int left, int right){
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable> int partition(ArrayList<T> arr, int left, int right) {
        T pivot = arr.get(right);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (arr.get(j).compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static <T extends Comparable> void swap(ArrayList<T> arr, int element1, int element2) {
        T temp = arr.get(element1);
        arr.set(element1, arr.get(element2));
        arr.set(element2, temp);
    }
}
