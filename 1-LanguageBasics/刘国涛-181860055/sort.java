import java.util.Scanner;

public class sort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;++i){
            array[i] = input.nextInt();
        }

        arraySort(array);

        for(int a:array){
            System.out.print(a+" ");
        }
        input.close();
    }
    public static void arraySort(int[] array){
        int n = array.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-i-1;++j){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}
/*
input case:
8
21 12 3 45 67 7 9 4
*/
