# Huluwa
这个类以`Random`包来随机生成葫芦娃的名字，名字长度在5-10

继承`Comparable`类并重写`compareTo`函数，这是一个排序方法

同时利用比较器`Comparator`来进行排序

利用成员变量`order`来选择不同的排序方式

1. 升序
2. 降序
3. 乱序

# HuluBro
此类成员变量为`ArrayList`，使用泛型控制类型为`Huluwa`

如果是使用`compareTo`来排序则全部初始化`order`后利用`Collections.sort`方法进行排序

如果是使用`Comparator`来排序则传递`order`调用`getComparator`，使用返回的比较器来调用`Collections.sort`方法进行排序

由于没想到很好的使用`Iterable` 与 `Iterator`的方法，所以没有强行使用