package homework_7;

public class Calabash_Brothers implements Comparable<Calabash_Brothers> {
	private String name;
	private boolean gender;//0-female 1-male
	
	Calabash_Brothers(String n,boolean g){
		name=n;
		gender=g;
	}
	
	boolean get_gender() {
		return gender;
	}
	String get_name() {
		return name;
	}
	void print_name(){
		System.out.print("name: "+name+"      ");
	}
	void print_gender() {
		if(gender) {
			System.out.print("gender: "+"male"+"      ");
		}
		else {
			System.out.print("gender: "+"female"+"      ");
		}
	}
	
	@Override
	public int compareTo(Calabash_Brothers o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
		
	}
}

