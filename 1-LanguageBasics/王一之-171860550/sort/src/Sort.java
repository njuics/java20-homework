import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args){
        int[] arr = new int[20];
        int[] a =getRandomArr(arr);
        Arrays.sort(a);
        for (int i:a){
            System.out.print(i+" ");
        }

    }
    private static int[] getRandomArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length);
        }
        
        return arr;
    }
}