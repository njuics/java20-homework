import java.util.Scanner;

public class numSort {
    public static void main(String[] args) throws Exception {
        // get len
        System.out.print("请输入数组长度:");
        Scanner reader = new Scanner(System.in);
        int len = reader.nextInt();
        int[] arr = new int[len];
        // 生成随机数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);// 范围0~100
            // System.out.println(arr[i]);
        }
        // 冒泡排序，由大到小
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int buf = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buf;
                }
            }
        }
        // print answer
        System.out.print("排序结果为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        reader.close();
    }
}
