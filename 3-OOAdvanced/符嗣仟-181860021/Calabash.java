package com.company;

public class Calabash {
    public String name;
    public int pos;

    Calabash(String n,int p){
        this.name = n;
        this.pos = p;
    }
    Calabash(){
        name = null;
        pos = 0;
    }

    boolean compare(Calabash c1) {
        return this.pos>c1.pos;
    }

    void NumberOff(){
        //报数
        System.out.print(name+" ");
    }
}
