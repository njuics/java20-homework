/*
 * @Author: zb-nju
 * @Date: 2020-09-26 14:50:29
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 00:16:36
 */
package Sort;
import Human.*;
import java.util.Random;
public abstract class SortBase implements SortInterface{
    public void shuffle(CalabashBoy[] calabashBoys){
        Random random = new Random();
        for(int i=0;i<calabashBoys.length;i++){
            int r = random.nextInt(7);
            if(r!=i)
                calabashBoys[i].swap(calabashBoys[r]);
        }
    }
    
    public void run(CalabashBoy[] calabashBoys, Grandpa grandpa);
    public void sort(CalabashBoy[] calabashBoys, Grandpa grandpa);

}
