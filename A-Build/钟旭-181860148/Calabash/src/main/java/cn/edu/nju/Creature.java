package cn.edu.nju;

import java.util.Random;



public class Creature implements Comparable<Creature>{

    enum Gender{
        MALE, FEMALE
    };

    protected String name;
    protected Gender gender;
    Creature(){
        Random r = new Random();
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        final int length = 3;
        this.name = new String();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            int index = r.nextInt(26);
            sb.append(alphabet.charAt(index));
        }
        this.name = sb.toString();
        
        int gen = r.nextInt(2);
        if(gen==0)this.gender=Gender.MALE;
        else this.gender=Gender.FEMALE;
    }
    
    Creature(String s){
        this();
        this.name=s;
    }


    Creature(String s,int gender1){
        this.name=s;
        if(gender1==0)this.gender=Gender.FEMALE;
        else this.gender=Gender.MALE;
    }

    public boolean ismale(){
        return this.gender==Gender.MALE;
    }
    
    public boolean isfemale(){
        return this.gender==Gender.FEMALE;
    }

    public String getName(){
        return this.name;
    }
     
    @Override
    public String toString(){
        return this.name+" "+this.gender;
    }

    @Override
    public int compareTo(Creature c){
        return this.name.compareTo(c.name);
    }
    
}