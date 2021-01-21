package cn.edu.xiaoyu.homework9;

public class Calabash implements Comparable<Calabash>{
    Calabash(){}
    String name;
    Gender gender;
    Calabash(String name,Gender gender){
        this.name=name;
        this.gender=gender;
    }


    @Override
    public int compareTo(Calabash o) {
        return name.compareTo(o.name);
    }

    public void change(Calabash c){
        name = c.name;
        gender = c.gender;
    }

    public String act(){
        return "I am just a ordinary Calabash!";
    }
}

class CalabashFire extends Calabash{
    CalabashFire(){
        super();
    }
    CalabashFire(String name,Gender gender){
        super(name,gender);
    }

    @Override
    public String act() {
        return "I can spray fire!";
    }
}

class CalabashWater extends Calabash{
    CalabashWater(){
        super();
    }
    CalabashWater(String name,Gender gender){
        super(name,gender);
    }

    @Override
    public String act(){
       return "I can spit Water!";
    }
}



