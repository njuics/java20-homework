# A-Build

## 升级葫芦娃
利用`org.apache.commons.lang3.RandomStringUtils`生成随机字符串，以此来为生成的葫芦娃附随机名称
同时编写了相关的test去测试在随机数量、随机名字、随机性别的葫芦娃排序是否正确（利用Collections对生成的字符串排序，两者结果进行比较）

## 自动构建
构建的包为`com.nju.cqx`，指定了上述所需依赖并加入了`junit`相关依赖，从而可以使用`mvn test`继续执行测试


# 9-Testing

## 测试方向

我们主要从以下几个方面测试：测试比较`Calabash`类对象是否相等的结果（即`Calabash.equals`()函数）是否正确、测试`Calabash`表正序、逆序排序（即`CreatureSort.doCalabashSort()`和`CalabashBoys.Sort()`）结果是否正确、测试`CalabashBoys`类里的`getBoyCalabashs()`和`getGirlCalabashs()`能否得到正确结果、测试对各种种类的`Creature`排序结果是否正确。



# 8-Generics

## 比较器

`CreatureAscendingComparator` 和 `CreatureDesscendingComparator` 使用了泛型类型，其中`T extends Creature`，这样比较器就能对Creature的某一个具体子类进行比较，并且实例化后只能针对该类型及其子类排序（例如`Calabash`和`Monster`都是`Creature`子类，但`Calabash`和`Monster`两者无父子关系，那么`CreatureAscendingComparator<Calabash>`就不能对两个`Monster`排序。