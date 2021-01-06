import java.util.Scanner;

class HuLuWa {
  String name;
  int rank;
  int pos;

  HuLuWa() {
    name = "";
    pos = 0;
    rank = 0;
  }

  HuLuWa(String name, int pos, int rank) {
    this.name = name;
    this.pos = pos;
    this.rank = rank;
  }

  HuLuWa(HuLuWa h) {
    this.name = h.name;
    this.rank = h.rank;
    this.pos = h.pos;
  }

  void findPos(HuLuWa[] queue) { //find the right position for self and exchange
    if (rank != pos) {
      int r = rank;
      int p = pos;
      this.pos = r;
      queue[rank].pos = p;
      HuLuWa temp = queue[rank];
      queue[r] = this;
      queue[p] = temp;
    }
  }
}

public class HuLuWaQueue {
  HuLuWa[] queue;
  int[] expected;

  HuLuWaQueue(int[] expected) {
    queue = new HuLuWa[7];
    this.expected = new int[7];
    for (int i = 0; i < 7; i++) {
      this.expected[i] = expected[i];
    }
    initQueue();
  }

  void initQueue() {
    Scanner in = new Scanner(System.in);
    int k = 7;
    int n = 7;
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) numbers[i] = i + 1;
    int[] result = new int[k]; //initial order
    for (int i = 0; i < result.length; i++) {
      int r = (int) (Math.random() * n);
      result[i] = numbers[r];
      numbers[r] = numbers[n - 1];
      n--;
    }
    for (int i = 0; i < 7; i++) {
      switch (result[i]) {
        case 1:
          queue[i] = new HuLuWa("老大", i, expected[0]);
          break;
        case 2:
          queue[i] = new HuLuWa("老二", i, expected[1]);
          break;
        case 3:
          queue[i] = new HuLuWa("老三", i, expected[2]);
          break;
        case 4:
          queue[i] = new HuLuWa("老四", i, expected[3]);
          break;
        case 5:
          queue[i] = new HuLuWa("老五", i, expected[4]);
          break;
        case 6:
          queue[i] = new HuLuWa("老六", i, expected[5]);
          break;
        case 7:
          queue[i] = new HuLuWa("老七", i, expected[6]);
          break;
      }
    }
  }

  void choreographySort() { //through Huluwas' cooperation with each other
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (queue[j].rank == expected[i]) {
          queue[j].findPos(queue);
        }
      }
    }
  }

  void printQueue() {
    for (int i = 0; i < 7; i++) {
      System.out.print(queue[i].name);
      System.out.print(" ");
    }
    System.out.print("\n");
  }

  public static void main(String[] args) {
    int[] expected = { 0, 1, 2, 3, 4, 5, 6 };
    HuLuWaQueue queue = new HuLuWaQueue(expected);
    System.out.println("Original queue:");
    queue.printQueue();
    queue.choreographySort();
    System.out.println("After sorting:");
    queue.printQueue();
  }
}
