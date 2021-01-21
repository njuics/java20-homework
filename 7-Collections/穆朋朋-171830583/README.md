# 171830583 穆朋朋 homework7
### 类：

1. `Calabash`：葫芦娃，拥有要求的性别和姓名属性；
2. `CalabashList`: 葫芦娃队伍，可以完成要求的对其中葫芦娃排序的任务；其中使用`ArrayList`\<Calabash\>的对象存储葫芦娃，这里使用了泛型，可防止队伍中混入蝎子精等异类。
3. `ComparatorReverse`：葫芦娃反向比较器，用于葫芦娃队伍的反向排序；
4. `Main`：主类，其中完成要求的任务；

### 任务实现细节：

1. 在`Main`.main()函数中，新建了10个葫芦娃，它们的性别和姓名随机，姓名是长度1到7个字母或数字组成的字符串，长度随机，字符随机。
2. `CalabashList`中使用了集合框架中的`ArrayList`容器类来存放葫芦娃，且实现了按照字典序的正序，反序，乱序等排序方法：sortByName()、sortByNameReverse()、sortByNameShuffle()和打印方法：outputList()；
3. `CalabashList`中实现getMaleList()方法来获得此葫芦娃队伍中的性别为male的葫芦娃组成的子队伍；类似的，getFemaleList()返回性别为female的子队伍；由于子队伍类型仍未`CalabashList`，可以直接使用该类的排序和打印方法；
4. `CalabashList中`的`ArrayList`\<Calabash\>使用了泛型。在`CalabashList`的打印时使用了迭代器`Iterator`。`ArrayList`使用`Collections`.sort()排序时对需要`Calabash`实现`Comparable`或者提供比较器`Comparator`，我两种方式都有尝试：实现了`Calabash`的`Comparable`接口，并在正序sortByName()使用`Collections`.sort()直接排序；实现`ComparatorReverse`类的`Comparator`接口，并在反序sortByNameReverse()中使用`Collections`.sort()和比较器`CompartorReverse`进行排序。