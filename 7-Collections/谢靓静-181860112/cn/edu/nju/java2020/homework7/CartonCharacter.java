package cn.edu.nju.java2020.homework7;

public abstract class CartonCharacter {
    protected String name;
    protected gender gender;
    protected int id;
    static private int count = 0;
    CartonCharacter(String name, gender gender){
        this.name = name;
        this.gender = gender;
        this.id = count;
        count++;
    }
}
