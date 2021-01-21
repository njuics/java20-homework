import java.util.Arrays;
import java.util.Random;

public class test
{
    public static void main(String args[])
    {
        final int N=10;
        int data[]=new int[N];
        Random r=new Random(1);
        System.out.println("The array is shown below:");
        for (int i=0;i<data.length;i++)
        {
            data[i] = r.nextInt(100);
            System.out.print(data[i]+" ");
        }
        System.out.println();

        Arrays.sort(data);
        /*
        for (int i=0;i<data.length-1;i++)
            for (int j=i+1;j<data.length;j++)
                if (data[i]>data[j])
                {
                    int tmp=data[i];
                    data[i]=data[j];
                    data[j]=tmp;
                }
        */
        System.out.println("The sorted array is shown below:");
        for (int x :data)
            System.out.print(x+" ");

    }
}
