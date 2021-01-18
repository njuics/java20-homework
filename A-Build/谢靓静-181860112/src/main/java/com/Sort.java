package com;

import java.util.ArrayList;
import java.util.Collections;

public interface Sort <T extends Comparable<? super T>>{
    void sort(ArrayList<T> characters, int option);//0：乱序，1：正序，2：倒序

    default void shuffle(ArrayList<T> characters) {
        Collections.shuffle(characters);
    }
}
