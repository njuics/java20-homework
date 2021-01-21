package cn.edu.nju.zq.homework8;

public class Creature{
    protected String name;
    protected Gender gender;
    Creature(String name, Gender gender) {
        this.name=name;
        this.gender=gender;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
}