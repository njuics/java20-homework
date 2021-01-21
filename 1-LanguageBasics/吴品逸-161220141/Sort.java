package hw1;

public class Sort {
    public static void main(String []args){
        int N = 10;
        int array[] = new int[N];
        System.out.print("original array:");
        for(int i = 0;i < N;i++){
            array[i] = (int)(Math.random()*100);
            System.out.printf("%d%c",array[i],' ');
        }
        System.out.print('\n');
        for(int i = 0;i < (array.length);i++){
            for(int j = 0;j < array.length - 1 - i;j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.print("sorted array:");
        for(int i = 0;i < N;i++){
            System.out.printf("%d%c",array[i],' ');
        }

    }
}
