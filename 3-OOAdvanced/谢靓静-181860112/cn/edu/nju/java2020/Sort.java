package cn.edu.nju.java2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Sort {
    void sort(CartonCharacter[] characters);

    default void shuffle(CartonCharacter[] characters) {
        List huluList = new ArrayList();
        for (int i = 0; i < characters.length; ++i) {
            huluList.add(characters[i]);
        }
        Collections.shuffle(huluList);
        for (int i = 0; i < huluList.size(); ++i) {
            characters[i] = (Hulu) huluList.get(i);
        }
    }
}
