

# 第十次作业



在此次作业中，我做了以下修改：

* 在 MyCollection.java 中用 **com.google.common.collect.Lists**代替了原来使用的**ArrayList**， 利用 Guava提供了能够推断范型的静态工厂方法生成新的容器；
* 在 testCalabashBoy.java 中使用 **com.google.common.collect.Ordering**中的 **isOrdered**方法来判断排序是否正确，以替代原来的自己构造排序好的数据，并将打乱的数据传入排序，而后一一比较的测试方法；
* 利用 maven 重构原先的代码，并通过了测试。