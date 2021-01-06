# 依赖
## RandomStringUtils
这个函数在`org.apache.commons.lang3`中

在生成随机名字的时候使用了，详见`Huluwa.java`的构造函数

## Ordering
这个结构在`com.google.common.collect`中

Ordering是Guava类库提供的一个犀利强大的比较器工具，Guava的Ordering和JDK Comparator相比功能更强。它非常容易扩展，可以轻松构造复杂的comparator，然后用在容器的比较、排序等操作中。

这里我主要在test中使用，用其`isOrdered`方法来对`HuluBro`的结果进行一个验证

`assertTrue(testHulu.isOrdered(hulu.getItertable()));`

这里为了能够正常使用，实现了`getItertable()`函数来返回`HuluBro`成员的`Itertable`
