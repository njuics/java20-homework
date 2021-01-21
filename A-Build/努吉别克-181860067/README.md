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

#### 测试

##### 测试类--`SortTest`类

​	对家族类中实现的各类排序算法进行了测试

​	1：定义家族类成员

```java
Family new_family=new Family<Calabash>();
```

​	2：`@BeforeClass`和`@AfterClass`在类被实例化前（构造方法执行前)被调用

```java
@BeforeClass
public static void test_normal()throws Exception{...}
```

```java
@AfterClass
public static void AfterClass()
{
    System.out.println("AfterClass");
}
```

​	3:在每个`@Test`执行前会被执行一次,添加葫芦娃

```java
@Before
public void Setup()...
```

​	4:在每个`@Test`执行后都会被执行一次

```java
@After
public void reset()
{
    new_family.clear_family();
}
```

​	5:测试代码

```java
public void test1() throws Exception//测试正序排序是否正确
```

```java
public void test2() throws Exception//测试逆序排序算法（基于比较器）
```

```java
public void test3() throws Exception//测试正序排序，逆序输出算法
```

```java
@Test(timeout = 0)
public void testSort() throws Exception //测试逆序排序时间
```

```java
@Test(timeout = 10)//测试女生队状态
public void testSort_team_girl() throws Exception 
@Test(timeout = 100)//测试男生队状态
public void testSort_team_boy() throws Exception
```

#### 自动构建

1:使用了`apache.commons.lang3.RandomStringUtils`用于随机生成名字

2：利用maven自动导入`junit包测试代码`

3：使用`google.common.collect.Ordering`用于排序、在测试中用于判断排序结果是否正确