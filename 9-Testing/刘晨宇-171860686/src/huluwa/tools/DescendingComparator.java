package huluwa.tools;

import java.util.Comparator;

import huluwa.characters.Character;

/**
 * 降序比较器，能够比较两个角色的名字，将字典序中靠前的排在靠后的位置
 */
public class DescendingComparator implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        return -o1.getName().compareTo(o2.getName());
    }
}
