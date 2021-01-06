# 8-Generics

在作业7-Collections的基础上，有以下的类和接口实现了泛型：

1. huluwa.characters包

```java
public interface Swappable<T extends Swappable<T>> {
    void swap(List<T> list, T o);
}
```

实现Swappable接口的类在由该类对象组成的List中可以和另一个对象交换位置，葫芦娃类CalabashBrother实现了该接口。该接口是新增的接口，其目的是为了配合Sorter的泛型化。

2. huluwa.tools包

```java
public interface Sorter {
    <T extends Swappable<T>> void sort(List<T> list, Comparator<? super T> comparator);
}
```

Sorter接口只有sort()方法泛型化，实现该接口的类能够对实现了Swappable接口的类型的对象组成的List进行排序，sort()方法不要求类型参数T实现Comparable接口，但在排序时需要提供能够比较两个T类型对象的Comparator。这样一来，对于没有实现Comparable接口的类，只要提供Comparator，也能够使用Sorter进行排序。泛型化该方法的目的和好处是，如果将来有对于其他类型的排序需求，只需要确保该类型实现了Swappable接口，就能复用同样的排序方法，不需要写额外的类。并且，由于泛型化的是sort()方法而不是整个类，同一个Sorter可以对不同类型的List进行排序，不需要构造多个Sorter。

实现了Sorter接口的类包括：

```java
public class BubbleSorter implements Sorter {...} 
```

和

```java
public class QuickSorter implements Sorter {...}
```

它们分别实现冒泡排序和快速排序方法。

```java
public class GenderFilter {
    static public <T extends Character> List<T> filter(List<T> list, Gender gender) {
        ...
    }
}
```

GenderFilter类实现静态泛型化方法filter()，用于过滤出由类型T对象组成的List中具有给定性别的对象，并返回它们组成的子队列。类型参数T应是Character类的子类(Character类是所有角色的父类，目前具有名字、性别两个属性，以及相应的Getter和Setter方法)。该类在如果需要按性别筛选各种角色的时候能够派上用场。

