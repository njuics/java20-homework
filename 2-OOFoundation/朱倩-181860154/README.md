# 2-OOFoundation homework

首先，将预期得到的排序结果存储在`expected`数组中，该数组依次记录了老大至老七应该处于的队伍位置。这样要修改排序算法时，只需修改该数组即可。

## 一、orchestration

### 1. 排序思路

这样的排序中有一个指挥者，可以根据七个葫芦娃应该站的位置直接进行调度。例如老大应该站第一个，则在葫芦娃队伍中找到老大，如果老大没有处于他应该在的位置，则告诉老大目前所处的位置和他应该在的位置（这里是第一个），让他和第一个位置的葫芦娃调换顺序。依次类推，对老二老三至老七进行相同的处理，得到排序后的葫芦娃序列。

### 2. 类的设计

```java
class HuLuWa {
  String name;//葫芦娃名字
  HuLuWa();//构造函数
  HuLuWa(String name);//构造函数
  HuLuWa(HuLuWa h);//拷贝构造函数
  void exchange(HuLuWa[] queue,int pos,int target);//pos位置的葫芦娃和target位置的葫芦娃交换位置
}

public class Grandpa {
  HuLuWa[] queue;//葫芦娃队列
  int[] expected;//期望的排序方法
  Grandpa(int[] expected);//构造函数（记录传入的expected数组并调用initQueue
  void initQueue();//初始化队列，即让葫芦娃随机站队
  void orchestrationSort();//在爷爷的指导下对葫芦娃排序
  void printQueue();//从前往后打印队伍的成员名字
  public static void main(String[] args) {
    int[] expected = { 0, 1, 2, 3, 4, 5, 6 };//指定排序算法
    Grandpa grandpa = new Grandpa(expected);
    System.out.println("Original queue:");
    grandpa.printQueue();//打印初始葫芦娃队列
    grandpa.orchestrationSort();//
    System.out.println("After sorting:");
    grandpa.printQueue();//打印排序后的葫芦娃队列
  }
}


```



## 二、choreography

### 1. 排序思路

通过葫芦娃之间的协作完成，此时没有指挥者告知葫芦娃如何排队，因此在`HuLuWa`类中增加`rank`（该葫芦娃应该处于的位置），`pos`（该葫芦娃目前处于的位置）两个数据成员。排序时老大至老七如果发现自己不在应该在的位置，则通过与兄弟交换位置的方式排到自己应该处于的位置，依次找到位置后完成排序。

### 2. 类的设计

```java
class HuLuWa {
  String name;//名字
  int rank;//应该所处的位置
  int pos;//目前所处的位置
  HuLuWa();//构造函数
  HuLuWa(String name, int pos, int rank);//构造函数
  HuLuWa(HuLuWa h);//拷贝构造函数
  void findPos(HuLuWa[] queue);//如果发现自己不在应该所处的位置，则与该位置上的兄弟交换

public class HuLuWaQueue {
  HuLuWa[] queue;//
  int[] expected;//
  HuLuWaQueue(int[] expected);//构造函数（记录传入的expected数组并调用initQueue
  void initQueue();//初始化队列，即让葫芦娃随机站队
  void choreographySort();//葫芦娃们自己排序
  void printQueue();//从前往后打印队伍的成员名字
  public static void main(String[] args) {
    int[] expected = { 0, 1, 2, 3, 4, 5, 6 };//指定排序算法
    HuLuWaQueue queue = new HuLuWaQueue(expected);
    System.out.println("Original queue:");
    queue.printQueue();//打印初始葫芦娃队列
    queue.choreographySort();
    System.out.println("After sorting:");
    queue.printQueue();//打印排序后的葫芦娃队列
  }
}

```



# 运行结果

## 1. orchestration

运行指令：

```
javac -encoding UTF8 Grandpa.java
java Grandpa
```

输出结果：(每次初始队列不一样，以其中一个为例)

```
Original queue:
老七 老三 老二 老大 老六 老五 老四
After sorting:
老大 老二 老三 老四 老五 老六 老七
```



## 2. choreography

运行指令：

```
javac -encoding UTF8 HuLuWaQueue.java
java HuLuWaQueue
```

输出结果：(每次初始队列不一样，以其中一个为例)

```
Original queue:
老四 老七 老大 老三 老六 老二 老五
After sorting:
老大 老二 老三 老四 老五 老六 老七
```

