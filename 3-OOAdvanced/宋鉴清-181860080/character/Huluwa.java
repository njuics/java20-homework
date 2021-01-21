package character;

public class Huluwa extends Human{
	private int index;

	public Huluwa(String name){
		super(name);
		index = 0;
	}
	
	public Huluwa(String name, int index){
		super(name);
		this.index = index;
	}

	public int get_index(){
		return index;
	}

	public boolean compare_less(Huluwa another){
		return this.index < another.index;
	}

	public void Swapwithnext(Huluwa[] pre_queue, int i, int j){
		Huluwa tmp = pre_queue[j];
		pre_queue[j] = pre_queue[i];
		pre_queue[i] = tmp;
	}
}
