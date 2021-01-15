# 作业 2 提交说明 by 张福翔-171840514
### 设计思路
我们设计了`HuluBaby`,`HuluSorter`, `PlayGround`三个主要的类，以及一个调用程序的主函数类`Main`作为本作业中使用的类。其中各个类的作用为：

- `HuluBaby`：定义葫芦娃的类，每个葫芦娃的身份以一个枚举对象`HuluName`来表示，实现了一系列方法如比较函数`compareTo`，赋值函数`huluAssign`
和交换位置函数`huluSwap`。
- `HuluSorter`：定义了排序的方法。排序的方式包含`ORCHESTRATION`和`CHOREOGRAPHY`两种，
并实现了排序过程中赋值`assign`和交换`swap`方法在两种不同模式下的实现，
在`ORCHESTRATION`模式下直接通过`HuluSorter`类对`HuluBaby`进行操作，
在`CHOREOGRAPHY`模式下通过调用`HuluBaby`类自身的相应方法完成操作。

    - 在使用`ORCHESTRATION`模式时，`HuluSorter`相当于起到了爷爷的作用，调整每个葫芦娃的顺序；
    - 在使用`CHOREOGRAPHY`模式时，`HuluSorter`驱动每个`HuluBaby`自身与其他葫芦娃进行比较和位置交换。
- `PlayGround`：定义了`HuluBaby`类型的数组，描述葫芦娃存在的空间。
并提供`shuffleHuluBaby`方法，用于打乱葫芦娃的顺序。
此外，通过`hulusGreeting`方法，让每个葫芦娃进行报数。

### 调用说明
我们在主函数中的程序执行过程如下。

1. 创建一个包含7个葫芦娃的`PlayGround`，并将葫芦娃随机打乱，让葫芦娃进行报数。
2. 将葫芦娃在`ORCHESTRATION`模式下进行排序，排序后让葫芦娃进行报数。
3. 打乱葫芦娃的顺序，并在`CHOREOGRAPHY`模式下重新排序，排序前后让葫芦娃进行报数。

### 排序算法修改
在`HuluSorter`函数中提供了多种排序算法，算法名作为`HuluSorter`类的一种方法提供，
已经实现的算法包括：

- 快速排序算法`quickSort`
- 归并排序算法`mergeSort`
- 冒泡排序算法`bubbleSort`

如果想要替换排序算法，我们只需在主函数中对应的排序代码里进行修改，替换对应的方法名即可。

如果想要自定义新的排序算法，仅需在`HuluSorter`类中添加新的方法，注意使用提供的`assign`函数和`swap`函数进行数组元素的赋值和交换即可。