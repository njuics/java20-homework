package cn.edu.nju.zq.homework8;

import java.util.Comparator;

public class AscComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
      return t1.compareTo(t2);
    }
  }

  
