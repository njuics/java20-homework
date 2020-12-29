package com;

import java.util.ArrayList;
import java.util.Collections;

public class Grandpa extends KindCharacter<Grandpa> implements Sort<Hulu> {

    public Grandpa() {
        super("爷爷", com.gender.MALE);
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
        for (Hulu huluBrother : huluBrothers) {
            if (huluBrother.gender == com.gender.FEMALE) {
                female.add(huluBrother);
            } else {
                male.add(huluBrother);
            }
        }
        System.out.print("女生队伍：");
        for (Hulu hulu : female) {
            System.out.print(hulu.name);
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("男生队伍：");
        for (Hulu hulu : male) {
            System.out.print(hulu.name);
            System.out.print(" ");
        }
        System.out.println();
    }
}
