# homework 08

## 类型设计
类`Creature`：是所有生物（葫芦娃、蛇精等）的父类，负责保存每个生物的姓名`name`和所在队列的位置`position`，并实现了`Comparable`接口，将`name`按照字典序比较，为后续的队列排序做准备。    

类`Calabash`：用于存放葫芦娃对象，继承自类`Creature`，另存放每个葫芦娃的性别，枚举类`Gender`，实现方法`numberOff`，使得每个葫芦娃能够报数。

枚举类`Gender`：存放葫芦娃的性别：MALE和FEMALE。

类`Grandpa`：实现接口`Comparator`，可以作为比较器类型实现葫芦娃队列的排序。

类`IterableQueue`：对葫芦娃队列的封装，实现将队列按照正序、倒序和随机排列的方法。

类`Position`：位置的封装类，作为引用，记录了对象在队列中的位置`position`。

接口`Rand`：实现随机生成葫芦娃姓名和性别。

类`SortAdapter`：随机算法的适配器，能够对传入`IterableQueue`进行正序、逆序和随机排列，并能让葫芦娃按顺序报数。

## 泛型应用
`IterableQueue<T extends Creature>` : 传入一种继承自`Creature`类的类型的队列，该队列在外部保证单一类型，使得目前可以排序的队列中只有一种生物（葫芦娃、蛇精等）。同时由于父类型`Creature`实现`Comparable`接口，使得该队列中存放的都是可以排序的类型。

`SortAdapter<T extends Creature>`：将排序算法的适配器传入泛型，这样做可以保证每次进行排序的对象都是类`Creature`的子类，并且由于其中的排序算法持有`IterableQueue`的引用，所以能够保证排序的时候对同一个类型的对象进行排序。通过复写`Creature`类的`CompareTo`方法，就能够实现不同规则的排序。

## 测试
方法`testCalabash`：对产生葫芦娃队列的`IterabaleQueue`进行测试，验证其中保存的每一个对象都为`Calabash`实例。

方法`testOrder`：对排序算法的正确性进行测试，测试经过排序后队列中保存的葫芦娃对象按照字典序顺序排列。

方法`testEfficiency`：对排序算法的效率进行测试，设置限制时间为1000ms。