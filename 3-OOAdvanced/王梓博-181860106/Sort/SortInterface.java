/*
 * @Author: zb-nju
 * @Date: 2020-09-26 19:27:39
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 10:53:12
 */
package Sort;

import Human.*;

public interface SortInterface {
    public void shuffle(CalabashBoy[] calabashBoys);
    public void run(CalabashBoy[] calabashBoys, Grandpa grandpa);
    public void sort(CalabashBoy[] calabashBoys, Grandpa grandpa);
}
