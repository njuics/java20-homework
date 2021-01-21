import java.util.Random;

public class Calabash implements Named, Gendered, Comparable<Calabash>{
	public Calabash(){
		this.name = randomName();
		this.gender = rand.nextBoolean();
	}
	
	@Override
	public String getName(){
		return this.name;
	}
	
	@Override
	public int getGender(){
		return (this.gender ? MALE : FEMALE);
	}
	
	@Override
	public int compareTo(Calabash other){
		return this.name.compareTo(other.name);
	}
	
	@Override
	public String toString(){
		return "(" + this.name + ", " + (this.gender ? "Male" : "Female") + ")"; 
	}
	
	public static Calabash[] calabashArray(int len){
		Calabash[] ret = new Calabash[len];
		for(int i = 0; i < len; i++){
			ret[i] = new Calabash();
		}
		return ret;
	}
	
	private String name;
	private boolean gender;
	
	private static Random rand = new Random();
	
	private static String randomName(){
		int len = rand.nextInt(4) + 4;
		char[] name = new char[len];
		name[0] = (char)(rand.nextInt(26) + 'A');
		for(int i = 1; i < len; i++){
			name[i] = (char)(rand.nextInt(26) + 'a');;
		}
		return String.valueOf(name);
    }
}
