public class ArraySort {

    private static void BubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i-1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        /* create an array */
        int[] array = new int[]{53,12,65,3,396};
        /* sort the array */
        BubbleSort(array);

        /* print the array */
        for(int e:array)
            System.out.println(e);
    }
}
