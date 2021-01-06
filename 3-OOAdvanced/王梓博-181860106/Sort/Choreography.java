/*
 * @Author: zb-nju
 * @Date: 2020-09-26 23:03:52
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 00:16:59
 */
package Sort;
import Human.*;
public class Choreography extends SortBase {
    public void run(CalabashBoy[] calabashBoys, Grandpa grandpa){
        System.out.println("choreography:");
        System.out.println();

        shuffle(calabashBoys);
        System.out.println("排序前：");
        for(CalabashBoy c:calabashBoys)
            c.report();

        System.out.println();
        sort(calabashBoys,grandpa);
        System.out.println();
        System.out.println("排序后：");
        for(CalabashBoy c:calabashBoys)
            c.report();
    }

    public void sort(CalabashBoy[] calabashBoys, Grandpa grandpa){
        for(int i=calabashBoys.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(calabashBoys[j].cmp(calabashBoys[j+1])){
                    calabashBoys[j].swap(calabashBoys[j+1]);
                    System.out.println(calabashBoys[j].getName()
                                    + "和"
                                    + calabashBoys[j+1].getName()
                                    + "换了位置"
                    );
                }
            }
        }
    }
}
