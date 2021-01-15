# DEADME

## 基本思路

随机生成葫芦娃，并使用List(ArrayList)储存葫芦娃

六种排序方式：

全体正序，全体反序，全体乱序，性别正序，性别反序，性别乱序

对葫芦娃的List进行操作，不过不改变原有的容器，而是返回一个排好序的新容器。因为原有的容器代表葫芦娃的集合，排序后返回的容器属于队伍

然后对返回的队列进行输出

## 实现方法

### CalaBro.java

实现了葫芦娃类

使用一个static List储存葫芦娃的集合

在构造函数中随机为葫芦娃赋予3~10个大小写字母的名字，50%概率赋予男性或女性性别，并将新增的葫芦娃加入到static List中

定义compareTo函数，用于后续排序过程

sortPrint()函数会针对static List完成六种排序，并调用printAll()进行输出，printAll()中使用iterator遍历传入的List

### MySort.java

实现了MySort的接口，其中包含一个sort的方法：

```java
List sort(List list, int mode) throws Exception
```

针对不同的功能实现接口

### CalaAllSort.java

实现MySort接口，对所有葫芦娃进行排序

list为传入的葫芦娃序列，mode为排序模式：-1代表逆序 0代表乱序 1代表正序

当出现非法mode值时抛出异常

### CalaSexSort.java

实现MySort接口，按照性别对葫芦娃排序

list为传入的葫芦娃序列，mode为排序模式：-1代表逆序 0代表乱序 1代表正序

当出现非法mode值时抛出异常

首先获取男性集合和女性集合，分别排序后再拼接返回

外层需要对返回List进行拆分

### Main.java

随即生成1~20个葫芦娃，并调用葫芦娃类中的排序函数，观察输出