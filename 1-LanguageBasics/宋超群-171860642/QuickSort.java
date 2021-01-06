/*
QucikSort
 */
public class QuickSort{
    public static void main(String args[]){
        int[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};
        quickSort(array, 0, 16);
        for(int i = 0; i<17;i++){
            System.out.println(array[i]);
        }
    }

    public static int getPivot(int nums[], int left, int right){
        int index = left;
        int pivot = nums[left];

        for(int i = left + 1; i <= right; i++){
            if(nums[i] < pivot){
                int tmp = nums[++index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
        }

        nums[left] = nums[index];
        nums[index] = pivot;
        return index;
    }

    public static void quickSort(int nums[], int left, int right){
        if(left < right){
            int pivot = getPivot(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }
}