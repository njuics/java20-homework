共两个`.java`文件，分别用`Comparator`和`Comparable`来进行排序时的比较

`Hulus`类描述了葫芦娃的属性（名字与性别）和构造函数

`Positive/Negative`类实现了`Comparator<Hulus>`的比较器

`HuluSort`类中有三个static排序方法，分别对应字典序的正序、倒序和乱序

`CollectionHulu/CollectionHulu2`类中主要是一些必要的静态字段和静态方法，`get_name(n)`负责生成长度为n的随机名字，`printH()`负责打印结果，`SortAndPrint()`负责分别运行三种不同的排序方法并打印，`GenderDivide`对葫芦娃的性别进行区分，并返回对应性别的葫芦娃构成的的集合容器

注意葫芦娃数目默认为20，葫芦娃名字长度默认为5
