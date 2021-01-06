public class ArraySort {
    // Sort input array with selection sort algorithm.
    public static void sort(final int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int minIndex = i;
            for (int j = i; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            final int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] testArray = { 1, 4, 2, 8, 5, 7, 6, 3, 9, 0 };
        ArraySort.sort(testArray);
        for (final int i : testArray) {
            System.out.print(i + " ");
        }
        System.out.print('\n');
    }
}
