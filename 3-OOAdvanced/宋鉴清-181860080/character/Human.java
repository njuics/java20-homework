package character;

public class Human {
    protected String name;
    Human(String name){
        this.name = name;
    }

    public void report_self_name(){
        System.out.print(name);
    }
}
