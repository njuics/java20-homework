# 葫芦娃类Huluwa

数据成员：

`String name`

`Gender gender`



类本身：实现`Comparable<Huluwa>`接口，可用`Collections`进行排序，这里使用泛型，是保证葫芦娃类只可以和同类进行比较操作。

默认构造函数：自定义字母表，用Random类随机生成长度为5的随机字符串，以及`Gender`枚举类型的性别。



# 葫芦娃队伍类HuluwaQueue

数据成员：

`ArrayList<Huluwa> queue`



类本身：实现了`Iterable`接口，可用`for`语句进行遍历和打印，这里使用泛型，是保证`iterator()`接口返回的是`Huluwa`类的迭代器，防止蝎子精等异类混入。

对外方法：对外提供正序，倒序，乱序排序和按性别分两队的方法


# 测试葫芦娃

主要测试HuluwaQueue类的正序排序、倒序排序、按性别分组功能

## HuluwaQueue类

### sortByAsc方法

测试思路

1. 构造7人葫芦娃队伍

2. 调用`sortByAsc`方法

3. `isAsc`变量初值赋为true，用一快一慢两个迭代器逐个比较前后葫芦娃，如果排前面的比排后面的大，则将`isAsc`变量置为false

4. `assertEuqals(isAsc, true)`

***

测试结果

Pass

***

### sortByDesc方法

测试思路

1. 构造7人葫芦娃队伍

2. 调用`sortByDesc`方法

3. `isDesc`变量初值赋为true，用一快一慢两个迭代器逐个比较前后葫芦娃，如果排前面的比排后面的大，则将`isDesc`变量置为false

4. `assertEuqals(isDesc, true)`

***

测试结果

Pass

***

### divideByGender方法

测试思路

1. 构造4*7=28人葫芦娃队伍

2. 调用`divideByGender`方法，得到`maleQueue`和`femaleQueue`两个队伍

3. `isAllMale`变量初值赋为`true`，迭代访问`maleQueue`，如果发现有元素的`gender`属性为`Gender.female`，那么把`isAllMale`变量置为false

4. `isAllFemale`变量初值赋为`true`，迭代访问`femaleQueue`，如果发现有元素的`gender`属性为`Gender.male`，那么把`isAllFemale`变量置为false

5. `assertEquals(isAllMale, true)`

6. `assertEquals(isAllFemale, true)`

***

测试结果

Pass

***