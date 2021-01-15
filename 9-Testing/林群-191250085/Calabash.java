public class Calabash extends Creature {
    private Gender gender;

    public Calabash(String name,Gender gender,Position position){
        super(name, position);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }


    public void numberOff(){
        System.out.println("Name:" + this.name + " Gender:" + this.gender.toString() + " Position:" + this.position.getPosition());
    }

}
