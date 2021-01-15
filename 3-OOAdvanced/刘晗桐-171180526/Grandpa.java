package OOPAdvanced;

public class Grandpa extends Character {
	Grandpa() {
		name = "үү";
	}
	public int compare(CalBro bro1, CalBro bro2) {
		if(bro1.order < bro2.order) {
			return -1;
		}
		else if(bro1.order > bro2.order) {
			return 1;
		}
		else
			return 0;
	}
	public void swap(CalBro bro1, CalBro bro2) {
		int tmp = bro1.order;
		bro1.order = bro2.order;
		bro2.order = tmp;
	}
}
