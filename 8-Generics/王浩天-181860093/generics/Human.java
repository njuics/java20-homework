package generics;
class Myinteger implements Comparable<Myinteger>{
	int val=0;
	Myinteger(int i){
		this.val=i;
	}
	public int compareTo(Myinteger other) {
		return this.val-other.val;
	}
	
}

public class Human<T extends Myinteger> {
	T value;
	String name;
	Human(){;}
	Human(T i,String na){
		this.value= i;
		this.name=na;		
	}
	T getval() {
		return value;
	}
	String getname() {
		return name;
	}
	void change(T i,String n) {
		value=i;name=n;
	}
	void show() {
		System.out.print(value.val+"-"+name+" ");
	}
	
}
