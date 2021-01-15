### 在第七次作业基础上修改

新增两个类CalabashFire 水娃和CalabashWater 火娃 继承自Calabash

增加一个葫芦娃的特殊行为act()表示这个葫芦娃可以干什么

</br>

用泛型实现集合框架CalabashCollection<T extends Calabash>

里面有增加元素操作add()和打印整个容器内容的操作print()

随机使用两种方法进行乱序 升序和降序的排序

</br>

用泛型实现主类Main<T extends Calabash>

分别对三个集合Calabash集合 CalabashFire集合 CalabashWater集合进行了排序和分类操作

这种在所有原来需要Calabash类的地方使用泛型<T extends Calabash>的好处是

1.类型安全,这种有界类型编译器会在编译阶段进行检查

2.减少可能存在的向下转型的强制转换错误

3.代码复用

</br>

### 第八次作业基础上修改

对葫芦娃容器增加返回葫芦娃姓名和性别的操作，便于进行测试

将原有的Main类中的main()方法注释

编写测试类MainTest

对两组数据进行测试

第一组为较简单数据

第二组为较复杂数据

每一组数据的初始数据为init_str*1~2*和init_gender*1~2*

预期结果为expected1,expected2,expected3,expected4

分别表示升序排序姓名的结果，降序排序姓名的结果，对初始数据进行MALE分类的结果，对初始数据进行FEMALE分类的结果

test**1~8**交替用不同的葫芦娃类来替代Main类中的T，进行两组数据的处理，

用Assert.assertArrayEquals()来比较预期结果与Main类的计算结果

<br>

编写TestCore类

对MainTest的结果进行处理，输出所有没有通过的测试，以及测试是否全部通过的判断