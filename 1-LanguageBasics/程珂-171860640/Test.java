package Test;

class Swap {
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class Sort {
    private int[] arr = { -1, 2, 3, 5, 7, 2, 56, 12, 34, 0 };

    private void printArr(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }

    // Print the origin array
    public void printArrBeforeSort() {
        System.out.println("Arrar Before Sort:");
        printArr(arr);
    }

    // Sort the clone of the origin array
    // return the clone
    public int[] sort() {
        Swap swap = new Swap();
        int[] tempArr = arr.clone();
        for (int i = 0; i < tempArr.length; i++) {
            int min = i;
            for (int j = i + 1; j < tempArr.length; j++)
                if (tempArr[j] < tempArr[min])
                    min = j;
            swap.swap(tempArr, i, min);
        }
        return tempArr;
    }

    // Get the sorted array and print it
    public void printArrAferSort() {
        System.out.println("Array After Sort:");
        int[] tempArr = sort();
        printArr(tempArr);
    }
}

class HelloWorld {
    public static void main(String[] args) {
        Sort s = new Sort();
        s.printArrBeforeSort();
        s.printArrAferSort();
    }
}
