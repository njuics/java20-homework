package generics;


public class Calabash_Brothers<T extends Myinteger> extends Human {
	Calabash_Brothers(T i,String na){
		this.value=i;
		this.name=na;
	}
	
	
	boolean compare_val(Calabash_Brothers<T> a) {
		if(this.value.compareTo(a.value)<0)return true;
		else return false;
	}
	void swap(Calabash_Brothers<T> a) {
		Myinteger tem_val=a.getval();
		String tem_nam=a.getname();
		a.change(value, name);
		this.change( tem_val, tem_nam);
	}
}

