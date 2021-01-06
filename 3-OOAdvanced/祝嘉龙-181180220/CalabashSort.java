//import homeworklib.*;

public class CalabashSort{
	public static void main(String[] args){
		System.out.println("insertSort & orchestration");
		Calabash.shuffle();
		Calabash.numberOff();
		Sorter.insertSort(new Orchestration());
		Calabash.numberOff();
		
		System.out.println("bubbleSort & choreography");
		Calabash.shuffle();
		Calabash.numberOff();
		Sorter.bubbleSort(new Choreography());
		Calabash.numberOff();
	}
}

