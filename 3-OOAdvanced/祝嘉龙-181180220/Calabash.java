//package homeworklib;

import java.util.Random;

public class Calabash{
	int seniority;
	int position;
	String name;
	
	static Calabash[] line;
	
	static{
		line = new Calabash[7];
		line[0] = new Calabash(0, 0, "老大");
		line[1] = new Calabash(1, 1, "老二");
		line[2] = new Calabash(2, 2, "老三");
		line[3] = new Calabash(3, 3, "老四");
		line[4] = new Calabash(4, 4, "老五");
		line[5] = new Calabash(5, 5, "老六");
		line[6] = new Calabash(6, 6, "老七");
	}
	
	public static void shuffle(){
		Random r = new Random();
		for(int i = 6; i>= 0; i--){
			int j = r.nextInt(i + 1);
			line[i].swapWith(line[j]);
		}
	}
	
	public static void numberOff(){
		for(Calabash i:line){
			i.speak();
		}
		System.out.println();
	}
	
	private Calabash(int seniority, int position, String name){
		this.seniority = seniority;
		this.position = position;
		this.name = name;
	}
	
	boolean compareTo(Calabash other){
		return this.seniority < other.seniority;
	}
	
	void swapWith(Calabash other){
		int temp = this.position;
		this.position = other.position;
		other.position = temp;
		line[this.position] = this;
		line[other.position] = other;
	}
	
	void speak(){
		System.out.print(this.name + " ");
	}
}
