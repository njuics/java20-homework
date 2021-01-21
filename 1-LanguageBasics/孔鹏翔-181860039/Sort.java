class selectsort{
	public void sort(int[] array,int num) {
		for(int i=0;i<num-1;++i) {
			int min=i;
			for(int j=i+1;j<num-i;++j) {
				if(array[min]>array[j]) {
					min=j;
				}
			}
			int temp=array[i];
			array[i]=array[min];
			array[min]=temp;
		}
		for(int i=0;i<num;++i) {
			System.out.println(array[i]);
			System.out.println(" ");
		}
		return;
	}
}

public class Sort {
	public static void main(String []args) {
		int[] array= {4,3,2,1};
		selectsort b=new selectsort();
		b.sort(array, 4);
	}
}
