package cn.edu.nju.zq.homework9;

import java.util.Comparator;

public class DescComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
      return t2.compareTo(t1);
    }
  }