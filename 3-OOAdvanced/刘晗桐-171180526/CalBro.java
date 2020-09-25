package OOPAdvanced;

public class CalBro extends Character { // inheritance
	static final int minOrder = 1;
	static final int maxOrder = 7;
	public int order;
	static int total = 0; // static variable
	static { // static block: used to indicate only 7 bros 
			 // can co-exist in this world
		total += 1;
		assert total <= maxOrder;
	}
	CalBro() { 
		name = "";
		order = 0;
	}
	CalBro(int order, String name) { // constructor
		assert order >= minOrder && order <= maxOrder;
		this.order = order;
		this.name = name;
	}
	public void swap(CalBro bro) { // encapsulation
		int temp = this.order;
		this.order = bro.order;
		bro.order = temp;
	}
	public int compare(CalBro bro) {
		if(this.order < bro.order) {
			return -1;
		}
		else if(this.order > bro.order) {
			return 1;
		}
		else
			return 0;
	}
}
