/*
 * @Author: zb-nju
 * @Date: 2020-09-26 23:16:17
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 11:07:25
 */
import Human.*;
import Sort.*;
public class Homework3 {
    public static void main(String[] args) {
        CalabashBoy[] calabashBoys = new CalabashBoy[]{
            new CalabashBoy("大娃", 1),
            new CalabashBoy("二娃", 2),
            new CalabashBoy("三娃", 3),
            new CalabashBoy("四娃", 4),
            new CalabashBoy("五娃", 5),
            new CalabashBoy("六娃", 6),
            new CalabashBoy("七娃", 7)
        };
        CalabashBoy.reportNum();
        Grandpa grandpa = new Grandpa();
        SortBase[] sort = new SortBase[]{
            new Orchestration(),
            new Choreography()
        };
        for(SortBase s:sort){
            s.run(calabashBoys,grandpa);
        }
    }
}
