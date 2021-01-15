package com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HuluTest {
    ArrayList<Hulu> huluBrothers1;
    ArrayList<Hulu> huluBrothers2;
    ArrayList<Hulu> huluBrothers3;

    @BeforeEach
    void setUp(){
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

    @AfterEach
    public void tearDown(){
        this.huluBrothers1 = null;
        this.huluBrothers2 = null;
        this.huluBrothers3 = null;
    }

    @Test
    void ascSort() {
        huluBrothers1.get(0).sort(huluBrothers1, 1);
        huluBrothers2.get(0).sort(huluBrothers2, 1);
        huluBrothers3.get(0).sort(huluBrothers3, 1);
        boolean flag = true;
        for(int i = 0; i < 9; ++i){
            if (huluBrothers1.get(i).name.compareTo(huluBrothers1.get(i + 1).name) > 0 ||
                    huluBrothers2.get(i).name.compareTo(huluBrothers2.get(i + 1).name) > 0 ||
                    huluBrothers3.get(i).name.compareTo(huluBrothers3.get(i + 1).name) > 0) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    void desSort() {
        huluBrothers1.get(0).sort(huluBrothers1, 2);
        huluBrothers2.get(0).sort(huluBrothers2, 2);
        huluBrothers3.get(0).sort(huluBrothers3, 2);
        boolean flag = true;
        for(int i = 0; i < 9; ++i){
            if (huluBrothers1.get(i).name.compareTo(huluBrothers1.get(i + 1).name) < 0 ||
                    huluBrothers2.get(i).name.compareTo(huluBrothers2.get(i + 1).name) < 0 ||
                    huluBrothers3.get(i).name.compareTo(huluBrothers3.get(i + 1).name) < 0) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    void randSort() {
        ArrayList<Hulu> tmp1 = new ArrayList<>(), tmp2 = new ArrayList<>(), tmp3 = new ArrayList<>();
        for(int i = 0; i < 10; ++i){
            tmp1.add(huluBrothers1.get(i));
            tmp2.add(huluBrothers2.get(i));
            tmp3.add(huluBrothers3.get(i));
        }

        huluBrothers1.get(0).sort(huluBrothers1, 0);
        huluBrothers2.get(0).sort(huluBrothers2, 0);
        huluBrothers3.get(0).sort(huluBrothers3, 0);

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
        assertTrue(flag1 && flag2 && flag3);
    }
}