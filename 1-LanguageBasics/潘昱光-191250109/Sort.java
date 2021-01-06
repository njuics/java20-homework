public class Sort{
    public static void main(String args[]){
        int[] array={9,8,7,6,5,7,4,3,5,1};
        sort(array,0,9);
        for(int i=0;i<10;++i){
            System.out.println(array[i]);
        }
    }
    public static void sort(int[] a,int b,int e){
        int i=b,j=e;
        if(b>=e)
            return;
        while(i<j){
            while(a[i]<=a[j]&&j>b){
                j--;
            }
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
            while(a[j]>a[i]&&i<e){
                i++;
            }
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        sort(a,b,j);
        sort(a,j+1,e);
    }
}