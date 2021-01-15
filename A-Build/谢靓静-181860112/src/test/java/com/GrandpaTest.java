package com;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrandpaTest {
    Grandpa grandpa;
    ArrayList<Hulu> huluBrothers1;
    ArrayList<Hulu> huluBrothers2;
    ArrayList<Hulu> huluBrothers3;

    public GrandpaTest(){
        this.grandpa = new Grandpa();
        huluBrothers1 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("f", gender.FEMALE));
                add(new Hulu("b", gender.MALE));
                add(new Hulu("g", gender.FEMALE));
                add(new Hulu("c", gender.MALE));
                add(new Hulu("h", gender.FEMALE));
                add(new Hulu("d", gender.MALE));
                add(new Hulu("i", gender.FEMALE));
                add(new Hulu("e", gender.MALE));
                add(new Hulu("j", gender.FEMALE));
            }
        };
        huluBrothers2 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("b", gender.FEMALE));
            }
        };
        huluBrothers3 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("f", gender.MALE));
                add(new Hulu("b", gender.MALE));
                add(new Hulu("g", gender.MALE));
                add(new Hulu("c", gender.MALE));
                add(new Hulu("h", gender.MALE));
                add(new Hulu("d", gender.MALE));
                add(new Hulu("i", gender.MALE));
                add(new Hulu("e", gender.MALE));
                add(new Hulu("j", gender.MALE));
            }
        };
    }

    @Test
    public void ascSort() {
        grandpa.sort(huluBrothers1, 1);
        grandpa.sort(huluBrothers2, 1);
        grandpa.sort(huluBrothers3, 1);
        boolean flag = true;
        for(int i = 0; i < 9; ++i){
            if(huluBrothers1.get(i).name.compareTo(huluBrothers1.get(i+1).name)>0 ||
                    huluBrothers2.get(i).name.compareTo(huluBrothers2.get(i+1).name)>0 ||
                    huluBrothers3.get(i).name.compareTo(huluBrothers3.get(i+1).name)>0){
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void desSort() {
        grandpa.sort(huluBrothers1, 2);
        grandpa.sort(huluBrothers2, 2);
        grandpa.sort(huluBrothers3, 2);
        boolean flag = true;
        for(int i = 0; i < 9; ++i){
            if(huluBrothers1.get(i).name.compareTo(huluBrothers1.get(i+1).name)<0 ||
                    huluBrothers2.get(i).name.compareTo(huluBrothers2.get(i+1).name)<0 ||
                    huluBrothers3.get(i).name.compareTo(huluBrothers3.get(i+1).name)<0){
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void randSort() {
        ArrayList<Hulu> tmp1 = new ArrayList<>(), tmp2 = new ArrayList<>(), tmp3 = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            Hulu a = huluBrothers1.get(i), b = huluBrothers2.get(i), c = huluBrothers3.get(i);
            tmp1.add(a);
            tmp2.add(b);
            tmp3.add(c);
        }

        grandpa.sort(huluBrothers1, 0);
        grandpa.sort(huluBrothers2, 0);
        grandpa.sort(huluBrothers3, 0);

        boolean flag1 = false, flag2 = false, flag3 = false;
        for(int i = 0; i < 10; ++i){
            if(huluBrothers1.get(i).name.compareTo(tmp1.get(i).name) != 0){
                flag1 = true;
            }
            if(huluBrothers2.get(i).name.compareTo(tmp2.get(i).name) != 0){
                flag2 = true;
            }
            if(huluBrothers3.get(i).name.compareTo(tmp3.get(i).name) != 0){
                flag3 = true;
            }
        }
        assertTrue(flag1 || flag2 || flag3);
    }
}