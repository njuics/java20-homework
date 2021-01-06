在第七次作业基础上修改

新增两个类CalabashFire 水娃和CalabashWater 火娃 继承自Calabash

增加一个葫芦娃的特殊行为act()表示这个葫芦娃可以干什么



用泛型实现集合框架CalabashCollection<T extends Calabash>

里面有增加元素操作add()和打印整个容器内容的操作print()

随机使用两种方法进行乱序 升序和降序的排序



用泛型实现主类Main<T extends Calabash>

分别对三个集合Calabash集合 CalabashFire集合 CalabashWater集合进行了排序和分类操作

这种在所有原来需要Calabash类的地方使用泛型<T extends Calabash>的好处是

1.类型安全,这种有界类型编译器会在编译阶段进行检查

2.减少可能存在的向下转型的强制转换错误

3.代码复用

