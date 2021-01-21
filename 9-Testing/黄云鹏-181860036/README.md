## GourdBaby类
* 拥有三个属性，String类型的姓名、性别和int类型的年龄
* 其中三个属性分别都有限制：
  * 姓名非空，且首字母大写
  * 性别只能使用GourdBabySex类中的两个静态String，即"male"和"female"
  * 年龄不能为负数
* 因此在构造函数中会分别调用这些属性的setter方法，若不满足上述限制，将抛出相应的异常
* 拥有几个其他成员方法，包括年龄比较和交换方法，用于按年龄从小到大排序中
***
## GourdTest类
* 拥有许多@Test方法，为葫芦娃类进行一系列的测试：
  * testSetNameEmpty() 用于测试姓名为空的异常
  * testSetNameLowerCace() 用于测试姓名首字母小写的异常
  * testSetSexNotExist() 用于测试性别非"male"或"female"的异常
  * testSetAgeNegative() 用于测试年龄为负数的异常
  * testSort() 用来测试bubbleSort()排序算法的耗时
* 拥有几个其他成员方法，包括随机产生一个葫芦娃和冒泡排序算法
***
***
