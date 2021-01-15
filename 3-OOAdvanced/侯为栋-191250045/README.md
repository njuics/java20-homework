# 作业的小小说明

先简单介绍下本项目的类，再补充一些其它必要内容。

## 类

本作业共有三个主类和一个枚举类。

### Calabash

葫芦娃类实现了`comparable`接口，借以比较各个葫芦娃的位置合适与否。

类中保存了姓名、优先级和位置的字段，其中优先级是比较的基准，交换位置时改动的是位置保存的值。

上述属性皆为`private`，若想访问或者修改必须通过`get`或`set`接口。

同时葫芦娃中保存了一个`calabashSum`的静态变量，用以保存一共创建了多少个葫芦娃。

说实话没必要，所以我也没有用它做什么事情。

葫芦娃可以报出自己的名字，可以选择自己的位置、和别人比较位置，和别人交换位置。

构造函数会通过传入参数初始化`name`和`seniority`，位置设为`-1`表示没有选择位置。

每当调用构造函数，`calabashSum`的值就会加一。

### GrandPa

爷爷类是本作业的核心，一切行为皆由之入手。

看成你就是爷爷也不为过。

类中保存了葫芦娃的队列`queue`，爷爷比较葫芦娃的标准`sortStandrad`，以及爷爷让葫芦娃们排序的方式`sortMethod`。

和葫芦娃类类似，上述属性均为`private`。

爷爷可以交换两个葫芦娃的位置，可以下达命令让葫芦娃们报数、选择自己的位置和排序。

排序需要一个枚举常量参数，对应`orchestration`和`choreography`。

构造函数无需参数。调用构造函数时，会创建7个葫芦娃的实例并保存在`queue`中。

此时属于未排序状态，即使由于初始化顺序使得`queue`中看起来有序，但实际上各个葫芦娃实例中的`position`是-1。

### Sort

本类是一个抽象类，用以替代接口。

本来用接口更方便，奈何作业既要体现继承又要体现接口，没办法了。

`Sort`中有两个抽象方法，名字均为`sort`。

第一个体现葫芦娃自己排序，因为比较和交换位置均调用的葫芦娃的内置方法。

第二个体现爷爷指挥排序，原因同上。

具体使用上，编写排序类继承`Sort`，并调用爷爷类中的`setSortMethod`方法即可。

本作业中实现了冒泡排序和选择排序，分别对应`SortMethodA`和`SortMethodB`。

### QueueType

枚举类，保存`ORCHESTRATION`和`CHOREOGRAPHY`两个常量，对应排序的形式。

## 补充

### main方法

`main`方法在`GrandPa`类中。

具体调用方式为：创建爷爷类，爷爷让葫芦娃们选位置，爷爷让葫芦娃们报数，爷爷让葫芦娃们排序，爷爷再让葫芦娃们报数。

某一次运行结果为

```
老七!
老四!
老五!
老三!
老六!
老大!
老二!
完毕~~~
老大!
老二!
老三!
老四!
老五!
老六!
老七!
完毕~~~
```

### package

我的本地文件夹代码结构如下图所示。

![1](https://github.com/xxh160/gallery/raw/master/codeStructure.png)

因此我的所有源代码文件开头都有`package java20homework.ooadvanced;`，提交上去的会被我注释掉。

### UML

所画类图如下图所示。

![2](http://www.plantuml.com/plantuml/png/fL9D3zCm3BtdL-HO6Fq5GzC-D6qSM4TR3WXnS5jlZMYJahZ0LFRVSJzI9fYG49TMVhQVttEyTWIMsheIUGNEoOC5NPoX4-4EAiZ0bHy_oIyjjiY8gHkmGCQ-zicLTCPIGjm4jX1Xmj40lKKgJI74ugjHXSJlUGdwYcVZ52cZNU09fD7uIiuHVJClfXxTrXdQw789F58fZU-Ru5sl9hqrA8a_FkcGPdRkk8l9aATcHqeJbsbbhABRSeoRgOV3XApILwcXngLOT8w0L7wNVLK-aIHjlNpYwPURp1egqSwEvkrvcSnKdNX2RsgOh_BFNdUG6LCXQEvXMLD1FYmTK_F7aC4aP8uiv2H7j_t-EnRluRiSbyDmy4JIqxhf1EHr_3_iCfaVTiD3_ihyRtJR_wD3lXKvdqKdedXtt2Tfl4dVH2UnEqRnFZh4c_FnGr_j6S9m9VqeyM2D4pzMWxW7TFiRok5BEJ69DUgYhQkV)
