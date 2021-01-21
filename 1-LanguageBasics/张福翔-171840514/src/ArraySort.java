public class ArraySort {
    static int parition(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[i];
        while (i < j) {
            while ((i < j) && (arr[j] >= pivot))
                j--;
            if (i < j)
                arr[i] = arr[j];
            while ((i < j) && (arr[i] <= pivot))
                i++;
            if (i < j)
                arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }
    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = parition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }
    }
    static public void main(String[] args) {
        // randomly sample 20 integers in range [0, 100)
        int[] arr = new int[20];
        System.out.println("Randomly generate 20 numbers from 0 to 100...");
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.printf("%d ", arr[i]);
        }
        quickSort(arr, 0, 20-1);
        System.out.println("\nResult of quickSort is ");
        for (int i = 0; i < 20; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
