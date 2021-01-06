

package object;
import sortset.*;

public class Grandpa extends Object implements Sortset {
    public Grandpa(){}  //default

    public Calabash[] createCalabash() {
        Calabash[] grandsons = new Calabash[] {
            new Calabash("大娃", 7),
            new Calabash("二娃", 6), 
            new Calabash("三娃", 5),
            new Calabash("四娃", 4), 
            new Calabash("五娃", 3), 
            new Calabash("六娃", 2),
            new Calabash("七娃", 1), 
        };
        return grandsons;
    }

    public void sortHulu(){
        Calabash grandsons[] = createCalabash();
        randLine(grandsons);
        System.out.println("排序前  ");
        report(grandsons);
        newSort(grandsons);
        System.out.println("排序后  ");
        report(grandsons);
    }

};