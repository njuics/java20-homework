import java.util.Random;

class Calabash{
	int seniority;
	
	static String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	
	Calabash(int seniority) {this.seniority = seniority;}
	boolean compare(Calabash other){
		return this.seniority < other.seniority;
	}
	void exchange(Calabash other){
		int temp = this.seniority;
		this.seniority = other.seniority;
		other.seniority = temp;
	}
	void speak(){
		System.out.print(Calabash.names[this.seniority] + " ");
	}
}

class Grandapa{
	boolean compare(Calabash x, Calabash y){
		return x.seniority < y.seniority;
	}
	void swap(Calabash x, Calabash y){
		int temp = x.seniority;
		x.seniority = y.seniority;
		y.seniority = temp;
	}
}

enum SortMethod{
	ORCHESTRATION, CHOREOGRAPHY
}

public class CalabashFamily{
	Calabash[] line = new Calabash[7];
	Grandapa gp = new Grandapa();
	SortMethod sm = SortMethod.ORCHESTRATION;
	
	CalabashFamily(){
		for(int i = 0; i < 7; i++){
			line[i] = new Calabash(i);
		}
	}
	boolean compare(int i, int j){
		switch(sm){
			case ORCHESTRATION:
				return gp.compare(line[i], line[j]);
			case CHOREOGRAPHY:
				return line[i].compare(line[j]);
			default:
			return true;
		}
	}
	void swap(int i, int j){
		switch(sm){
			case ORCHESTRATION:
				gp.swap(line[i], line[j]);
				break;
			case CHOREOGRAPHY:
				line[i].exchange(line[j]);
				break;
		}
	}
	void shuffle(){
		Random r = new Random();
		for(int i = 6; i>= 0; i--){
			int j = r.nextInt(i + 1);
			this.swap(i, j);
		}
	}
	void numberOff(){
		for(Calabash i:line){
			i.speak();
		}
		System.out.println();
	}
}
