//package homeworklib;

public class Choreography implements Processor{
	@Override
	public boolean compare(int i, int j){
		return Calabash.line[i].compareTo(Calabash.line[j]);
	}
	
	@Override
	public void swap(int i, int j){
		Calabash.line[i].swapWith(Calabash.line[j]);
	}
}