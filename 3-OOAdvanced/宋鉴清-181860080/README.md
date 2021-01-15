> 采用面向对象编程和抽象思维来解决葫芦娃排序问题

## 面向对象中的特性

### 封装

首先定义一个Human类，类中有protected型变量name， 对同一包内的类和所有子类可见，

Huluwa类中有private型变量index，仅能通过方法`get_index()`获得，实现了对name和index变量的保护。

### 继承

Huluwa类和GrandPa类继承了Human类，所以这两个类都拥有变量name和方法`report_self_name()`。

定义了一个接口Sort，HuluwaSort类继承了接口Sort从而来继承接口Sort的抽象方法。



### 多态

类HuluwaSort继承了接口Sort，然后定义了一个`Sort show = new HuluwaSort()`，那么调用接口Sort中的`DisorganizeLine(Huluwa[] Hulu_Queues);`实际上调用的是，类HuluwaSort中的`void DisorganizeLine(Huluwa[] Hulu_Queues);`



### Java中的语言机制

### 接口

定义了一个Sort接口，并且定义了三个抽象方法

```java
public interface Sort{
	void DisorganizeLine(Huluwa[] Hulu_Queues);
	void orchestration_sort(GrandPa grandpa, Huluwa[] Hulu_Queues);
	void choreography_sort(GrandPa grandpa, Huluwa[] Hulu_Queues);
}
```

HuluwaSort继承了该接口，然后在该类中实现接口Sort中的方法



### 构造器

因为GrandPa和Huluwa类继承了Human类，Human类中，有`Human(String name)`构造器，那么在子类中也要分别有`GrandPa(String name)`和`Huluwa(String name)`构造器，又因为Huluwa类中，还有私有变量index（用来记录葫芦娃的排行大小），所以Huluwa类中还有一个构造器`Huluwa(String name, int index)`

### 静态变量

在HuluwaSort类中定义了一个静态变量Huluwa_NUM（int型变量）

### 静态块

因为HuluwaSort类中定义了一个静态变量Huluwa_NUM，所以需要一个静态块来对这个变量进行初始化。

### 包

将定义人物的文件全部放到character文件夹下，将定义排序的文件全部放到sort文件下，然后对文件夹下的文件进行打包即`package character`和`package sort`，外部可以通过`import character.xxx`进行调用包内的类等，使用`import sort.*`可以直接访问该包内的public型类。

### 修饰符

使用private，使得变量和方法在同一类内可见。外部只可能通过public方法进行调用

使用public，使得类，接口，变量，方法对所有类可见，外部可以直接调用

使用protected，使得变量，方法对同一包内的类和所有子类可见。



## UML类图

<img src="http://www.plantuml.com/plantuml/png/fPHHRzCm4CUVcqzn4Y-PskqBL4AJXiGUs3GeF24K7SajCOhFmNRe0F7TiNqXMRqARMfVShdx_oztlyQvT1wj7tLVr3qw1pUe67uNgpMyjSZD7K8RhmF6LD1wLSCFenhGGLZkl5NSVlu2Q5jtLlmffYxNeyRO1iBl5OWA63LjKsejWl9HuKmAqjlIOAol7FNtLIoMI-jvB7hmnCtqA7dIFFFJnkVmrPYUaE7Aw04jNO_zkCUg9-TAYS4mRM2AaOtlo4vccMgtn-7ZtjoPVuwmzs2f-ZxI69oAFIYvV3lOPcUi5yCHtu7oIZSVqkgterwqCQZUH_4XubZECQpEPGvkw65RhDOYou0SJMyMOrB4kvPybJ9bJCq8Qq4ey39WGRVGsYlVSPZm6Rp2NY4YUuyr9M9XbzJdZNB6jiZg5xrJJCUnR2UniNL7pblqod0LZBxCNkCD_BT1tHbB9cY7xkVB_DaV4rS0fOUUDB5tijBqDisdHax4Sh0Y2x5NjvzkKkNv3ABw50ZIuIGA4KBwW5nSl8R9iYJ4ijn797arvPRmKINBpkrpsHF19N4pwlul" alt="2" style="zoom:80%;" />