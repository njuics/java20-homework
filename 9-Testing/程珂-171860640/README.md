## HW-Testing

**171960640-程珂**

### HuluBro测试

代码见 `testing/test/HuluBroTest.java`

###### setUpBeforeClass()

注解为：`@BeforeClass`  

在所有测试开始前先初始化 `bro`(用来测试的)，`maxBro`(序号最大) 和 `minBro`(序号最小)

###### 测试 getHuluBro() 方法

注解为：`@Test`

外层循环迭代100次，内层循环迭代7次，判断每个内层循环是否生成了7个颜色不同的葫芦娃

###### 测试 getGender() 方法

注解为：`@Test`

判断 `bro`，`maxBro` 和 `minBro` 的`getGender()` 结果是否和预期的相同

###### 测试 getName() 方法

注解为：`@Test`

判断 `bro`，`maxBro` 和 `minBro` 的`getName()` 结果是否和预期的相同

###### 测试 compareTo() 方法

注解为：`@Test`

判断 `bro`，`maxBro` 和 `minBro` 之间相互比较的结果是否和预期的相同

###### 测试 toString() 方法

注解为：`@Test`

判断 `bro`，`maxBro` 和 `minBro` 转换为字符串的结果是否和预期的相同

### BattleField 测试

代码见 `testing/test/BattleFieldTest.java`

###### setUpBeforeClass()

注解为：`@Before`  

由于构造函数中葫芦娃是乱序排列的，因此在每次执行其他测试方法之前，首先将葫芦娃排序

###### 测试 toString() 方法

注解为：`@Test`

判断`battleField`转换为字符串的结果是否和预期的相同，因为在执行该测试之前会调用`sortBros()` 方法对 `battleField` 进行排序，所以也相当于测试了 `sortBros`

###### 测试 reverseBros() 方法

注解为：`@Test`

判断`battleField`逆序后的结果是否和预期的相同