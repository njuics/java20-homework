import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort {
    public void sort(int[] target) {
        this.quickSort(target, 0, target.length - 1);
    }

    public void print(int[] target) {
        for (int i = 0; i < target.length; ++i) {
            if (i == target.length - 1) System.out.println(target[i]);
            else System.out.print(target[i] + " ");
        }
    }

    public int[] arrayIOHelper() {
        String tmp = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            tmp = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tmpArray = tmp.split(" ");
        return Arrays.asList(tmpArray).stream().mapToInt(Integer::parseInt).toArray();
    }

    private void swap(int[] target, int i, int j) {
        int tmp = target[i];
        target[i] = target[j];
        target[j] = tmp;
    }

    private void quickSort(int[] target, int begin, int end) {
        if (begin >= end) return;
        int flag = target[begin];
        int i = begin, j = end;
        while (i < j) {
            while (i < j && target[j] >= flag) --j;
            while (i < j && target[i] <= flag) ++i;
            this.swap(target, i, j);
        }
        this.swap(target, j, begin);
        this.quickSort(target, j + 1, end);
        this.quickSort(target, begin, j - 1);
    }

    public static void main(String[] args) {
        //输入格式：直接读入一行数字 以空格为分隔符
        Sort test = new Sort();
        int[] target = test.arrayIOHelper();
        System.out.println("Original: ");
        test.print(target);
        test.sort(target);
        System.out.println("After sort: ");
        test.print(target);
    }
}
