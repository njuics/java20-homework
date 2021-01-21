## 集合框架应用

* 用`Hulu`类表示单个葫芦娃，该类实现了`Comparable`接口并重写了`compareTo()`方法以实现排序；在其构造函数中使用一个`Random`对象随机生成名字和性别。
* 在`HuluCollection`类中使用`List`容器（底层实现为`ArrayList`）存放葫芦娃们，同时该类实现了`Iterable`接口，并在内部实现了`Iterator`接口以提供迭代机制的对象，从而使存放葫芦娃的集合对象`huluList`可迭代，实现排序。
* 乱序排序可通过`Java.util.Collections`类下的一个静态方法`shuffle()`实现；同样地，基于`Hulu`类中重写的`compareTo`方法，使用`Collections`中的`sort`方法可实现葫芦娃的正序排序；而对于反序排序，可以利用实现了`Comparator`接口的`compare`方法来完成。