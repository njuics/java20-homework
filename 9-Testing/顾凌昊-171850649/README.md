# 为葫芦娃构建JUnit单元测试
## 类和功能介绍
1、安装JUnit4库，以供单元测试使用；  
2、新建GrandpaTest类，对Grandpa类（葫芦娃管理器类）进行单元测试；  
3、测试包括以下单元：  
+ `testInstance`：测试Grandpa类的单例模式是否正确起效
+ `testAdd`：测试Grandpa类添加Huluwa对象的方法是否起效
+ `testSwap`：测试Grandpa对两个葫芦娃进行交换的方法是否起效
+ `testSort`：测试Grandpa对葫芦娃按姓名字典顺序排序的方法是否起效
***
# 上个版本（泛型）的改动
## 整体改动
1、为便于显示泛型的作用、实现代码的单一职责，只保留了orchestration部分的管理方法（使用一个管理类来进行排序等操作）；  
2、将不同功能的代码存放于character、main、utils三个package中，使其更有条理性；  
## 对Human基类的改进
1、增加了性别这一属性，以布尔型变量表示（`true`：男性；`false`：女性），并对构造器、报数方法做了相应修改；   
2、支持初始化时随机生成性别、姓名；  
## 对Huluwa类的改进
1、不再实现`Comparable`接口，其比较改由Grandpa类完成；  
2、删除序号这一属性，排序以姓名的字典顺序进行；  
## 对Grandpa类的改进
这部分内容是本次改动的精华所在。  
1、将对葫芦娃管理的方法抽象成一个接口`HumanController<T extends Human>`，其中包括添加、删除、排序、打印等管理方法。该接口复用性强：爷爷类实现该接口时传入的是Huluwa类，以后如果写妖怪管理类的时候则可以传入其他类加以实现；  
2、实现了`Comparator<Huluwa>`接口，支持对葫芦娃的比较（根据姓名字典顺序）
