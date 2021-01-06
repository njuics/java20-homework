# HW 8

## 类型设计

设计了基类 `Creature`，有随机生成的姓名和性别。`Creature` 实现了 Comparable 接口，按姓名的字典序排序

从 Creature 派生出了葫芦娃和怪物，其中葫芦娃没有新增属性，怪物新增了攻击力，并且重载了基类的 `compareTo` 方法，如果对方也是怪物就比较攻击力，否则比较姓名

## 泛型

设计了泛型方法来对生物进行排序，其类型参数为 `<T extends Comparable<? super T>>`，表示接受的类型必须实现 `Comparable` 接口，且比较的对象类型为 T 或者 T 的基类，写成这样是为了能对派生类的容器进行排序。如果写成 `<T extends Comparable<T>>` 的形式则不能排序 `List<HuLuWa>`，因为其 `compareTo` 方法继承自基类，方法签名为 `int compareTo(Creature o)`，不符合 `Comparable<HuLuWa>`

在 Main 中生成了三种类型的容器 `List<Creature/HuLuWa/Monster>`，使用了上述类型参数的排序方法能对三类容器排序，除此之外也声明了一个 `List<List<? extends Creature>>` 的变量，将上述三个容器再存入一个 List 中，这也体现了泛型通配符的应用