package model;
import java.lang.Comparable;

public class Calabash implements Comparable<Calabash>{
    private String name;
    private int age;

    Calabash(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void reportNum(){
        System.out.print(this.name + " ");
    }
    
    public int getAge(){
        return this.age;
    }

    @Override
    public int compareTo(Calabash bro){
        return bro.getAge() - this.age;
    }

    public void swapWith(Calabash bro){
        String tmp_name = this.name;
        this.name = bro.name;
        bro.name = tmp_name;
        int tmp_age = this.age;
        this.age = bro.age;
        bro.age = tmp_age;
    }
}
