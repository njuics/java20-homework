package testing.src;

import java.util.Comparator;



abstract class CreatureComparator<T extends Creature> implements Comparator<T> {
     abstract public int compare(T creature1,T creature2);
}

public class Creature {
    //后续可能会添加生命值，法术值，攻击力等元素，当前还未涉及
     protected String name;

     public String getName(){
         return this.name;
     }
}
