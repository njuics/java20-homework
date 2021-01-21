package cn.edu.nju.zq.homework9;

import java.util.Comparator;
import java.util.Random;

public class RandomComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
      Random random = new Random();
      return random.nextInt(3) - 1;
    }
  }