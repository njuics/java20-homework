# 葫芦娃类Huluwa

数据成员：

`String name`

`Gender gender`



类本身：实现`Comparable<Huluwa>`接口，可用`Collections`进行排序，这里使用泛型，是保证葫芦娃类只可以和同类进行比较操作。

默认构造函数：自定义字母表，用Random类随机生成长度为5的随机字符串，以及`Gender`枚举类型的性别。



# 葫芦娃队伍类HuluwaQueue

数据成员：

`ArrayList<Huluwa> queue`



类本身：实现了`Iterable`接口，可用`for`语句进行遍历和打印，这里使用泛型，是保证`iterator()`接口返回的是`Huluwa`类的迭代器，防止蝎子精等异类混入。

对外方法：对外提供正序，倒序，乱序排序和按性别分两队的方法