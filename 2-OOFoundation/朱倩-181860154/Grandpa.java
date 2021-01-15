import java.util.Scanner;

class HuLuWa {
  String name;

  HuLuWa() {
    name = "";
  }

  HuLuWa(String name) {
    this.name = name;
  }

  HuLuWa(HuLuWa h) {
    this.name = h.name;
  }

  void exchange(HuLuWa[] queue,int pos,int target) { // exchange
    HuLuWa temp = queue[target];
    queue[target] = this;
    queue[pos] = temp;
  }
}

public class Grandpa {
  HuLuWa[] queue;
  int[] expected;

  Grandpa(int[] expected) {
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
          queue[i] = new HuLuWa("老大");
          break;
        case 2:
          queue[i] = new HuLuWa("老二");
          break;
        case 3:
          queue[i] = new HuLuWa("老三");
          break;
        case 4:
          queue[i] = new HuLuWa("老四");
          break;
        case 5:
          queue[i] = new HuLuWa("老五");
          break;
        case 6:
          queue[i] = new HuLuWa("老六");
          break;
        case 7:
          queue[i] = new HuLuWa("老七");
          break;
      }
    }
  }

  void orchestrationSort() { //under grandpa's guidance
    String[] names={"老大","老二","老三","老四","老五","老六","老七"};
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 7; j++) {
        if (queue[j].name == names[i]&&j!=expected[i]) {
          queue[j].exchange(queue,j,expected[i]);
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
    Grandpa grandpa = new Grandpa(expected);
    System.out.println("Original queue:");
    grandpa.printQueue();
    grandpa.orchestrationSort();
    System.out.println("After sorting:");
    grandpa.printQueue();
  }
}

