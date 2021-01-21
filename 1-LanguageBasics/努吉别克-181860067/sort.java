import java.util.Scanner;

public class sort {

    public sort()
    {

    }
    public void sort_func(int []array)
    {
        for(int i=0;i<10;i++)
        {
            for(int j=i+1;j<10;j++)
            {
                if(array[j]<array[i])
                {
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
        for(int i=0;i<10;i++)
        {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args)
    {
        Scanner scan =new Scanner(System.in);
        int size=20;
        int []myarray=new int[size];
        System.out.println("请输入10个整数");
        for(int i=0;i<10;i++)
        {
            myarray[i]=scan.nextInt();
            System.out.println(myarray[i]);
        }
        sort sort_array=new sort();
        System.out.println("排序结果为:");
        sort_array.sort_func(myarray);
    }
}
