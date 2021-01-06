/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:52:05
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-05 15:24:13
 */
package hw9;
import java.util.Comparator;
class DescCmp<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return b.compareTo(a);
    }
}