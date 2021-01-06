package hello;
import java.util.Scanner;

public class hello {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input the number of integers: ");
        int m = input.nextInt();
        int []a = new int[m];
        System.out.print("Input the numbers: ");
        for(int i=0; i<m; ++i){
            a[i] = input.nextInt();
        }
        input.close();

        for (int i=0; i < m-1; ++i)
            for (int j=0; j < m-i-1; ++j)
            {
                if (a[j] < a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        System.out.print("After sorted: ");
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
