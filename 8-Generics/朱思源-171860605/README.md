# 8 Generics

## 类型设计

将原有的Calabash集合类改为Creature集合类，新增Monster类，Calabash和Monster继承Creature类

## 范型设计

改写了原有的排序函数，利用范型<T extends Comparable<? super T>可以对Creature、Calabash和Monster同时进行排序，避免了对每个类都实现一遍排序算法