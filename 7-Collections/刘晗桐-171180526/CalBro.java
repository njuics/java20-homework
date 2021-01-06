package OOPCollections;

public class CalBro implements Comparable<CalBro> {
	private String name;
	private String gender;
	
	CalBro(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setGender(String newGender) {
		this.gender = newGender;
	}
	
	public String getName() {
		return this.name;
	}
	public String getGender() {
		return this.gender;
	}
	
    @Override
	public int compareTo(CalBro otherCalBro) {
		return this.getName().compareTo(otherCalBro.getName());	
	}
}
