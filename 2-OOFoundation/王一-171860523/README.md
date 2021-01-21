# README

## 思路介绍

首先是“面向对象”的内容，我们需要确定有哪些类需要创建，并且基于某些类要创建哪些对象。按照题设，排队的主体是7个“葫芦娃”，那么我们就需要有一个葫芦娃的类，并基于这个类生成7个对象。同时，其中一种排队方法需要“爷爷”来指挥，那么也需要一个爷爷的类，并基于这个类生成1个对象。

接下来就是对对象的操作，来模拟**乱序站队**和**排队**的过程。

### 乱序站队

需要让七个葫芦娃先以一个乱序的队列进行排队，然后才能有接下来的排队的过程。

可以在[0,6]区间生成一个不重复的随机整数序列，代表当前位置上的葫芦娃，然后将葫芦娃放在对应的位置上。这样就是模拟最开始的排队，大家是以一个随机的方式进行排队，是乱序。当然不排除随机情况下可能会出现正序排队，这与实际情况也是相符合的。

### 排队

这一部分就要分成两个方式，orchestration和choreography。

前者需要爷爷指挥葫芦娃排队，因此需要在爷爷类中加入相关的函数，能够指挥葫芦娃的乱序队列，使其按照正确的顺序重新排队；

后者需要葫芦娃之间协作排队，因此需要在葫芦娃类中加入相关函数，模拟葫芦娃之间的交流以及交换位置的过程，达到正序排队的目的。

## 代码介绍

### Human.java

```java
public class Human
    protected String name;    //人类实体的姓名
    protected int index;      //人类实体的编号
```

是葫芦娃类和爷爷类的父类，拥有姓名和编号属性

同时提供两个public函数：sayOutName()和getIndex()，分别能够输出姓名和返回编号

这里主要是考虑到葫芦娃和爷爷可以具有相同的属性：姓名，编号。这一点也是模拟现实进行的，它们都是人类（葫芦娃也可以说是人类），都拥有姓名、编号，都可以报出自己的姓名，给出自己的编号。

### CalabashBrother.java

```java
public class CalabashBrother extends Human
	public static List<CalabashBrother> calabashQueue;  //葫芦娃公用的排队队列
```

葫芦娃类，继承于Human类

拥有一个公共的静态队列calabashQueue，模拟葫芦娃排队的队列，设置为static被所有葫芦娃对象共享，同时为public属性，对外可见，爷爷可以直接根据队列来指挥

#### exchange(CalabashBrother calaBro)

该函数模拟两个葫芦娃交换位置。

this指向的葫芦娃和calaBro指向的葫芦娃较换calabashQueue中的位置。

#### compareExchange()

模拟葫芦娃相互比较和交换的过程

this指向的葫芦娃会询问自己前后相邻葫芦娃的编号，如果前面的葫芦娃编号大、或者后面的葫芦娃编号小，就与对应的葫芦娃交换位置，然后继续询问，直到不与相邻葫芦娃发生交换为止

### Grandfather.java

```java
public class Grandfather extends Human
```

爷爷类，继承于Human类

#### commandQueuing()

模拟指挥排队的过程

爷爷首先会给出一个新的空排队，然后观察葫芦娃当前排队的队列，从头到尾获取葫芦娃的编号，按照编号指定葫芦娃在新排队中的位置。当所有的葫芦娃重新站到新的排队中，排队完成。然后爷爷将新的排队赋值给葫芦娃的队列，相当于爷爷告诉葫芦娃们就按照爷爷排的顺序来站队。

### QueuingActivity.java

```java
public class QueuingActivity
    private static Grandfather grandpa;                    //参加活动的爷爷
    private static List<CalabashBrother> calabashBrothers;     //参加活动的葫芦娃
```

主类，拥有main方法。模拟一个活动，在这个活动上，葫芦娃需要排队。拥有爷爷和七个葫芦娃成员

#### init()

初始化，创建爷爷和七个葫芦娃对象，赋予姓名和编号

#### shuffleBrothers()

创建一个打乱的[0,6]的整数序列，令葫芦娃按照序列进行乱序排队

#### orchestrationQueuing()

orchestration方式排队，调用爷爷的commandQueuing()方法

#### choreographyQueuing()

choreography方式排队，七个葫芦娃依次调用自己的compareExchange()方法

#### main(String[] args)

首先调用init()生成参加活动的爷爷和七个葫芦娃

然后调用shuffleBrothers()让葫芦娃乱序排队

然后会输出当前葫芦娃的顺序，并询问采用何种方式排队

用户可以在控制台输入来选择排队方式

根据输入，调用orchestrationQueuing()或者choreographyQueuing()进行排队

排队结束后，会输出正序的报数