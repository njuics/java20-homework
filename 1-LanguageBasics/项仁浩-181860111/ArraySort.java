import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("ArraySize:");
		int sz = input.nextInt();
		int[] a = new int[sz];
		System.out.print("Input all num:");
		for (int i = 0; i < sz; i++)
			a[i] = input.nextInt();

		for (int i = 0; i < sz - 1; i++) {
			for (int j = i + 1; j < sz; j++) {
				if (a[j] < a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		System.out.print("The sorted array:");
		for(int i=0;i<sz;i++)
			System.out.print(a[i]+" ");
	}

}
