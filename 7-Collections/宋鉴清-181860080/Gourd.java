import java.lang.Comparable;

public class Gourd implements Comparable<Gourd>{
    private String name;
	private String gender;
	
	Gourd(String n, String g){
		name = n;
		gender = g;
    }
    
    public String getname(){
        return name;
    }
    public String getgender(){
        return gender;
    }

	@Override
	public int compareTo(Gourd other) {
		return this.name.compareTo(other.name);
	}
	@Override
	public String toString(){
		return name;
	}
}
