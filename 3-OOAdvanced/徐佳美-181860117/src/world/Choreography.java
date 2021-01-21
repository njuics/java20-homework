
package world;


import object.*;
import sortset.*;

public class Choreography implements Sortset {
    public Choreography(){} //default

    public  void run(String[] args) {
        Grandpa grandpa = new Grandpa();
        Calabash grandsons[] = grandpa.createCalabash();
        System.out.println("Choreography");
        randLine(grandsons);
        System.out.println("排序前  ");
        report(grandsons);
        newSort(grandsons);
        System.out.println("排序后  ");
        report(grandsons);
    }

    public void newSort(Calabash grandsons[]) {
        int len = grandsons.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (grandsons[i].compare(grandsons[j])) {
                    grandsons[i].swap(grandsons[j]);
                }
            }
        }
    }


};