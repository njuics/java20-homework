public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivot = arr[left];
        int low = left, high = right;
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            while (low < high && arr[low] <= pivot) {
                low++;
            }

            if (low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        arr[left] = arr[low];
        arr[low] = pivot;
        quickSort(arr, left, high - 1);
        quickSort(arr, high + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = { 20, 11, 3, 6, 8, 2, 101, 45, 99, 23, 17 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
