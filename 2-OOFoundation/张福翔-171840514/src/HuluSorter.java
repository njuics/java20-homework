import java.util.Arrays;

public class HuluSorter {
    enum SortMode {
        ORCHESTRATION, CHOREOGRAPHY
    }
    SortMode mode;
    HuluSorter(SortMode mode) {
        this.mode = mode;
    }
    public void setMode(SortMode mode) {
        this.mode = mode;
    }

    private void assign(HuluBaby[]arr, int i, HuluBaby another) {
        // let arr[i] = another
        // just assign the reference, not CLONE
        // the behavior is different in different mode
        if (mode.equals(SortMode.ORCHESTRATION)) {
            arr[i] = another;
        }
        else if (mode.equals(SortMode.CHOREOGRAPHY)) {
            arr[i].huluAssign(arr, i, another);
        }
    }

    private void swap(HuluBaby[]arr, int i, int j) {
        // swap arr[i] and arr[j]
        // just swap the reference, not CLONE
        // the behavior is different in different mode
        if (mode.equals(SortMode.ORCHESTRATION)) {
            HuluBaby tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        else if (mode.equals(SortMode.CHOREOGRAPHY)) {
            arr[i].huluSwap(arr, i, j);
        }
    }

    // NOTE: you can add your own sort algorithm here
    // we only provide quickSort, mergeSort and bubbleSort here

    public void quickSort(HuluBaby[]arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }
    private void quickSortHelper(HuluBaby[]arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSortHelper(arr, left, mid-1);
            quickSortHelper(arr, mid+1, right);
        }
    }
    private int partition(HuluBaby[]arr, int left, int right) {
        int i = left, j = right;
        HuluBaby pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j].compareTo(pivot) >= 0) j--;
            if (i < j) assign(arr, i, arr[j]);
            while (i < j && arr[i].compareTo(pivot) <= 0) i++;
            if (i < j) assign(arr, j, arr[i]);
        }
        assign(arr, i, pivot);
        return i;
    }

    public void mergeSort(HuluBaby[]arr) {
        HuluBaby[] tmpArray = Arrays.copyOf(arr, arr.length);
        mergeSortHelper(arr, tmpArray, 0, arr.length-1);
    }
    private void mergeSortHelper(HuluBaby[]arr, HuluBaby[]tmpArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, tmpArray, left, mid);
            mergeSortHelper(arr, tmpArray, mid+1, right);
            merge(arr, tmpArray, left, mid, right);
        }
    }
    private void merge(HuluBaby[]arr, HuluBaby[]tmpArray, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                assign(tmpArray, k, arr[i++]);
                k++;
            }
            else {
                assign(tmpArray, k, arr[j++]);
                k++;
            }
        }
        while (i <= mid) {
            assign(tmpArray, k, arr[i++]);
            k++;
        }
        while (j <= mid) {
            assign(tmpArray, k, arr[j++]);
            k++;
        }
        for (int t = left; t <= right; t++) {
            assign(arr, t, tmpArray[t]);
        }
//        System.arraycopy(tmpArray, left, arr, left, right-left+1);
    }

    public void bubbleSort(HuluBaby[]arr) {
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
}
