package homework_9;

import java.util.ArrayList;

public class Grandpa extends Human {
	private static final int num_of_brothers;
	static {
		num_of_brothers=7;		
	}
	ArrayList<Calabash_Brothers> lis=new ArrayList<>();
	
	Grandpa(ArrayList<Calabash_Brothers> pre){
		this.name="Grangpa";
		for(int i=0;i<num_of_brothers;i++) {
			lis.add(pre.get(i));
		}
	}
	boolean compare(Calabash_Brothers a,Calabash_Brothers b) {
		if(a.getval()<b.getval())return true;
		else return false;
	}
	void swap(Calabash_Brothers a,Calabash_Brothers b) {
		int tem_val=a.getval();String tem_nam=a.getname();
		a.change(b.getval(),b.getname());b.change(tem_val,tem_nam);
	}
	void queue(int num,int now) {		
		int pre=lis.get(now).getval()-1;
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

