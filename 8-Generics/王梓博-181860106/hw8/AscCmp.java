/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:51:31
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-05 15:24:53
 */
package hw8;
import java.util.Comparator;

public class AscCmp<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return a.compareTo(b);
    }
}