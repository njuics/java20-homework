# 作业8-泛型



#### 修改的类型

1：定义了新的类Creature生物类，拥有名字和性别属性。

`public class Creature{...}; `

2：葫芦娃类继承Creature类。

```java
public class Calabash extends Creature implements Comparable<Calabash>{...};
```

3：定义了新的类型`Golbin`类，继承Creature类。

```java
public class Golbin extends Creature {...}
```

4:在作业7的基础上修改了Family家族类。作业7中我们设计的类只能构造葫芦娃家族类，利用泛型机制我们可以构造任何Creature类派生的类的家族，比如葫芦娃家族、妖精家族等等。

```java
public class Family <T extends Creature >implements Iterable<T>{...}
```

5:修改了`Comparetor`使得所有Creature类及它的子类之间能进行比较。

```java
class CalaBash_Comparetor implements Comparator<Creature>...
//逆序比较
class CalaBash_Comparetor_normal implements Comparator<Creature>...
//正序
class CalaBash_Comparetor_gender implements Comparator<Creature>...
//用于按男女分组
```

6：修改Family类里的一系列相关函数



#### 泛型的优点

1：使用泛型可以提高代码的复用性，可以很方便地创建类型不同但又有很多相同性质的群体，比如家族类，对不同家族的管理相同但家族之间的类型不同。

2：减少强制类型转换等操作，类型错误可以在编译时被捕获从而提高程序的安全性。

