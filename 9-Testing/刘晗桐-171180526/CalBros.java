package Testing;

import java.lang.Math;
import java.util.*;

public class CalBros {
	public List<CalBro> bros = new LinkedList<CalBro>();
	CalBros(int number) throws IllegalArgumentException {
		if(number == -1) {
			throw new IllegalArgumentException();
		}
		ArrayList<String> nameList = new ArrayList<String>();
		for(int i = 1; i <= number; ++i) {
			nameList.add(Integer.toString(i));
		}
		Collections.shuffle(nameList);
		for(int i = 0; i < number; ++i) {
			// generate random genders
			String newGender, newName;
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


