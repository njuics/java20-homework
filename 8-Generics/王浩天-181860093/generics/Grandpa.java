package generics;

import java.util.ArrayList;


public class Grandpa<T extends Myinteger> extends Human {
	private static final int num_of_brothers;
	static {
		num_of_brothers=7;		
	}
	ArrayList<Calabash_Brothers<T>> lis=new ArrayList<>();
	
	Grandpa(T a,ArrayList<Calabash_Brothers<T>> pre){
		this.value=a;
		this.name="Grandpa";
		for(int i=0;i<num_of_brothers;i++) {
			lis.add(pre.get(i));
		}
	}
	boolean compare(Calabash_Brothers<T> a,Calabash_Brothers<T> b) {
		if(a.value.compareTo(b.value)<0)return true;
		else return false;
	}
	void swap(Calabash_Brothers<T> a,Calabash_Brothers<T> b) {
		Myinteger tem_val=a.getval();String tem_nam=a.getname();
		a.change(b.getval(),b.getname());b.change(tem_val,tem_nam);
	}
	void queue(int num,int now) {		
		int pre=lis.get(now).getval().val-1;
		if(pre!=now) {
			swap(lis.get(now),lis.get(pre));			
			num++;
			queue(num,now);
		}
		num++;
		if(num>=num_of_brothers)return;
		else if(now<num_of_brothers-1) { queue(num,now+1);}
		else if(now==num_of_brothers-1) {
			queue(num,0);
		}
	}
	void countoff() {
		for(int i=0;i<lis.size();i++) {
			lis.get(i).show();
		}
	}
}
