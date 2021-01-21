/*
Sort And Print A Given Array Example
*/
public class SortAndPrint{
	public static void main(String[] args){
		//array of 10 numbers
		int list[] = new int[]{14,23,15,12,78,54,71,29,19,9};
		//using insert sort
		for(int i = 1; i < list.length; i++){
			for(int j = i - 1; j >= 0; j--){
				if(list[j + 1] < list[j]){
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
		for(int i = 0; i < list.length; i++){
			System.out.print(list[i] + " ");
		}
	}
}
