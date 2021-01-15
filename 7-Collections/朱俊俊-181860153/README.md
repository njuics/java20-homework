### Calabash

保存名字和姓名，通过`public static Calabash randomCalabash()`提供随机葫芦娃。

实现了`Comparable`接口，比较名字的字典序。



### CalabashComparator

葫芦娃比较器，默认提供升序比较器。(`CalabashComparator()`)

也可以提供降序比较器(`CalabashComparator().reversed()`)和随机比较器(`CalabashComparator().random()`)。



### CalabashQueue

保存葫芦娃的队列，内部用`ArrayList`保存葫芦娃。

实现了`iterable`接口和`iterator`迭代器以供遍历。



### Main

通过`Comparable`,`Comparator`分别排序，`iterable`和`iterator`分别遍历输出。

`Comparable`为类提供了默认的序关系，而各种不同的`Comparator`可以更灵活的提供序关系。

`iterable`的实现实际上使用了`iterator`，但`foreach`语法更利于使用，而通过多种`iterator`同样可以实现不同的迭代方式。

