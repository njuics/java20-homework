package huluwa.tools;

import java.util.Comparator;

import huluwa.characters.Character;

/**
 * 随机序比较器，虽说是“随机序”，但如果直接返回随机数，是违反Comparator的Contract的，
 * 因此它实际上是比较两个角色的姓名的hashCode的比较器
 */
public class RandomComparator implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        return o1.getName().hashCode() - o2.getName().hashCode();
    }
}
