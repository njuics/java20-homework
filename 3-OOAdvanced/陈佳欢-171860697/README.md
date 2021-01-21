# HomeWork3

------------------------------------------------------------

## 作业要求

依照面向对象编程思想，对葫芦娃队列进行两种方式的排列
+ 1 通过爷爷协调各葫芦娃之间的位置
+ 2 葫芦娃自身之间协作排列

使用面向对象中的**封装**、**继承**、**多态**的特性
使用Java中的**接口**、**构造器**、**静态变量**、**静态块**、**包**、**修饰符**的语言机制

------------------------------------------------------------

## 作业思路

### 关于类

因为大娃、二娃等葫芦娃和爷爷都是此场景中的具体对象，所以需要对他们进行抽象，构建对应的类

大娃、二娃等葫芦娃可以看作是基类`class:HuLuWa`的子类，他们由父类继承而来

葫芦娃爷爷即为爷爷类

![](http://www.plantuml.com/plantuml/png/XOxDYeCm58NtUOh0R1Hdtc0Ot4qNBWfTT5ck6cem9d9_wgBqtPj4YwlIJJWvV7ptrCI0B9DJdGCYVP16pg3lwakV6As_QW-JYJ_hMIFuKLKRKvGnRWmRvou9J6L6SvFutDo2xVKSKGx26Tph1TnOD9RuT_N-wK6Sj1XuC4ZVIMPBzL3RmFyexOzfOVNAkojWDnXY1BR1lvUMwcVbQO7vmst8RviMrCRtChad)

```java
class HuLuWa {
    protected String name;      /* 葫芦娃的名字 */
    protected int rank;     /* 葫芦娃的排名 */
    public HuLuWa()       /* 初始构造函数 */
    public String tell_name()      /* 返回自己的名字 */
    public int tell_rank()        /* 返回自己的排名 */
    public void printout_name()       /* 输出自己的名字 */
    public void walk(List<HuLuWa> hulubrothers,int i)        /* 根据自己的rank走到队列中正确的位置 */
}

class GrandPa {
    public GrandPa(){}      /*默认构造函数*/
    private void swap(List<HuLuWa> hulubrothers,int a,int b)       /* 交换a,b两个葫芦兄弟的位置 */
    public void orchestration(List<HuLuWa> hulubrothers)     /* 对hulubrothers队列进行指挥排序 */
}
```

![](http://www.plantuml.com/plantuml/png/bSun2y8m40NWFRyYuAAK_WE7Jk8WE5HmBC4U6amlabwgKFtljhNbRTAExtZlIx9QJ91OENLnfgxrFXxYsUXMhNGkmV9LiwceIvP51yDtbOoTzKObKqV8kQ8lziUXEbpw_d1fl2trewkAZp8LFsfyyyXK_CoswoBzdOuVtRxJL6CoaQUd1uaqcyG4v2qG0KLUmc84UETZW8kuWCK6gcq8Ak9y5HkekNq1HPfjOWAI6cAWo8jOmaXbn6Mit1S0)

在各个葫芦娃继承类中，对`printiout_name()`函数进行了重写

### 关于排列算法实现

#### orchestration监管排列

通过爷爷类中的`orchestration()`函数实现
大致思路：
> 从队列头开始，对葫芦娃a安排位置
> 
> + 具体安排方式，通过询问葫芦娃a的`rank`，得到该葫芦娃应该在的位置
> + 将该葫芦娃a放在正确位置，接着为a取代的葫芦娃b，即在原队列中在a位置的那位葫芦娃，为b安排位置
> + 若爷爷在安排位置时，发现某位葫芦娃正好在其该在的位置，则不用进行任何改变
> + 回到原本a所在位置的下一位，为其安排队列位置
> 
> 当队列中最后一位的葫芦娃也正确安排后，排列结束

#### choreography无监管排列

大致思路：
> 从队列头开始，葫芦娃a自己寻找位置
> 
> + 根据自己的`rank`调用自己的`walk(List,rank)`函数
> + 让在`rank`位置的葫芦娃b，继续上述操作
>
> 原队列尾的葫芦娃也找到了自己的位置，排列结束

-----------------------------------------------------------------

## 包

HuLuWa.java、One_HuLuWa.java...Seven_HuLuWa.java、GrandPa.java等都打包在cn.edu.nju.java.huluwa目录下