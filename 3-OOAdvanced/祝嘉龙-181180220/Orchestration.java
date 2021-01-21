//package homeworklib;

public class Orchestration implements Processor{
	@Override
	public boolean compare(int i, int j){
		return Grandpa.gp.compare(Calabash.line[i], Calabash.line[j]);
	}
	
	@Override
	public void swap(int i, int j){
		Grandpa.gp.swap(Calabash.line[i], Calabash.line[j]);
	}
}
