import java.util.Arrays;
public class Sort {
    public static void main(String[] args) {
        int numbers[] = new int[]{2, 4, 5, 7, 1, 9, 3, 10, 6, 8};
        System.out.print("Unsorted Array:");
        System.out.print(Arrays.toString(numbers) + "\n");
        // Bubble sort
        for(int i = 0; i < numbers.length - 1; ++i)
            for(int j = 0; j < numbers.length - i - 1; ++j)
                if(numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
        System.out.print("Sorted Array:");
        System.out.print(Arrays.toString(numbers) + "\n");
    }
}