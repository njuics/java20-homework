package cn.edu.nju.java2020.homework7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Sort <T extends CartonCharacter>{
    void sort(ArrayList<T> characters, int option);//0：乱序，1：正序，2：倒序

    default void shuffle(ArrayList<T> characters) {
        Collections.shuffle(characters);
    }
}
