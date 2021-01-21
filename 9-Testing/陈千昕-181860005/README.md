# 9-Testing

## 测试方向

我们主要从以下几个方面测试：测试比较`Calabash`类对象是否相等的结果（即`Calabash.equals`()函数）是否正确、测试`Calabash`表正序、逆序排序（即`CreatureSort.doCalabashSort()`和`CalabashBoys.Sort()`）结果是否正确、测试`CalabashBoys`类里的`getBoyCalabashs()`和`getGirlCalabashs()`能否得到正确结果、测试对各种种类的`Creature`排序结果是否正确。



# 8-Generics

## 比较器

`CreatureAscendingComparator` 和 `CreatureDesscendingComparator` 使用了泛型类型，其中`T extends Creature`，这样比较器就能对Creature的某一个具体子类进行比较，并且实例化后只能针对该类型及其子类排序（例如`Calabash`和`Monster`都是`Creature`子类，但`Calabash`和`Monster`两者无父子关系，那么`CreatureAscendingComparator<Calabash>`就不能对两个`Monster`排序。