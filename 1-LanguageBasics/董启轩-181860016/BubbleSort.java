public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = { 6, 82, 45, 7, 35, 5532, 2, 46 };
        System.out.println("Before:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        System.out.println("Next:");
        for (int x : arr) {
            System.out.print(x+" ");
        }
        System.out.println();
    }
}