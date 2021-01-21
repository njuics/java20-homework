import java.util.Scanner;

public class SimpleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int size;

        //数组输入
        System.out.println("请输入数组长度");
        size = scanner.nextInt();
        array = new int[size];
        System.out.println("请输入数组");
        for(int i = 0 ;i<size;i++){
            array[i] = scanner.nextInt();
        }

        //展示数组
        for(int i = 0 ;i<size;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();

        //排序并输出
        //冒泡排序，从小到大
        for(int i = size-1 ;i>0;i--){
            for(int j = 0 ;j<i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //输出
        for(int i = 0 ;i<size;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
}
