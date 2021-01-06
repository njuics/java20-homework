import java.util.Arrays;

public class SortIntArray {
    public static void main(String[] args) {
        int[] a = { 5, 3, 4, 1, 2 };
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}