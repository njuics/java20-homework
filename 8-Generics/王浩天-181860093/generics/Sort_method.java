package generics;

import java.util.ArrayList;

public abstract interface Sort_method<T> {
		public  void sort(ArrayList<Calabash_Brothers> lis) ;
}

class Orchestration<T> implements Sort_method<T>{
	@SuppressWarnings("unchecked")
	public void sort(ArrayList<Calabash_Brothers> lis){
		Grandpa<Myinteger> a=new Grandpa(new Myinteger(0),lis);
		a.queue(0, 0);
		a.countoff();
	}

}

class Choreography<T> implements Sort_method<T>{
	public void sort(ArrayList<Calabash_Brothers> lis){				
		for(int i=0;i<7-1;i++) {
			for(int j=0;j<7-1;j++) {
				if(lis.get(j).getval().val>lis.get(j+1).getval().val) {
					lis.get(j).swap(lis.get(j+1));					
				}			
			}		
		}
		for(int i=0;i<lis.size();i++) {
			lis.get(i).show();
		}
	}
}