public class Homework1Sort {
    public static void myQuickSort(int[] array, int left, int right) {
        if(left >= right)
            return;

        int i = left, j = right, pivot = array[left], temp = 0;
        while(i < j) {
            while(array[j] >= pivot && i < j)
                j--;
            while(array[i] <= pivot && i < j)
                i++;

            if(i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = pivot;

        myQuickSort(array, left, i-1);
        myQuickSort(array, i+1, right);
    }

    public static void main(String args[]) {
        int[] array = {83, 17, 93, 62, 45, 79, 25, 68, 21, 97, 76, 60, 86, 75, 16, 31, 2, 11, 49, 11, 93, 9, 39, 18, 89};
        myQuickSort(array, 0, array.length-1);
        String output = "";
        for(int n : array) {
            output += n + " ";
        }
        System.out.println(output);
    }
}
