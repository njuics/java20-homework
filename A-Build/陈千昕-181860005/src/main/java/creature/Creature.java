package creature;

public class Creature implements Comparable <Creature>{
    protected String name;

    public Creature(String name){
        reset(name);
    }

    public Creature(Creature c){
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof Creature){
            Creature test = (Creature)obj;
            if(test.name == this.name) return true;
            else return false;
        }
        return false;
    }
}
