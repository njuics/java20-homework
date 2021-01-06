# 作业二设计说明

## 问题分析与类设计
该问题中，研究的基本对象是“葫芦娃”，首先创建了“葫芦娃类”（`CalabashBrother.java`），这里不同“葫芦娃”对象的差别为他们的名字——从“大娃”到“七娃”，所以添加了属性`String name`，另外，为了后续排序方便，我添加了`int id`属性，用“0-6”分别标记“大娃-七娃”。功能上，编写了函数`report()`用于输出名字（`name`）。

之后，考虑到排序的对象是“队列”，所以创建了“队列类”（`CalabashBroQueue.java`），其中以一个数组存储队列数据，每一个元素是一个“葫芦娃”对象，功能上，编写了`shuffle`和`swap`两个函数用于随机打乱葫芦娃队列，`countOff()`函数让葫芦娃依次“报数”——调用`CalabashBrother::report()`。

最后，为了完成Orchestration形式排序，需要设置“第三方”指挥排序过程，所以继承“队列类”（`CalabashBroQueue.java`）得到了“受控队列类”（`MasteredCalabashBroQueue.java`），两个类的主要区别是排序算法。

## 葫芦娃排序与类功能添加
### Choreography
该方式要求通过葫芦娃相互协作完成排序，这里我使用了冒泡排序，该排序算法是基于比较的，对应于“相互协作”，另外，为了体现OO思想，我将“比较”和“交换”操作写入“葫芦娃类”（`CalabashBrother.java`）中,意味着，作为排序算法的编写者，我们关注排序的对象而非“如何比较”和“如何交换”。

### Orchestration
为了体现指挥，而且考虑到“葫芦娃类”（`CalabashBrother.java`）中存在`id`属性，在“受控队列类”（`MasteredCalabashBroQueue.java`）的排序算法中，直接根据`id`为葫芦娃指定其排序后的位置（非基于比较的排序方式）。

### 两种排序算法的相互替换
两种排序方法均为调用类中的`lineUp()`函数，所以仅需更改“队列类”的类型（`CalabashBroQueue`或`MasteredCalabashBroQueue`）即可更换排序算法，另外，因为使用了继承，两个类均可使用`CalabashBroQueue`指针。

## 面向对象编程思想总结
1.将“属性”和“行为”封装为“类”；

2.使用了OO的继承思想以及动态绑定；

3.冒泡排序时，着眼于待排序的对象而非如何比较两个对象。