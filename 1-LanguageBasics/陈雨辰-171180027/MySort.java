import java.util.Scanner;

public class MySort {
    public static void main(String[] args) {
        System.out.println("请输入以空格分割的整数:");
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        sc.close();
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int minindex, temp;
        for (int i = 0; i < input.length - 1; i++) {
            minindex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (nums[minindex] > nums[j]) {
                    minindex = j;
                }
            }
            if (minindex != i) {
                temp = nums[i];
                nums[i] = nums[minindex];
                nums[minindex] = temp;
            }
        }
        System.out.println("升序:");
        for (int i = 0; i < input.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n降序:");
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
    }
}