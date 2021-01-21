package object;

public class Creature {

    public final String name;

    public Creature(String name){
        this.name=name;
    }

    public void reportName() {
        System.out.print(name);
    }

    public String getName()
    {
        return name;
    }

    public void info(){
        System.out.println("A creature has been created!");
    }

}
