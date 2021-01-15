## 文件变更

新增`cn.edu.nju.Test` 包，里面存放着`TestHuLuWa`类，该类使用了Junit4针对葫芦娃的排序工作进行了多种单元测试

## 测试方法 cn.edu.nju.Test.TestHuLuWa

### 私有属性

- `battleField`战场类对象，本次采用3行10000列的战场进行测试
- `mediumRow` 取战场中间一行，方便后续排序指定行
- `huLuWaNum` 在战场中存在的葫芦娃总数，本次选用1000个葫芦娃
- `oldMan` 爷爷对象

### 资源的初始化和回收

1. 使用被`@BeforeClass`标注的`init()`方法进行对象的初始化。
2. 使用被`@AfterClass标注`的`clear()`方法进行对象的回收处理。

### 测试单列排序正确性 testSortInRow

首先调用`HuLuWa类`的静态方法让葫芦娃在战场中间一行正向排序，之后调用战场类的方法将这一行取出，并交由`assertHuLuWa` 确保其全部是葫芦娃，交由`assertSorted`方法判断是否有序。

### 测试多列排序正确性 testSortInRows

首先调用`HuLuWa类`的静态方法让葫芦娃在战场中间两行分性别正向排序，之后调用战场类的方法将这一行取出，并交由`assertHuLuWa` 确保其全部是葫芦娃，交由`assertBoy`，`assertGirl`方法判断性别正确与否，交由`assertSorted`方法判断是否有序。

### 简单测试单列排序时间 testSortTime

`@Test(timeout = 1000)`标注该方法后在方法内调用排序方法。