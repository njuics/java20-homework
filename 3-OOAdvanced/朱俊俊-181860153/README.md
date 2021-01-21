## OO-Advanced



### 设计思路

`Calabash`类保存葫芦娃的信息，`Vine`类表示生出葫芦娃的葫芦藤，`Grandpa`和`CalabashTogether`实现了`Sorter`接口，分别完成了以**orchestration**和**choreography**两种形式的排序。项目位于包`cn.edu.nju.zjj.java03`下。



### Sorter

```java
package calabash;

public interface Sorter {
    void sort(Calabash[] calabashes);
}

```

实现为**接口类**是为了能够在`Main`中以相同的方法调用两种排序方法，为客户封装底部的排序细节。



### Grandpa

实现了`Sorter`接口，为葫芦娃进行**orchestration**式的排序,同时通过`void callOff(Calabash[] calabashes)`方法指挥葫芦娃报数。

由于只有一个老爷爷，因此用一个**静态变量**表示这个老爷爷，并通过**静态块**初始化。

```java
private static Grandpa grandpa;

static {
    grandpa = new Grandpa();
}
```

**拒绝**客户直接生成新的老爷爷，只可以通过静态方法`getGrandpa()`取得这个老爷爷。

```java
private Grandpa(){}

public static Grandpa getGrandpa() {
    return grandpa;
}
```



### Main

```java
package calabash;

public class Main {
    public static void process(Sorter sorter,Calabash[] calabashes)
    {
        sorter.sort(calabashes);
    }

    public static void main(String[] args)
    {
        Calabash[] calabashes = new Vine().makeCalabashes();
        process(Grandpa.getGrandpa(),calabashes);
        process(new CalabashTogether(),calabashes);
    }
}
```

由于`Grandpa`和`CalabashTogether`都实现了接口`Sorter`，因此`process`可以自动地通过不同策略对葫芦娃进行排序，是**多态**的应用。



### UML



![](http://www.plantuml.com/plantuml/png/TOwnJeSm4CRtFiMDCFW23eQ4mT41us8SJdg5nciXlTRu-1QaYFvXQ7Avx_VrVer4334vLZsZ23m6z7f6i6vcSkIZG3U5I67BMsHyHncVfu7YIE44B5_SxJ3SGqXC0W_gV_-SUh6U_YOEFzRavqPUI1wg0ho-GR-D97KnoDJdPFKIyPCn5_IDKgd9c8nXkgejZXdzJLV7TYUgMXtyhO_vQVewBhiOh1_0eoFLaDV9yJS0)

`Grandpa`和`CalabashTogether`对`Calabash`进行管理(排序、报数，打乱位置...)，`Vine`构造`Calabash`。