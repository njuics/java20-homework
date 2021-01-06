package homework9;

import java.util.Random;

enum Gender {
    MALE, FEMALE;
    public static Gender get(){
        Random r = new Random();
        return values()[r.nextInt(2)];
    }
};

abstract class Creature{
    String name;
    abstract String getName();

};

public class HuluWa extends Creature implements Comparable<HuluWa>{
    private int seniority;
    private int pos;
    private Gender gender;
    HuluWa(int seniority, String name, int pos, Gender gender){
        this.seniority = seniority;
        this.name = name;
        this.pos = pos;
        this.gender = gender;
    }

    public static String genRandomName(){
        Random r = new Random();
        int namelen = r.nextInt(4) + 1;
        String name = "";
        for(int i = 0; i < namelen; ++i){
            name += (char)(r.nextInt(26) + 'a');
        }
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    public int getPos() {
        return pos;
    }

    public String getName() {return name;}

    public Gender getGender() {
        return gender;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }


    public void tellName(){
        System.out.print(this.name + " ");
    }

    @Override
    public int compareTo(HuluWa h2){
        return name.compareTo(h2.getName());
    }
}