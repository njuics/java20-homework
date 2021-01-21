import java.util.Arrays;

public class Sort {
    // function: test quick sort
    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85, 1, 57, -2147483648};
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
