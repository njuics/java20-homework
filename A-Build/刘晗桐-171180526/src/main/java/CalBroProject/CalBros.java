package CalBroProject;
import java.util.*;
import com.google.common.base.Preconditions;

public class CalBros {
	public List<CalBro> bros = new LinkedList<>();
	CalBros(int number) {
		Preconditions.checkArgument(number != -1, "Invalid number argument!");
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i = 1; i <= number; ++i) {
			nameList.add(Integer.toString(i));
		}
		Collections.shuffle(nameList);
		for(int i = 0; i < number; ++i) {
			// generate random genders
			String newGender;
			String newName;
			if(Math.random() < 0.5)
				newGender = "male";
			else 
				newGender = "female";
			newName = nameList.get(i);
			CalBro newBro = new CalBro(newName, newGender);
			bros.add(newBro);
		}
	}
	
	List<CalBro> getBroList() {
		return this.bros;
	}
	
	public void printAll() {
		System.out.println("Current Cal Bros:");
		for(int i = 0; i < this.bros.size(); ++i) {
			System.out.print(this.bros.get(i).getName() + " ");
			System.out.print(this.bros.get(i).getGender());
			System.out.println();
		}
	}
}


