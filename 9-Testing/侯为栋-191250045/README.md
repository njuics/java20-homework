# Testing

重构了葫芦娃代码，添加了测试文件`SortTest.java`。

## GrandPa

是`God`的一个子类，可以对其掌控的`Creature`，本处特指`Calabash`进行排序、打乱等操作。

可以通过不同的标准进行排序。目前可用的标准是`name`，`name_reverse`，`sex`，`sex_reverse`，`random`。

`sex`的实质将不同性别的孩子分开来，然后内部用默认即`name`标准排序。

## SortTest

`@Before`是初始化`GrandPa`的方法，`GrandPa`是方法的载体。

`nameSort`是用`name`作为比较标准测试的排序，有正序和反序。

`sexSort`类似。

`randomSort`测试的是乱序，即打乱队列顺序。
