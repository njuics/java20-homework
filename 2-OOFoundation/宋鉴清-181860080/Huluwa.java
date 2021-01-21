public class Huluwa {
	String name;
	int index;
	String[] NumPos = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
	
	Huluwa(String n, int i){
		name = n;
		index = i;
	}

	boolean compare_less(Huluwa another){
		return this.index < another.index;
	}

	void Swapwithnext(Huluwa[] pre_queue, int i, int j){
		Huluwa tmp = pre_queue[j];
		pre_queue[j] = pre_queue[i];
		pre_queue[i] = tmp;
	}
	
	void report_num() {
		System.out.print(NumPos[index]);
	}
}
