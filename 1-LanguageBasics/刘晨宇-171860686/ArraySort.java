import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        // 初始化一个包含10个无序整型数的数组
        int[] integerArray = {26, 29, 75, 49, 97, 77, 33, 38, 80, 6};
        // 调用Arrays.sort()方法对数组进行升序排序
        Arrays.sort(integerArray);
        // 调用Arrays.toString()方法将数组转化为字符串表示后输出
        System.out.println(Arrays.toString(integerArray));
    }
}
