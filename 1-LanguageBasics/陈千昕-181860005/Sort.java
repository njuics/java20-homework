
public class Sort {
	public static void swap(int[] array, int xpos, int ypos) {
		int temp = array[xpos];
		array[xpos] = array[ypos];
		array[ypos] = temp;
	}

	public static int partition(int[] array, int ppos, int s, int e) {
		int div = s;
		for (int i = s; i <= e; i++) {
			if (array[i] < array[ppos]) {
				swap(array, i, div);
				if (div == ppos)
					ppos = i;
				div++;
			}
		}
		swap(array, div, ppos);
		return div;
	}

	public static void QuickSort(int[] array, int s, int e) {
		if (s < e) {
			int ppos = s;
			ppos = partition(array, ppos, s, e);
			QuickSort(array, s, ppos - 1);
			QuickSort(array, ppos + 1, e);
		}
	}

	public static void main(String[] args) {
		int array[] = { 2, 69, 10, -32, 9999, 7, 1, 13 };

		QuickSort(array, 0, array.length - 1);

		for (int i : array) {
			System.out.print(i + " ");
		}
	}

}
