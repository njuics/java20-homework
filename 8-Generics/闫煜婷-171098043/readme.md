## 修改说明

### 用泛型修改的类型

***Comparator.java***

将姓名比较器实现为对Creature的比较器，实现对任意Creature对象的比较，拓宽了比较器的应用范围。

`class NameComparator implements Comparator<Creature>`

***Queue.java***

用泛型限定了队列类的基类Queue存储的对象的范围为`public class Queue<T extends Creature>`，表明队列适用于任何生物。

HuluWaQueue继承了基类Queue中的方法，并用泛型进一步限定了它存储的对象范围为`class HuluWaQueue<T extends HuluWa> extends Queue<T>`，即只能存储HuluWa类及其子类。

在排序方法中，传入当前集合类的super类的比较器进行排序，即`public void sort(Comparator<? super T> comparator)`，将比较器支持的类型尽可能设置为基类类型Creature，就可以支持更多种队列的排序。

### 好处

1. 使用泛型可以在编译期进行更强的类型检查，避免一些类型相关的异常在运行时才抛出。
2. 使用泛型可以明确类中对象的类型范围，使得代码复用性更强。如`Queue<T extends Creature>`可以在定义队列时指明队列中元素的类型，并同时支持多种Creature的子类队列；在sort中传入`Comparator<? super T>`类型的比较器，就可以通过所有应用于T的基类的比较器来进行T类对象之间的比较。