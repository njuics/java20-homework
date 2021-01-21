# README

## test.CalaBroSortTest

用于测试葫芦娃排序结果

```java
@BeforeClass
public static void init()
```

用于初始化葫芦娃序列，生成用于排序的葫芦娃

```java
@Test
public void testCalaBroNum() throws Exception
```

用于测试葫芦娃是否正确生成1-20个，不在该范围则抛出异常

```java
@Test
public void testSort() throws Exception
```

用于测试葫芦娃的正序全排序、逆序全排序、正序性别排序、逆序性别排序的顺序是否正确

其中，性别排序要增加一项测试，测试是否正确分为了male和female两个队列

```java
private boolean judgeOrder(List<CalaBro> list, int mode)
```

用于判断一个list是否满足mode模式下的顺序

```java
private boolean judgeSex(List<CalaBro> list)
```

用于判断一个list是否被区分为两个性别序列