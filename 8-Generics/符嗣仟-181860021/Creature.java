enum Sexual{
    MALE,FEMALE
}

public class Creature implements Comparable<Creature>{
    public String name;
    public Sexual sex;
    Creature(String n,Sexual s){
        this.name = n;
        this.sex = s;
    }
    Creature(){
        name = null;
        sex = Sexual.MALE;
    }
    @Override
    public int compareTo(Creature c1) {
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
