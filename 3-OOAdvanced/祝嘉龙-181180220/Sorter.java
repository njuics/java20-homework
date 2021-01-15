//package homeworklib;

public class Sorter{	
	public static void insertSort(Processor p){
		for(int i = 1; i < 7; i++){
			for(int j = i - 1; j >= 0; j--){
				if(p.compare(j + 1, j)){
					p.swap(j, j + 1);
				}
			}
		}
	}
	public static void bubbleSort(Processor p){
		boolean flag = false;
		do{
			flag = false;
			for(int i = 0; i < 6; i++){
				if(p.compare(i + 1, i)){
					p.swap(i, i + 1);
					flag = true;
				}
			}
		}while(flag);
	}
}
