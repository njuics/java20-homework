import com.sun.media.sound.SoftTuning;

/**
 * @author q
 * @create 2020-09-08 17:03
 */
public class ArraySort {
    // define a method used to search for the smallest value in a array
    public static int findSmallest(int... x){
        int index = 0;
        for (int i = 0; i < x.length; i++){
            if (x[i] < x[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // a given array
        int[] x = {6,2,6,3,5,1,999,7,21,65,89,31,62};

        for (int i = 0; i < x.length-1; i++) {
            int temp = x[i];

            // get the remaining unsorted array
            int[] tempArr = new int[x.length - i];
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[j] = x[i + j];
            }

            // find the smallest value in the remaining array
            int index = findSmallest(tempArr);

            // exchange
            x[i] = x[index + i];
            x[index + i] = temp;
        }

        // print the sorted array
        for (int i : x) {
            System.out.print(i + " ");
        }
    }



}
