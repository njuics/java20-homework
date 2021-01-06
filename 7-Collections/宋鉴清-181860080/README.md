### 集合框架的容器类

（1）在随机生成姓名的时候，采用`HashSet`来存储已经生成过的姓名，防止出现重复姓名。

（2）这里采用`ArrayList`来存储葫芦娃的家族信息。

### 排序

（1）在葫芦娃类`Gourd`中，实现`Comparable`的接口，定义一个`CompareTo`函数

（2）再定义一个类`NegativeSort`，该类实现`Comparator`的接口，定义一个`compare`函数

（3）通过`Collection.sort()`进行三种排序

### 迭代器

（1）定义一个类`GourdIterator`，实现`Iterator`的接口，在其中定义`hasNext`和`next`函数

（2）定义一个类`GourdIterable`，实现`Iterable`的接口，在其中定义`iterator`函数

### 实现功能的类

定一个`GourdFamily`，生成所有需要的可迭代对象

`BeginIterable`、`positIterable`、`negaIterable`、`chaosIterable`、

`malepositIterable`、`malenegaIterable`、`malechaosIterable`、

`femalepositIterable`、`femalenegaIterable`、`femalechaosIterable`，

在外部，只需要定义一个`GourdFamily`实例，即可通过调用这些可迭代对象，进行`for each`循环。