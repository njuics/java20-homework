package Testing;

public class CalBro extends Character implements Comparable<CalBro> {
	CalBro(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}
	
    @Override
	public int compareTo(CalBro otherCalBro) {
		return this.getName().compareTo(otherCalBro.getName());	
	}
}
