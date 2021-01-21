package calabash;

public class Calabash {
    private int id;
    private String name;

    public Calabash(int id, String name){
        reset(id, name);
    }
    Calabash(Calabash c){
        reset(c);
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void reset(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void reset(Calabash c){
        id = c.id;
        name = c.name;
    }
}
