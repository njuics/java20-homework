# 类的设计

## HuLuBrother类

葫芦娃的基类

数据成员`int id`用以排序，`String name`用以报自己的名字

实现了接口`Comparable`，重载了方法`public int compareTo(Object o)`，用于比较和排序

方法`public void ReportNumber()`用于报数



## Dawa Erwa Sanwa Siwa Wuwa Liuwa Qiwa类

各个葫芦娃的类，由构造函数区分id和name

> 之所以设计成七个类，而不是在HuLuBrother类中用enum区分七个葫芦娃，主要为日后扩展复用，葫芦兄弟可重载自己的技能



## GrandFahter类

爷爷的类，有2个方法，分别是给葫芦娃队列排序，和让葫芦娃队伍报数



# orchestration实现

爷爷作为排序方法的实施者，对传递进来的葫芦兄弟队列进行排序，使用了`Arrays.sort`进行排序，可替换成自己的对数组的排序，代码改动量不大

```java
class Grandfather {
    public void SortCalabashBaby(HuLuBrother[] queue) {
        Arrays.sort(queue);
    }

}
```





# choreography实现

葫芦兄弟和左右的兄弟进行交互：

* 如果i号位置的葫芦娃发现排在i-1位置的葫芦娃比自己大，就和i-1位置的葫芦娃交换位置
* 如果发现i+1位置的葫芦娃比自己小，就和i+1位置的葫芦娃交换位置
* 重复1、2步，直到已经到了队伍尽头，或者1、2步中条件都不满足

关键代码

```java
//葫芦娃询问左边和右边的葫芦娃，看是否需要往前往后冒泡
for (int i = 0; i < queue.length; i++) {
    int j = i;
    while (true) {
        if (j-1 >= 0 && queue[j].compareTo(queue[j-1]) < 0) {
            //System.out.println(queue[j-1].name + "与" + queue[j].name + "换位");
            HuLuBrother temp = queue[j-1];
            queue[j-1] = queue[j];
            queue[j] = temp;
            j = j-1;
        }
        else if (j+1 <= queue.length-1 && queue[j].compareTo(queue[j+1]) > 0) {
            //System.out.println(queue[j].name + "与" + queue[j+1].name + "换位");
            HuLuBrother temp = queue[j+1];
            queue[j+1] = queue[j];
            queue[j] = temp;
            j = j+1;
        }
        else {
            break;
        }
    }
}
```

