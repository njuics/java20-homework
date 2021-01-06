package cn.edu.xiaoyu;

public class Calabash implements Comparable<Calabash>{
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
}
