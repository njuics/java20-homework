/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:51:31
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-15 12:34:20
 */
package hw9;
import java.util.Comparator;

public class AscCmp<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return a.compareTo(b);
    }
}