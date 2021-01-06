# HW7

韩畅-171860551

## 新容器

实现了HuLuBabyColl的新容器，底层为ArrarList实现，提供正向、反向的迭代器，Iterable和Iterator对象均可返回。

## 关于随机命名

命名的行为是由老爷爷所实现的而不是在葫芦娃降生时自带的属性，因此，将随机姓名的部分挪到了老爷爷类OldMan中，姓名可以为两个或三个3字符短词，中间字符必为元音，首尾字符基本为辅音，做到随机出的名字基本可以正常读出。也方便之后辨认排序结果。

## 排序方式

在HuLuBaby继承自的character类中添加sex属性。
HuLuBaby实现了Comparable接口，可以按照姓名和性别进行不同优先级的排序，提供一个可以设置葫芦娃内部排序方式的接口以调整排序方式。
HuLuBaby也可以通过返回支持排序功能的Comparator，其实现为匿名内部类。
在HuLuBabyColl类中，实现了通过调用HuLuBaby类的方法进行排序和通过Comparable性质直接排序的两种接口。

## 输出方式

输出和排序均模拟为老爷爷读出自己孩子名单的过程，由主函数内生成的universe调用。打印时通过iterable和iterator均可遍历。

## 不同之处

* Comparable 实例之间相互比较较为方便
* Comparator 可扩展性可能好于Comparable，需要定义不同的比较规则时临时使用更为方便
* Iterable 是一种容器的属性，其中定义了返回Iterator的方法，相当于对Iterator的封装
* Iterator 是迭代器，实现Iterable的类可以再实现多个Iterator内部类，可以通过返回不同Iterator实现不同的遍历方式，更加灵活。