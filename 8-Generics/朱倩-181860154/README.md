# 8-Generics



## 用泛型改写的地方

1. 用于集合排序算法中对象间比较的`AscComparator`,`DescComparator`,`RandomComparator`类

   以`AscComparator`为例：

   原来版本：

   ```java
   class AscComparator implements Comparator<HuLuWa>{...}
   ```

   只能用于葫芦娃之间的比较，现用泛型改写：

   ```java
   class AscComparator<T extends Comparable<T>> implements Comparator<T>{...}
   ```

   这样如果有其他生物（如：妖怪）也需要排序，可以利用该类进行排序。

2. `Control`类（包含main函数，用于展示排队的整个过程，包括队伍的初始化，队伍的排序，队伍成员的打印）中用于打印队伍成员的`printQueue`方法和用于调用三种排序算法并展示排队结果的`sort`方法

   原：

   ```java
   private static void printQueue(List<HuLuWa> queue) ;
   private static void sort(List<HuLuWa> queue);
   ```

   改写后：

   ```java
   private static <T> void printQueue(List<T> queue) ;
   private static <T extends Creature&Comparable<T>> void sort(List<T> queue);
   ```

   通过泛型实现可以将这两个方法用于其他生物队列的打印和排序。

   

## 改写的好处

使算法适用的对象不局限于葫芦娃一种，扩大了代码的适用范围，增加了代码的可复用性。



