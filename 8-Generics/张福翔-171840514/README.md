# 作业 8 提交说明 by 张福翔-171840514
### 作业说明
请在你现有的葫芦娃代码中使用泛型进行改写（改进），并更新Readme文件进行具体说明（用泛型改了哪些类型，为什么这样改，获得了哪些好处等）。

### 重构情况

- 为了减少与当前需求无关的代码量, **我们删除了作业3的API接口! 这意味着本次提交作业不能复现作业3中的实现情况! 需要复现实验3的结果, 请查看前几次的作业项目**. (实际删除的类与接口包括`ArraySorter`和`Sortable`)
- 由于上次实现中的`IterableArrayList`类与Java中的`ArrayList`实现几乎没有差别, 上次的项目实现目的是为了熟悉`Iterable`和`Iterator`接口, 本次实现中我们删除了`IterableArrayList`类.
- 为了更好的封装排序相关类, 我们利用`Comparator`接口实现了正序, 逆序和乱序的比较模块. 现在可以通过在`sort`函数中改变相应的`Comparator`, 就能指定不同的排序类型. 为此我们实现了`InOrderComparator`, `ReversedComparator`和`RandomComparator`分别进行顺序, 逆序和乱序排序.
- 重新设计了一些接口. 由于我们的作业最终是一个具有GUI的游戏程序, 我们设计了新的`core` package, 并在其中设计了`Controller`类, 其作为本次实验的核心控制器. 运行时, 我们的引导程序`Runner`将创建`Controller`对象, 随后由其进行控制.
- 将控制葫芦娃排列的代码逻辑转移到爷爷身上实现, 更为符合实际情况, 环境创建时默认先创建爷爷对象.
- 修改各个生物对象的`toString`方法, 使其打印更易读.

### 泛型相关使用情况

- 创建的三种比较子`InOrderComparator`, `ReversedComparator`和`RandomComparator`均为泛型设计, 可接受任何实现了`Comparable`接口的类型. 
- 在生物基类`Creature`中实现`Comparable`接口, 在葫芦娃类`HuluBaby`中进行重写.
- 在环境`PlayGround`类中, 所有创建的生物都写入`Creature`容器中. 并在实际运行时根据具体类型进行不同的调用.

