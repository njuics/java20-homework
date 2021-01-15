
public class Huluwa extends Creature{
    // protected String name;
    private int gender;// 0: female, 1: male, 2: unknown
    public Huluwa(){
        super();
        this.gender = 2;
    }
    public Huluwa(String name){
        super(name);
        this.gender = 2;
    }
    public Huluwa(int gender){
        super();
        this.gender = gender;
    }
    public Huluwa(String name,int gender){
        super(name);
        this.gender = gender;
    }
    public int get_gender(){
        return this.gender;
    }
    public void set_gender(int gender){
        this.gender = gender;
    }

}