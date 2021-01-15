package cn.edu.nju.java2020.homework8;

import java.util.ArrayList;
import java.util.Collections;

public class Grandpa extends KindCharacter<Grandpa> implements Sort<Hulu> {

    public Grandpa() {
        super("爷爷", cn.edu.nju.java2020.homework8.gender.MALE);
    }

    @Override
    public void sort(ArrayList<Hulu> huluBrothers, int option) {
        if(option == 0){
            shuffle(huluBrothers);
        }
        else {
            Collections.sort(huluBrothers);
            if (option == 2) {
                Collections.reverse(huluBrothers);
            }
        }
        ArrayList<Hulu> female = new ArrayList<>(), male = new ArrayList<>();
        for(int i = 0; i < huluBrothers.size(); ++i){
            if (huluBrothers.get(i).gender == gender.FEMALE){
                female.add(huluBrothers.get(i));
            }
            else{
                male.add(huluBrothers.get(i));
            }
        }
        System.out.print("女生队伍：");
        for(int i = 0; i < female.size(); ++i) {
            System.out.print(female.get(i).name);
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("男生队伍：");
        for(int i = 0; i < male.size(); ++i) {
            System.out.print(male.get(i).name);
            System.out.print(" ");
        }
        System.out.println();
    }
}
