enum Sexual{
    MALE,FEMALE
}
interface Creature{
    public String getname();
    public Sexual getsex();
}

public class Calabash implements Creature,Comparable<Calabash>{
    private String name;
    private Sexual sex;
    Calabash(String n,Sexual s){
        this.name = n;
        this.sex = s;
    }
    Calabash(){
        name = null;
        sex = Sexual.MALE;
    }
    public String getname(){
        return this.name;
    }
    public Sexual getsex(){
        return this.sex;
    }
    
    @Override
    public String toString() {
        return " "+this.name+" "+this.sex.toString();
    }


    public int compareTo(Calabash c1) {
        return this.name.compareTo(c1.getname());
    }
}
