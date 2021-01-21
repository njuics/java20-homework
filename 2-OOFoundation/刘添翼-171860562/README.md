# 作业二：面向葫芦娃编程

## 一点说明

呃，不得不说，本次作业的要求有一点点令人费解，所以我们按照我们的想法完成了作业。
在我们看来，本次作业要求分别用Orchestration和Choreography的方式对葫芦娃进行排序。

参考[这个网址](https://stackoverflow.com/questions/4127241/orchestration-vs-choreography)中给出的解释，我们认为：前者指利用一个中心化的服务调度其他的服务，一起完成任务，即*由葫芦娃们的爷爷来指挥葫芦娃们行动*；后者指去中心化的各个服务互相协作完成任务，即*葫芦娃相互协作，完成排队过程*。

## Orchestration

### `Hulu.java`

为了给葫芦娃排序，首先我们需要实现`Hulu`类，它代表一个葫芦娃。如果考虑有且仅有七个存在全序关系的`Hulu`对象，分别是老大到老七，排序成为一件很无聊的事情。所以我们稍稍改动了需求，认为七种葫芦娃的每一种都可以有若干个对象（不过为了偷懒我们没有写一个虚的葫芦娃基类然后派生出七个类来，仅仅用一个`index`的枚举变量作为区分），同种葫芦娃的序关系由这些对象的`hashcode()`方法的返回值确定。这样我们就可以不定数量的葫芦娃排序了。

### `HuluOrchestrationSorter.java`

为了实现排序，我们让`Hulu`实现了接口`Comparable<Hulu>`，这样我们可以用`compareTo()`方法为两个`Hulu`的对象比较大小。基于此我们实现了`HuluComparator`，这样就可以调用存放`Hulu`的容器的`sort`函数，或者任何自己写好的排序算法完成排序，其中比较的工作可以直接调用`HuluComparator.compare()`来完成，排序算法不需要知道相关的任何细节。最终，我们用一个`HuluOrchestrationSorter`类表征中心化的排序服务，用一个`ArrayList<Hulu>`存储葫芦们，并且给出`add()`、`sort()`和`print()`方法供调用。

## Choreography

### `Position.java`

如果要实现去中心化的排序，那么首先我们需要有一个逻辑上的**队伍**的概念。我们为此实现了`Position`（实质上就是一个`int`）和对应的`genNewPosition()`方法，模拟一个新的`Hulu`来到操场上，为它分配位置的过程。

### `HuluWithPosition.java`

去中心化的排序的困难在于，`Hulu`需要有能力得知自己的位置，得到其他位置上的`Hulu`的引用，还需要能修改自己和其他`Hulu`的位置。我们认为把这些全部写死在`Hulu`或者它的派生类里是一件很糟糕的事情，所以我们仅仅派生出了一个`HuluWithPosition`类，为`Hulu`加了一个新的`Position`成员。假定前述的功能都能实现，那么我们可以增加一个`trySwap()`方法，它会得到下一个位置的`Hulu`的引用，并且和自己进行比较，如果自己的序严格大于下一个位置的，那么就把这两个`Hulu`交换。**队伍**中的`Hulu`反复调用`trySwap()`，直到这种交换无法进行。这个算法的正确性是显然的。

### `IPositionToHuluMapper.java`

剩下的几个需求，我们决定交给`IPositionToHuluMapper`接口来实现。它只有两个虚方法，一个是`getHulu()`，用来得到某个`Position`上对应的`Hulu`；一个是`syncChange()`，用来把逻辑上位置发生改变的`Hulu`的状态在物理上（存储`Hulu`的容器内）进行更新。

### `HuluChoreographySorter.java`

最后，我们用一个`TreeMap`实现了`IPositionToHuluMapper`接口，用一个数组作为物理上的容器（并且出于简化问题考虑，我们不打算真的在数组里移动`Hulu`），这样我们就可以进行去中心化的排序了。