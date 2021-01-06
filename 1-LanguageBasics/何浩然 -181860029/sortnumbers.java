
public class sortnumbers {
    public static void main( String[] args) {
        final int array[] = { 23, 4, 29, 52, 14 };
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        int max=array[0];
        int maxpos=0;
        int j=array.length;
        while(j>1){
            for(int i=0;i<j;i++){
            if(array[i]>max){
                max=array[i];
                maxpos=i;
             }
        }
        j--;
        array[maxpos]=array[j];
        array[j]=max;
        max=array[0];
        maxpos=0;
        }
        System.out.println("\n"+"排序后数组：");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

}