## 泛型设计
+ 为增加葫芦娃数组和葫芦娃比较器的适用性，新增了两个接口`Named`和`Gendered`用以描述拥有名字的物体和拥有性别的物体。
+ `Gendered`接口中提供了常量`int MALE, FEMALE`，可对外提供统一的性别描述符。
+ 将原`CalabashList`修改为`GenderedList<T extends Gendered>`，这样该数组就可以适用于任何具有性别的物体而不只是葫芦娃。
+ 将原`CalabashComparator`修改为`NamedComparator`这样该比较器将可用于任何有名字的物体的字典序排序。
