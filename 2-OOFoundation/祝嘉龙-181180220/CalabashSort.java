/*
Main process of the Calabash boys Sort
*/

public class CalabashSort{
	public static void main(String[] args){
		CalabashFamily cf = new CalabashFamily();
		System.out.println("insertSort & orchestration");
		cf.sm = SortMethod.ORCHESTRATION;
		cf.shuffle();
		cf.numberOff();
		SortAlgorithm.insertSort(cf);
		cf.numberOff();
		
		System.out.println("bubbleSort & choreography");
		cf.sm = SortMethod.CHOREOGRAPHY;
		cf.shuffle();
		cf.numberOff();
		SortAlgorithm.bubbleSort(cf);
		cf.numberOff();
	}
}

