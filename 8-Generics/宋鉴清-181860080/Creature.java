import java.lang.Comparable;

public class Creature implements Comparable<Creature>{
    protected String name;
	protected String gender;
	
	Creature(String name, String gender){
		this.name = name;
		this.gender = gender;
    }
    
    public String get_name(){
        return name;
    }
    public String get_gender(){
        return gender;
    }

	@Override
	public int compareTo(Creature other) {
		return this.name.compareTo(other.name);
	}
	@Override
	public String toString(){
		return name;
	}
}
