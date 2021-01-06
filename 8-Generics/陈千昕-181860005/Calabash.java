public class Calabash extends Creature {
    private boolean gender;

    public Calabash(String name, boolean gender){
        super(name);
        reset(name, gender);
    }

    Calabash(Calabash c){
        super(c);
        reset(c);
    }

    public boolean getGender(){
        return gender;
    }

    public void reset(String name, boolean gender){
        this.name = name;
        this.gender = gender;
    }

    public void reset(Calabash c){
        reset(c.name, c.gender);
    }

    public void report(){
        String genderName = "G";
        if(gender){
            genderName = "B";
        }
        System.out.print(name + "(" + genderName + ")");
    }
}
