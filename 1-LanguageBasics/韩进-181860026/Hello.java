import java.util.Scanner;

public class Hello
{
    public static void main(String[] args)
    {
        int amount = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要输入的整数个数：");
        amount = in.nextInt();
        int[] myArray = new int[amount];
        System.out.println("请输入要排序的" + amount + "个数：");
        for (int i = 0; i < amount; i++)
        {
            myArray[i] = in.nextInt();
        }
        quickSort(myArray, 0, myArray.length - 1);
        System.out.println("排序结束的数组为：");
        for (int i = 0; i < amount; i++)
        {
            System.out.print(myArray[i] + " ");
        }
    }

    public static void quickSort(int[] myArray, int left, int right)
    {
        if (left >= right)
        {
            return;
        }
        int mid = partion(myArray, left, right);
        quickSort(myArray, left, mid - 1);
        quickSort(myArray, mid + 1, right);
    }

    public static int partion(int[] myArray, int left, int right)
    {
        int pivot = myArray[right];
        int p = left;
        for (int i = left; i <= right - 1; i++)
        {
            if (myArray[i] < pivot)
            {
                int tmp = myArray[p];
                myArray[p] = myArray[i];
                myArray[i] = tmp;
                p++;
            }
        }
        int tmp = myArray[p];
        myArray[p] = myArray[right];
        myArray[right] = tmp;
        return p;
    }
}
