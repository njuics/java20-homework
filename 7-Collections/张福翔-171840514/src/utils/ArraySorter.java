package utils;

import java.util.Arrays;

public class ArraySorter {
    // NOTE: you can add your own sort algorithm here
    // we only provide quickSort, mergeSort and bubbleSort here
    static public  <E extends Sortable<E>> void sortByChoreography(E[]arr) {
        E[] tmpArray = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i].moveTo(arr, i);
            tmpArray[pos] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmpArray[i];
        }
    }

    public <E extends Comparable<E>> void quickSort(E[]arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }
    private <E extends Comparable<E>> void quickSortHelper(E[]arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSortHelper(arr, left, mid-1);
            quickSortHelper(arr, mid+1, right);
        }
    }
    private <E extends Comparable<E>> int partition(E[]arr, int left, int right) {
        int i = left, j = right;
        E pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j].compareTo(pivot) >= 0) j--;
            if (i < j) arr[i] = arr[j];
            while (i < j && arr[i].compareTo(pivot) <= 0) i++;
            if (i < j) arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }

    public <E extends Comparable<E>> void mergeSort(E[]arr) {
        E[] tmpArray = Arrays.copyOf(arr, arr.length);
        mergeSortHelper(arr, tmpArray, 0, arr.length-1);
    }
    private <E extends Comparable<E>> void mergeSortHelper(E[]arr, E[]tmpArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, tmpArray, left, mid);
            mergeSortHelper(arr, tmpArray, mid+1, right);
            merge(arr, tmpArray, left, mid, right);
        }
    }
    private <E extends Comparable<E>> void merge(E[]arr, E[]tmpArray, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                tmpArray[k++] = arr[i++];
            }
            else {
                tmpArray[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmpArray[k++] = arr[i++];
        }
        while (j <= mid) {
            tmpArray[k++] = arr[j++];
        }
        for (int t = left; t <= right; t++) {
            arr[t] = tmpArray[t];
        }
    }

    public <E extends Comparable<E>> void bubbleSort(E[]arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    E tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}
