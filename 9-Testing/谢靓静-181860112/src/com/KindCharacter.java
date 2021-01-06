package com;

public abstract class KindCharacter<T> {
    protected String name;
    protected gender gender;
    protected int id;
    static private int count = 0;
    KindCharacter(String name, gender gender){
        this.name = name;
        this.gender = gender;
        this.id = count;
        count++;
    }
    public KindCharacter<T> get(){
        return this;
    }
}
