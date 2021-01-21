package OOAdvanced.characters;

public class Human {

    public static int count = 0;

    public String name = "";

    public void call(){
        System.out.print(name+"\t");
    }

    public Human(){
        count++;
    }

    public Human(String nm){
        this();
        name = nm;
    }
}
