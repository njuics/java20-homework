# homework2 OOFoundation

### 1. 设计思路
运用面向对象编程方法，设计三个模块四个类。用数组存储Hulu对象。与葫芦娃相关的类实现choreography排序功能，与爷爷相关的类实现orchestration功能。为保证排序算法可以替换，在choreography和orchestration方法中单独调用排序方法，更改排序算法，只需定义新的排序方法并替换原本的。在排序方法中调用单独定义的比较方法，要更改排序策略，只需更换新的比较方法。此替换过程满足了代码改动尽可能小的原则。
### 2. 类和模块划分
#### (1) 葫芦娃模块 (HuluList.java) <br>
在葫芦娃模块中定义了两个类: **Hulu类**和**HuluList类**。<br>
其中Hulu对象描述了单个葫芦娃的特征，包含私有成员变量name和rank，分别作为报数和排序依据。同时，在Hulu类中定义了比较方法compare，用于单个葫芦娃比较自身与作为参数传入的葫芦娃的rank值的大小关系，并返回比较结果。 <br>
```java
class Hulu {
    private String name;
    private int rank;
    public Hulu(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
    public boolean compare(Hulu a) {return this.rank > a.rank;}

    public int getRank() {return rank;}

    public String getName() {return name;}
}
```
HuluList对象用一个Hulu类型的数组存储了目前存在的全部葫芦娃，并定义了countOff(报数)、shuffle(随机打乱葫芦娃队列)、swap(交换两个葫芦娃在队列中的位置)、choreography(基于葫芦娃彼此两两比较)以及所用到的冒泡排序方法。其中，为了模拟葫芦娃两两比较，移动直至确定最终位置的过程，排序采用冒泡排序算法。
```java
public class HuluList {
    public Hulu[] huluBrothers;
    
    public HuluList() {
        huluBrothers = new Hulu[]{
                new Hulu("老大", 1), new Hulu("老二", 2),
                new Hulu("老三", 3), new Hulu("老四", 4),
                new Hulu("老五", 5), new Hulu("老六", 6),
                new Hulu("老幺", 7)};
    }

    public void countOff() {
        for (int i = 0; i < huluBrothers.length; ++i) {System.out.print(huluBrothers[i].getName() + " ");}
        System.out.println();
    }

    public void shuffle() {
        List huluList = new ArrayList();
        for (int i = 0; i < huluBrothers.length; ++i) {huluList.add(huluBrothers[i]);}
        Collections.shuffle(huluList);
        for (int i = 0; i < huluList.size(); ++i) {huluBrothers[i] = (Hulu) huluList.get(i);}
        countOff();
    }

    public void swap(int i, int j) {
        Hulu temp = new Hulu("temp", 0);
        temp = huluBrothers[i];
        huluBrothers[i] = huluBrothers[j];
        huluBrothers[j] = temp;
    }

    private void bubbleSort() {
        for (int i = 0; i < huluBrothers.length - 1; ++i) {
            for (int j = 0; j < huluBrothers.length - 1 - i; ++j) {
                if (huluBrothers[j].compare(huluBrothers[j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void choreography() {
        bubbleSort();
        countOff();
        System.out.println();
    }
}
```
#### (2) 爷爷模块（Grandpa.java）
在Grandpa类中定义了一个私有的HuluList静态成员变量，用于存储爷爷控制下的七个葫芦娃。定义了shuffle(随机打乱序列)，orchestration(通过爷爷对象对葫芦娃数组进行排序)及其对应的选择排序方法。其中，为了模拟爷爷发出指令，规定葫芦娃站位的过程，排序采用了选择排序算法。
```java
public class Grandpa {
    private static HuluList huluSons;

    public Grandpa() {huluSons = new HuluList();}

    public void shuffle() {huluSons.shuffle();}

    public void orchestration() {
        selectionSort();
        huluSons.countOff();
        System.out.println();
    }

    private void selectionSort() {
        for (int i = 0; i < huluSons.huluBrothers.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < huluSons.huluBrothers.length; j++) {
                if (!huluSons.huluBrothers[j].compare(huluSons.huluBrothers[min])) {
                    min = j;
                }
            }
            huluSons.swap(i, min);
        }
    }
}

```
#### (3) 主程序模块 (HuluSort.java)
HuluSort类中定义了一个HuluList对象作为静态成员变量，存储了所有葫芦娃组成的数组。因为有且仅有一个爷爷，类中定义了一个Grandpa类型的静态成员变量。在main函数中，分别通过huluBrothers和grandpa对象调用shuffle和两种排序策略的方法。前者可以让葫芦娃相互协作，完成排队过程，后者可以由葫芦娃们的爷爷来指挥葫芦娃们行动。
```java
public class HuluSort {
    private static HuluList huluBrothers = new HuluList();
    private static Grandpa grandpa = new Grandpa();

    public static void main(String[] args) {
        System.out.print("排队前：");
        huluBrothers.shuffle();
        System.out.println("葫芦娃自行排队中...");
        System.out.print("排队后：");
        huluBrothers.choreography();

        System.out.print("排队前：");
        grandpa.shuffle();
        System.out.println("爷爷指挥排队中...");
        System.out.print("排队后：");
        grandpa.orchestration();
    }
}
```
### 3. 运行结果
    排队前：老三 老五 老二 老大 老幺 老四 老六 
    葫芦娃自行排队中...
    排队后：老大 老二 老三 老四 老五 老六 老幺 
    
    排队前：老大 老六 老二 老四 老三 老五 老幺 
    爷爷指挥排队中...
    排队后：老大 老二 老三 老四 老五 老六 老幺 

