## Calabash
葫芦娃类，储存葫芦娃的名字和性别。只提供一个无参构造函数，随机生成一个葫芦娃。静态函数`calabashList(int len)`返回一个随机生成的长度为`len`的葫芦娃数组。

## CalabashComparator
葫芦娃的比较器，只提供了正序和反序两种比较器，乱序排序直接`shuffle`即可。

## CalabashList
继承自`ArrayList<Calabash>`，额外提供了`reversed()`反序遍历器与`randomized()`乱序遍历器，以及函数`maleList()`和`femaleList`用于返回男生队伍和女生队伍。

## CalabashSort
`main`函数类。
