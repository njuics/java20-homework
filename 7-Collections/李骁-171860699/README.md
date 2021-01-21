# 葫芦娃类Huluwa

数据成员：

`String name`

`Gender gender`



实现`Comparable<Huluwa>`接口，可用`Collections`进行排序

自定义字母表，用Random类随机生成长度为5的随机字符串，以及枚举类型的性别



# 葫芦娃队伍类HuluwaQueue

数据成员：

`ArrayList<Huluwa> queue`



实现了`Iterable`接口，可用`for`语句进行遍历和打印

对外提供正序，倒序，乱序排序和按性别分两队的方法