package homework_9;

import java.util.ArrayList;

public class Orchestration implements Sort_method{
	public void sort(ArrayList<Calabash_Brothers> lis){
		Grandpa a=new Grandpa(lis);
		a.queue(0, 0);
		a.countoff();
	}	
}
