import java.util.Scanner;
//select sort
public class sort {
    public static void sort(int[] a,int n)
    {
        for(int i=0;i<n-1;i++)
        {
            int min=Integer.MAX_VALUE;
            int minloc=-1;
            for(int j=i;j<n;j++)
            {
                if(a[j]<min)
                {
                    min=a[j];
                    minloc=j;
                }
            }
            int tmp=a[i];
            a[i]=a[minloc];
            a[minloc]=tmp;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("输入数组的长度:");
        int n = input.nextInt();
        System.out.println("请输入数组元素:");
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=input.nextInt();
        }
        sort(a,n);
        System.out.print("after sort:");
        for(int i=0;i<n-1;i++)
        {
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println(a[n-1]);
    }

}
