package model;
import java.lang.Comparable;

public class Calabash implements Comparable<Calabash>{
    private String name;
    private boolean gender;

    public Calabash(String name,boolean gender){
        this.name = name;
        this.gender = gender;
    }

    public void reportName(){
        System.out.println("Name: " + name + " Gender: " + (gender ? "male" : "female"));
    }
    
    public boolean getGender(){
        return this.gender;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Calabash bro){
        return this.name.compareTo(bro.getName());
    }

    public void swapWith(Calabash bro){
        String tmp_name = this.name;
        this.name = bro.name;
        bro.name = tmp_name;
        boolean tmp_gender = this.gender;
        this.gender = bro.gender;
        bro.gender = tmp_gender;
    }
}
