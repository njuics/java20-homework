package Testing;

public class PlayGround {

	public static void main(String[] args) {
		// generate random cal bros
		CalBros bros = new CalBros(20);
		bros.printAll();
		Sort newSort = new Sort();
		
		// generate two teams, one is male, another is female
		CalBros maleBros = new CalBros(0);
		CalBros femaleBros = new CalBros(0);
		for(CalBro bro : bros.bros) {
			if(bro.getGender() == "male")
				maleBros.bros.add(bro);
			else
				femaleBros.bros.add(bro);
		}
		
		// sort male teams by iterat/comparat ors
		newSort.SortDisorder(maleBros.bros);
		newSort.SortAscnedator(maleBros.bros);
		maleBros.printAll();
		
		// sort female teams by iterat/comparat ables
		newSort.SortDisorder(femaleBros.bros);
		newSort.SortAscendable(femaleBros.bros);
		femaleBros.printAll();
		
		// sort to descending order
		newSort.SortDisorder(bros.bros);
		newSort.SortDescend(bros.bros);
		bros.printAll();
	}
}
