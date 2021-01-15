package huluwa.tools;

import java.util.ArrayList;
import java.util.List;

import huluwa.characters.Character;
import huluwa.characters.Gender;

/**
 * 性别过滤器，用来分割角色的队列，生成不同性别角色的子队列
 */
public class GenderFilter {
    static public <T extends Character> List<T> filter(List<T> list, Gender gender) {
        ArrayList<T> subList = new ArrayList<>();
        for(T elem: list) {
            if(elem.getGender() == gender) {
                subList.add(elem);
            }
        }
        return subList;
    }
}
