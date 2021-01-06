/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:51:31
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-23 15:22:40
 */
package com.nju.cs.wzb.hwA;
import java.util.Comparator;

public class AscCmp<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return a.compareTo(b);
    }
}