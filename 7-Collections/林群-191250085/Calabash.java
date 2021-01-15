public class Calabash implements Comparable<Calabash>{
    private String name;
    private Gender gender;
    
    public Calabash(String name,Gender gender){
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void numberOff(){
        System.out.println("Name:" + this.name + " Gender:" + this.gender.toString());
    }

    @Override
    public int compareTo(Calabash o) {
        return this.getName().compareTo(o.getName());
    }
}
