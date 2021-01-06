# 简介

总共有两个主要类<font color=#FF0000 >**CalabashBrothers**</font>和<font color=#FF0000 >**GrandFather**</font>类、一个<font color=#FF0000 >**辅助排序接口Sort**</font>以及<font color=#FF0000 >**实现了Sort接口的GrandFatherSort**</font>类以及<font color=#FF0000 >**继承了GrandFatherSort类的CalabashBrothersSort类**</font>。



## CalabashBrothers类

**葫芦娃类**，拥有**记录葫芦娃的名字（name）**、**排行老几（number）**以及**已经出生的葫芦娃的数量（静态变量count）**。有两个参数不同的<font color=#FF0000 >**构造函数**</font>用于不同需求下创建葫芦娃；有一个**changePlace静态方法**用于交换两个葫芦娃；有一个**lineUpByOurseives静态方法**用来实现葫芦娃之间互相配合排序（本质为冒泡排序）：从第一个葫芦娃开始，不断和后面的葫芦娃比较，如果弟弟在前面就和后面一个的哥哥交换位置，不断重复直到排序完成。



## Grangfather类

爷爷类，拥有长度为7的一个**葫芦娃数组（brothers）**和一个用于**记录葫芦娃排行的int数组idx**。有一个<font color=#FF0000 >**构造函数**</font>实现创建出七个葫芦娃；一个**lineUpByGrandfather**的本质为快排的葫芦娃排序方法。



## Sort<font color=#FF0000 >**接口**</font>

有一个**抽象方法Sort**用来实现各种各样的排序。



## GrandFatherSort类

GrandFather类使用的排序类，<font color=#FF0000 >**实现**</font>了Sort接口的Sort方法。



## CalabashBrothersSort类

CalabashBrothers类使用的排序类，<font color=#FF0000 >**继承**</font>并重写覆盖了GrandFather类的Sort方法。



## 其他特性

### 封装

多处变量设置为私有变量并完成了Setter、Getter方法。

### 多态

```java
Sort sort = new GrandFatherSort();
sort.Sort(brothers, 0, 6);

Sort sort = new CalabashBrothersSort();
sort.Sort(brothers, 0, 6);
```

### 静态代码块

```java
static{
    count = 0;
}
```

### 包

```Java
package 林正顺-191250088.3-OOAdvanced.java20-homework.linzs148;
```



## [类图链接](http://www.plantuml.com/plantuml/png/hP0nRuCm48Lt_ueRGO7yWWnH8hNgr4fHfwh3OIx1aZagsqIjQFvxmOuQm56oX07hdjxxxjbhwz2ujjPYgz5QsAB60csrCOsho5Ze1FHVrzkSagTSiGFPjEoyx4Tkwu9Cc7VEA3u0OqrUyB_579fSOXcC8kbTUpffipWsgWHP8H_eJQEa9AhVC4dKWrG4AOF8uu-fA-m9VAsOthysFw-jiQIEPACj7vzmpjbKdCJvAPyDSlc4Wzm5d6BNMrNv7Hxh1aQ4m0YH_8UlTVF6VJ3UQ_V2ZimU9S6kCQuRqORvLZm3nGvqE8o7oVbL7yQSPnu0dhjXjLoEkuk12QlVgJg8OZm7KvvVgnWvenrnA9WYcbWJbssj_m00)