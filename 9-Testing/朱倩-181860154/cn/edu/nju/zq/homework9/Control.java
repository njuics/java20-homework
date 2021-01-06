package cn.edu.nju.zq.homework9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Control{

  private static void initQueue(List<HuLuWa> queue, int num) {
    queue.clear();
    for (int i = 0; i < num; i++) {
      queue.add(HuLuWa.getNewHuluwa());
    }
  }

  private static <T> void printQueue(List<T> queue) {
    for (T h: queue) {
      System.out.print(h);
    }
    System.out.println();
  }

  public static <T extends Creature&Comparable<T>> void ascSort(List<T> queue) {
    Collections.sort(queue, new AscComparator());
  }

  public static <T extends Creature&Comparable<T>> void descSort(List<T> queue) {
    Collections.sort(queue, new DescComparator());
  }

  public static <T extends Creature&Comparable<T>> void randomSort(List<T> queue) {
    Collections.sort(queue, new RandomComparator());
  }

  private static <T extends Creature&Comparable<T>> void showSort(List<T> queue) {
    System.out.println("Original queue:");
    printQueue(queue);
    System.out.println("----------Total sort----------");
    ascSort(queue);
    System.out.println("After sorting in ascending order:");
    printQueue(queue);
    descSort(queue);
    System.out.println("After sorting in descending order:");
    printQueue(queue);
    randomSort(queue);
    System.out.println("After sorting in random order:");
    printQueue(queue);
    System.out.println();
    
    List<T> maleHuluwas = new ArrayList<>();
    List<T> femaleHuluwas = new ArrayList<>();
    for(T t:queue) {
      if (t.getGender() == Gender.MALE){
        maleHuluwas.add(t);
      }
      else{
        femaleHuluwas.add(t);
      }
    }
    System.out.println("----------Male sort----------");
    ascSort(maleHuluwas);
    System.out.println("After sorting in ascending order:");
    printQueue(maleHuluwas);
    descSort(maleHuluwas);
    System.out.println("After sorting in descending order:");
    printQueue(maleHuluwas);
    randomSort(maleHuluwas);
    System.out.println("After sorting in random order:");
    printQueue(maleHuluwas);
    System.out.println();

    System.out.println("----------Female sort----------");
    ascSort(femaleHuluwas);
    System.out.println("After sorting in ascending order:");
    printQueue(femaleHuluwas);
    descSort(femaleHuluwas);
    System.out.println("After sorting in descending order:");
    printQueue(femaleHuluwas);
    randomSort(femaleHuluwas);
    System.out.println("After sorting in random order:");
    printQueue(femaleHuluwas);
  }

  public static void main(String[] args) {
    List<HuLuWa> queue = new ArrayList<>();
    int num = 10;
    initQueue(queue, num);
    showSort(queue);
  }
}
