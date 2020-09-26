package OOPAdvanced; // package: seperated from OOPFoundation
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayGround {
	public static void main(String[] args) {
		// Initialize characters 
		CalBro[] bros = new CalBro[7];
		Grandpa grandPa = new Grandpa();
		SortMethod bubbleSort = new BubbleSort(); // polymorphism
		SortMethod selectSort = new SelectSort();
		
		initBros(bros);
		bubbleSort.choreography(bros);			  // dynamic binding		
		
		initBros(bros);
		bubbleSort.orchestration(bros, grandPa);

		initBros(bros);
		selectSort.choreography(bros);
		
		initBros(bros);
		selectSort.orchestration(bros, grandPa);
		
		System.out.println("done");
	}

	public static void initBros(CalBro[] bros) {
		// initialize a random array
		Integer[] orders = new Integer[CalBro.maxOrder];
		for(int i = 0; i < CalBro.maxOrder; ++i)
			orders[i] = i + 1;
		List<Integer> orderList = Arrays.asList(orders);
		Collections.shuffle(orderList);
		orderList.toArray(orders);
		// assign initial random order based on above array
		for(int i = 0; i < CalBro.maxOrder; ++i) {
			bros[i] = new CalBro();
			bros[i].order = orders[i];
			switch(orders[i]) {
				case 1: bros[i].name = "老大"; break;
				case 2:	bros[i].name = "老二"; break;
				case 3:	bros[i].name = "老三"; break;
				case 4:	bros[i].name = "老四"; break;
				case 5:	bros[i].name = "老五"; break;
				case 6:	bros[i].name = "老六"; break;
				case 7:	bros[i].name = "老七"; break;
			};
		}
	}
}
