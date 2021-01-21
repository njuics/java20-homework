public class Creature implements Comparable <Creature>{
    protected String name;

    public Creature(String name){
        reset(name);
    }

    Creature(Creature c){
        reset(c);
    }

    public String getName(){
        return name;
    }

    public void reset(String name){
        this.name = name;
    }

    public void reset(Creature c){
        reset(c.name);
    }

    public void report(){
        System.out.print(name);
    }

    @Override
	public int compareTo(Creature c) {
		return name.compareTo(c.name);
	}
}
