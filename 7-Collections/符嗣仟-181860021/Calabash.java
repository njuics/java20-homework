enum Sexual{
    MALE,FEMALE
}
public class Calabash implements Comparable<Calabash>{
    public String name;
    public Sexual sex;
    Calabash(String n,Sexual s){
        this.name = n;
        this.sex = s;
    }
    Calabash(){
        name = null;
        sex = Sexual.MALE;
    }
    @Override
    public int compareTo(Calabash c1) {
        return this.name.compareTo(c1.name);
    }

    void NumberOff(){
        //报数
        if (sex==Sexual.MALE)
            System.out.print(name+"-"+"MALE"+"  ");
        else
            System.out.print(name+"-"+"FEMALE"+"  ");
    }
}
