# 02-OOFoundation
## 需求分析
​	要使用面向对象的思想解决此葫芦娃排序问题，必须设计一种排序算法基类，然后需要的两种算法设计为该基类的子类, 从而可以用基类的变量引用去引用子类算法，从而实现在尽量少修改代码的情况下修改或者增加排序算法。
​	为了符合面向对象设计的基本原则，我们还需要将每一个葫芦娃抽象为一个类，将葫芦娃的数组抽象成一个类，方便我们直观地进行各种需要的操作。

## 类的设计
本实验共设计了如下几个类：

* 葫芦娃类 `class Calabash`

* 葫芦娃数组类 `class CalabashBoys`

* 排序算法基类 `class BaseSort`

* Orchestration 排序 `class Orchestration`（包括我使用的快速排序的抽象类`class Grandpa`）

* Choreography 排序 `class Choreography`

* 作业入口类 `class Homework2`

### 葫芦娃类

```java

class Calabash {
    private int id;
    private String name;
    
    Calabash(int id, String name){...}
    Calabash(Calabash c){...}
    
    public int getId(){...}
    public String getName(){...}
    public void reset(int id, String name){...}
    public void reset(Calabash c){...}
}

```

​	代码细节已被略去。

​	首先我们有两个`private`变量`int id` 和`String name`，存放了葫芦娃的基本信息，如0和“老大”。这是为了防止任意存取葫芦娃变量而设立的。

​	然后有两个函数，分别为构造函数和拷贝构造函数，这是为了方便初始化变量。

​	下面的四个函数前两个是获取葫芦娃`id`和`name`，后两个是为了方便进行`swap`函数的实现，以及修改葫芦娃信息。这里采用`private`变量 + `public`函数修改的好处就在于保证了葫芦娃变量的信息是成对修改的，否则任意修改可能会导致信息不对应，从而出现问题。

### 葫芦娃数组类

```java
class CalabashBoys {
    private Calabash[] set;

    CalabashBoys(Calabash[] s){...}

    //打乱葫芦娃顺序
    public void shuffle() {...}
    //交换Calabash[] set对应pos1、pos2处对象的数据
    public void swap(int pos1, int pos2){...}
    //输出当前排序信息
    public void report(){...}
    //重设set数组
    public void reset(Calabash[] s){...}
    //外界获取set数组信息
    public Calabash[] getSet(){...}
    //外界获取某一葫芦娃信息
    public Calabash getCalabash(int pos){...}
    //外界获取葫芦娃数组的长度
    public int getSetLength(){...}
}
```

​	各函数作用已以注释形式写在代码中。

​	这里我们也将存储葫芦娃数组的`Calabash[] set`设为了`private`，就是为了防止外界随意修改数组内容，同时我们提供了各种接口，保证了排序算法可以仅调用公共接口就可以实现。

​	注意`public Calabash[] getSet()`和`public void reset(Calabash[] s){...}`在代码中我们返回的是一个新的对象，只是值与数组或数组内的葫芦娃的信息相同，这样可以防止外界对葫芦娃信息进行随意修改。

### 排序算法基类

```java
public class BaseSort {
    public static void swap(CalabashBoys c, int pos1, int pos2){
        c.swap(pos1, pos2);
    }
    public void sort(CalabashBoys c){}
}
```

​	对于排序算法基类，我们提供`swap`和`sort`两个接口。`swap`调用了`CalabashBoys`类的`swap`接口，方便子类调用，而基类的`sort`函数本身无详细定义，需要子类去覆盖实现，也就是所谓的“多态”。

### Orchestration（爷爷指挥行动）

```java
class Grandpa{        
    public static int partition(CalabashBoys boys, int ppos, int s, int e) {...}
    public static void quickSort(CalabashBoys boys, int s, int e) {
        if(s < e) {
            int ppos = s;
            ppos = partition(boys, ppos, s, e);
            Calabash calaPivot = boys.getCalabash(ppos);
            System.out.println("Grandpa：葫芦娃们，对于队列中位于第"+ (s + 1) +"到第"+ (e + 1) + "位的葫芦娃，比"
                                + calaPivot.getName() + "地位高的葫芦娃请站在他左边，比"
                                + calaPivot.getName() + "地位低的葫芦娃请站在他右边！");
            quickSort(boys, s, ppos - 1);
            quickSort(boys, ppos + 1, e);
        }
    }
}

class Orchestration extends BaseSort{
    public void sort(CalabashBoys c){
        ...
        Grandpa.quickSort(c, 0, c.getSetLength() - 1);
        System.out.println("Orchestration排序完成，结果如下：");
        for(Calabash i:c.getSet()){
            System.out.print(i.getName() + " ");
        }
        ...
    }

}
```

​	这里我们的`Orchestration`类继承于`BaseSort`类，并且对`sort`函数进行了覆盖实现。

​	`Grandpa`类即为具体实现，这里使用了快速排序，也就是“爷爷”宏观调控，每次从区间内选择一个基准葫芦娃，让区间内比他地位高的葫芦娃站到左边，比他地位低的葫芦娃站到右边，然后左边右边就又成了一个新的区间，于是递归执行上述操作即可。

### Choreography （葫芦娃相互协作）

```java
class Choreography extends BaseSort{
    public void sort(CalabashBoys c){
        ...
        for(int i = 0; i < c.getSetLength() - 1; i++){
            for(int j = c.getSetLength() - 1; j > i; j--){
                Calabash s1 = c.getCalabash(j), s2 = c.getCalabash(j - 1);
                if(s1.getId() < s2.getId()){
                    System.out.println(s1.getName() + "说：" + s2.getName() + "，你比我小，我们俩换一下位置！");
                    swap(c, j, j - 1);
                }
            }
        }
        System.out.println("Choreography排序完成，结果如下：");
        ...
    }
}
```

​	同样地，我们的`Choreography `类继承于`BaseSort`类，并且对`sort`函数进行了覆盖实现。

​	我们使用冒泡排序，因为冒泡排序就像是每两个葫芦娃之间协作的体现。从队列末尾开始，由后向前总是将`id`更小（即地位最高）的元素移至相邻元素的更前的位置。这样每次会把一个`id`最小的元素移至数组最前部，然后我们将这个元素排除的剩余数组内继续执行类似操作，最后就得到了`id`逐渐增大的序列。

### 作业入口类

```java
class Homework2 {
    public static void main(String[] args){
        //初始化葫芦娃，可以在此随意增添删除修改
        Calabash[] set = { new Calabash(0, "老大"), new Calabash(1, "老二"), ...};
        CalabashBoys c1 = new CalabashBoys(set);
        //随机，并输出随机结果
        c1.shuffle();
        c1.report();
        //获取排序后的set
        set = c1.getSet();
        //生成与c1一样的CalabashBoys c2，便于比较两种排序
        CalabashBoys c2 = new CalabashBoys(set);
        //为两种排序生成对象
        BaseSort s1 = new Orchestration();
        BaseSort s2 = new Choreography();
        //进行排序
        s1.sort(c1);
        s2.sort(c2);        
    }
}
```

​	我们先构造出来一个初始葫芦娃序列，即老大到老七，用这个数组初始化`CalabashBoys c1`对象，然后打乱数组，模拟葫芦娃的随机站位，然后获取到打乱后的数组，再创建一个`CalabashBoys`对象，目的是可以顺序使用两种排序算法去比较两种算法的细节。然后定义两个`BaseSort`类对象，引用至两种算法，然后执行排序，即完成题目要求的过程。

## 总结

​	为了让排序算法便于修改，我们使用了`BaseSort`类来描述一种模糊的排序算法所应具备的基本接口，然后使用`Orchestration`类和`Choreography `继承`BaseSort`类来定义不同算法的不同细节。最后统一使用`BaseSort`类的对象去引用不同排序算法，来进行排序算法的使用。当需要增添排序算法的时候，只需将排序算法封装为`BaseSort`类的子类，然后即可用`BaseSort`类的对象去引用来使用算法。