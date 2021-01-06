public class QuickSort {
    // function: dispatch the quick sort process
    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }

    // function: do partition in the quick sort process
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    // function: change two elements in the array
    private static void swap(int[] arr, int element1, int element2) {
        int temp = arr[element1];
        arr[element1] = arr[element2];
        arr[element2] = temp;
    }
}
