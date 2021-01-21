import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CalBros extends Characters {
	Characters[] calBros;
	CalBros() {
		// Main constructor for CalBros		
		calBros = new Characters[7];
		for(int i = 0; i < 7; ++i)
			calBros[i] = new Characters();
		
		for(int i = 1; i < 7; ++i) {
			calBros[i].id = i+1;
		}
		for(int i = 0; i < 7; ++i) {
			switch(i) {
			case 0: calBros[i].name = "老大"; break;
			case 1: calBros[i].name = "老二"; break;
			case 2: calBros[i].name = "老三"; break;
			case 3: calBros[i].name = "老四"; break;
			case 4: calBros[i].name = "老五"; break;
			case 5: calBros[i].name = "老六"; break;
			case 6: calBros[i].name = "老七"; break;
			}
		}
	}
	
	public void shuffle() {
		// Shuffle the position for CalBros
		List<Characters> calList = Arrays.asList(calBros);
		Collections.shuffle(calList);
		calList.toArray(calBros);
	}
	
	public void report() {
		// report the position of current permutation
		for(Characters bro : calBros)
			System.out.println(bro.name);
	}
	
	public int compare(Characters bro1, Characters bro2) {
		// id1 < id2, return -1
		// id1 == id2, return 0
		// id1 > id2, return 1
		int id1 = bro1.id;
		int id2 = bro2.id;
		if(id1 < id2)
			return -1;
		else if(id1 == id2)
			return 0;
		else
			return 1;
	}
	
	public void swap(Characters bros, int pos1, int pos2) {
		// swap the position between 2 CalBros
		Characters temp = this.calBros[pos1];
		this.calBros[pos1] = this.calBros[pos2];
		this.calBros[pos2] = temp;
	}
	
	public void sort() {
		Sort sortObject = new Sort();
		sortObject.bubbleSort(this.calBros);
	}
}
