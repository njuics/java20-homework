//package homeworklib;

public class Grandpa{
	static Grandpa gp;
	static{
		gp = new Grandpa();
	}
	
	private Grandpa() {}
	
	boolean compare(Calabash x, Calabash y){
		return x.seniority < y.seniority;
	}
	
	void swap(Calabash x, Calabash y){
		int temp = x.position;
		x.position = y.position;
		y.position = temp;
		Calabash.line[x.position] = x;
		Calabash.line[y.position] = y;
	}
}
