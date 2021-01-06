import java.util.Arrays;
import java.util.Random;

public class SimpleSort {
    private static int arraySize = 10;
    public static void main(String[] args) {
        Random r = new Random();
        if (args.length > 0) {
            arraySize = Integer.parseInt(args[0]);
        }
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++){
            array[i] = r.nextInt(100);
        }
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}