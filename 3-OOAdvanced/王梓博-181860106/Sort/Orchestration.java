/*
 * @Author: zb-nju
 * @Date: 2020-09-26 23:11:55
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 00:17:24
 */
package Sort;
import Human.*;
public class Orchestration extends SortBase{
    public void run(CalabashBoy[] calabashBoys, Grandpa grandpa){
        System.out.println("orchestration:");
        System.out.println();

        shuffle(calabashBoys);
        System.out.println("排序前：");
        for(CalabashBoy c:calabashBoys)
            c.report();

        System.out.println();
        sort(calabashBoys, grandpa);
        System.out.println();
        System.out.println("排序后：");
        for(CalabashBoy c:calabashBoys)
            c.report();
    }

    public void sort(CalabashBoy[] calabashBoys, Grandpa grandpa){
        grandpa.sort(calabashBoys);
    }
}
