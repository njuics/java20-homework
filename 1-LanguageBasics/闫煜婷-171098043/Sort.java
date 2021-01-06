package homework1;

public class Sort {
    private static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int pivot = start, i = start + 1, j = end, tmp = 0;
        while(i <= j){
            if(arr[i] > arr[pivot]){
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j--;
            }
            else{
                i++;
            }
        }
        tmp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = tmp;
        quickSort(arr, start, j - 1);
        quickSort(arr, j + 1, end);
    }
    public static void main(String[] args){
        int[] arr = {9,1,5,8,-4,65,0,6};
        quickSort(arr, 0, arr.length - 1);
        for(int i: arr){
            System.out.print(i + " ");
        }
        return;
    }
}
