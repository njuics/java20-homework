import java.util.Comparator;
public class CharacterDecendingComparator implements Comparator<Character>{
    public int compare(Character o1, Character o2){
        return -o1.compareTo(o2);
    }
    public boolean equals(Object obj){
        throw new UnsupportedOperationException();
    }
}