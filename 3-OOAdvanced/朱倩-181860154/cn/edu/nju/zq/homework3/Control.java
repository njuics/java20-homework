package cn.edu.nju.zq.homework3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Control {

  private static void initQueue(List<HuLuWa> queue) {
    queue.clear();
    for (int i = 1; i <= 7; i++) {
      String name = "";
      switch (i) {
        case 1:
          name = "老大";
          break;
        case 2:
          name = "老二";
          break;
        case 3:
          name = "老三";
          break;
        case 4:
          name = "老四";
          break;
        case 5:
          name = "老五";
          break;
        case 6:
          name = "老六";
          break;
        case 7:
          name = "老七";
          break;
      }
      queue.add(new HuLuWa(name, i));
    }
    Random r = new Random();
    Collections.shuffle(queue, r);
  }

  private static void printQueue(List<HuLuWa> queue) {
    for (HuLuWa huluwa : queue) {
      huluwa.tellName();
    }
    System.out.println();
  }

  private static void sort(Sort sort, Grandpa grandpa, List<HuLuWa> queue) {
    System.out.println("----------orchestration----------");
    initQueue(queue);
    System.out.println("Original queue:");
    printQueue(queue);
    sort.orchestration(grandpa, queue);
    System.out.println("After sorting:");
    printQueue(queue);
    System.out.println();
    System.out.println("----------choreography----------");
    initQueue(queue);
    System.out.println("Original queue:");
    printQueue(queue);
    sort.choreography(queue);
    System.out.println("After sorting:");
    printQueue(queue);
  }

  public static void main(String[] args) {
    List<HuLuWa> queue = new ArrayList<>();
    Grandpa grandpa = new Grandpa();
    BubbleSort bubblesort = new BubbleSort();
    sort(bubblesort,grandpa,queue);
  }
}
