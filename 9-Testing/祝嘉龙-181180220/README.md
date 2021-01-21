## CalabashComparator
葫芦娃的比较器，只提供了正序和反序两种比较器，乱序排序直接`shuffle`即可。

## CalabashList
继承自`ArrayList<Calabash>`，额外提供了`reversed()`反序遍历器与`randomized()`乱序遍历器，以及函数`maleList()`和`femaleList`用于返回男生队伍和女生队伍。

## CalabashSort
`main`函数类。

## 泛型设计
+ 为增加葫芦娃数组和葫芦娃比较器的适用性，新增了两个接口`Named`和`Gendered`用以描述拥有名字的物体和拥有性别的物体。
+ `Gendered`接口中提供了常量`int MALE, FEMALE`，可对外提供统一的性别描述符。
+ 将原`CalabashList`修改为`GenderedList<T extends Gendered>`，这样该数组就可以适用于任何具有性别的物体而不只是葫芦娃。
+ 将原`CalabashComparator`修改为`NamedComparator<T extends Named>`这样该比较器将可用于任何有名字的物体的字典序排序。


## 单元测试
+ `CalabashTest`用于测试能否顺利地随机生成葫芦娃，以及静态的`calabashArray()`方法。
+ `GenderedListTest`用于测试泛型容器`GenderedList`的正确性，为此在其中提供了实现了`Gendered`接口的内部类`Testobj`用作元素。共测试了`maleList()`、`femaleList()`、`reversed()`三个方法的正确性。