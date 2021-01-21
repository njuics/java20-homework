import java.util.Scanner;

public class ArraySort {
    public static void main(String[] argv){
        int length=10;
        int[] array=new int[length];
        Scanner reader=new Scanner(System.in);
        for(int i=0;i<length;++i){
            array[i]=reader.nextInt();
        }
        for(int i=0;i<length-1;++i){
            for(int j=0;j<length-1-i;++j){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int i=0;i<length;++i){
            System.out.println(array[i]);
        }
    }
}
