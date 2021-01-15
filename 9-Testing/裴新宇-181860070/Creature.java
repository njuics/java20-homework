
public class Creature  implements Comparable<Creature>{
    protected String name;
    public Creature() {
        this.name = "Unknown";
    }
    public Creature(String name){
        this.name = name;
    }
    public String get_name(){
        return this.name;
    }
    public void set_name(String name){
        this.name = name;
    }
    public void count_off(){
        System.out.print(this.name);
    }

    @Override
	public int compareTo(Creature h) {
		return name.compareTo(h.name);
	}
}