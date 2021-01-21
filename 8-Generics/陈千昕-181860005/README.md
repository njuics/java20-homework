# 8-Generics

## 比较器

`CreatureAscendingComparator` 和 `CreatureDesscendingComparator` 使用了泛型类型，其中`T extends Creature`，这样比较器就能对Creature的某一个具体子类进行比较，并且实例化后只能针对该类型及其子类排序（例如`Calabash`和`Monster`都是`Creature`子类，但`Calabash`和`Monster`两者无父子关系，那么`CreatureAscendingComparator<Calabash>`就不能对两个`Monster`排序。
