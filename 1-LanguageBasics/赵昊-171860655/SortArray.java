import java.util.Random;
class SortArray {
    public static void main(String[] args){
        int n = 100;    //数组长度
        int[] arr = new int[n];
        Random ran = new Random(n);
        System.out.println("Random Array:");
        for (int i = 0; i < n; i++){
            arr[i]=ran.nextInt(n);
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Sorted Array:");
        mySort(arr,0,n-1);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }
    public static void mySort(int[] arr,int begin,int end) {
        if (begin >= end)
            return;
        int left = begin;
        int right = end;
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp)
                right--;
            if (left < right)
                arr[left] = arr[right];
            while (left < right && arr[left] <= temp)
                left++;
            if (left < right)
                arr[right] = arr[left];
        }
        arr[left] = temp;
        mySort(arr,begin,left-1);
        mySort(arr,left+1,end);
    }

}
