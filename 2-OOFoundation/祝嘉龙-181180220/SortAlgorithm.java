public class SortAlgorithm{
	public static void insertSort(CalabashFamily cf){
		for(int i = 1; i < 7; i++){
			for(int j = i - 1; j >= 0; j--){
				if(cf.compare(j + 1, j)){
					cf.swap(j, j + 1);
				}
			}
		}
	}
	public static void bubbleSort(CalabashFamily cf){
		boolean flag = false;
		do{
			flag = false;
			for(int i = 0; i < 6; i++){
				if(cf.compare(i + 1, i)){
					cf.swap(i, i + 1);
					flag = true;
				}
			}
		}while(flag);
	}
	public static void f() {}
}