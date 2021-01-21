public class QuickSort {

  static void quickSort(int a[], int left, int right) {
    if (left < right) {
      int pivotpos = partition(a, left, right);
      quickSort(a, left, pivotpos - 1);
      quickSort(a, pivotpos + 1, right);
    }
  }

  static int partition(int a[], int low, int high) {
    int pivotpos = low, pivot = a[low];
    for (int i = low + 1; i <= high; i++) {
      if (a[i] < pivot) {
        pivotpos++;
        if (i != pivotpos) {
          int temp = a[i];
          a[i] = a[pivotpos];
          a[pivotpos] = temp;
        }
      }
    }
    a[low] = a[pivotpos];
    a[pivotpos] = pivot;
    return pivotpos;
  }

  public static void main(String[] args) {
    int[] a = { 33, 12, 45, 2, 61, 101, 24, 1, 56, 79 };
    System.out.println("original data:");
    for (int i : a) {
      System.out.print(i);
      System.out.print(' ');
    }
    System.out.println();
    quickSort(a, 0, a.length - 1);
    System.out.println("after sorting:");
    for (int i : a) {
      System.out.print(i);
      System.out.print(' ');
    }
  }
}
