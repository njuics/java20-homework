//package intsort;
import java.util.Scanner;

public class IntSort {
	public static void main(String[] arg)
	{
		Scanner jin = new Scanner(System.in);
		System.out.println("Please enter the length of the array: ");
		int len = jin.nextInt();
		int[] array = new int[len];
		int data;
		System.out.println("Please enter the array in one line: ");
		for (int i=0;i<len;i++)
		{
			data = jin.nextInt();
			array[i] = data;
		}
		Sort s = new Sort();
		s.quick_sort(array, 0, len-1);
		System.out.println("The result is as follows:");
		for (int i=0;i<len;i++)
		{
			System.out.print(array[i]+" ");
		}
	}

}


class Sort{
	public void quick_sort(int[] a,int l,int r)
	{
		if(l<r)
		{
			int p = partition(a,l,r);
			quick_sort(a,l,p-1);
			quick_sort(a,p+1,r);
		}
	}
	public int partition(int[] a,int l,int r)
	{
		int p = r;
		int i = l-1;
		for (int j=l;j<r;j++)
		{
			if(a[j]<a[p])
			{
				i++;
				swap(a,i,j);
			}
		}
		i++;
		swap(a,i,p);
		return i;
	}
	public void swap(int[] a,int i,int j)
	{
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
