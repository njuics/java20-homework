# Generics

运用泛型进行改写了：

* 存放葫芦娃的容器类 **CreatureList** 类，以及其涉及的 **iterator** 等
* 比较器 **Comparator**



### 代码修改

1. 重新定义**Creature** 用于抽象生物，由于World 中存在的生物不止葫芦娃一种，故需让葫芦娃作为其子类存在；同时可以方便使用泛型进行容器操作。
2. 将原有的`CalabashList` 通过泛型改写为 `public class CreatureList<T extends Creature> implements Iterable<T>`
3.  将原来的接口`HuluwaComparator` 改写成了泛型`CreatureComparator`。



### 获得好处

1. 消除了源代码中的强制类型转换，例如直接把Calabash向上转型为Creature的情况。
2. 限制类型，例如进行add操作时，若非Calabash的其他继承自Creature类，可以防止其放入容器
3. 有效的提高了代码复用率。