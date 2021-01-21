# 测试使用说明：

对hulusort的两个子类orchestration和choreography进行了test

首先是正常的输入



![22](java_picture/22.png)

![1605322661638](java_picture/25.png)

testpass



在orchestration中的测试中输入负数种子 expect exception

![1605322473881](java_picture/24.png)

![23](java_picture/23.png)

# 泛型使用说明：	

设置了新类型posqueue<E>

![19](java_picture/19.png)

因为java中的擦除机制，所以java不支持泛型数组。

于是用这种方式进行数组的实现。

支持对queue的修改，获取。

同时在sort中定义葫芦娃序列posqueue<HuLuWa>

并对初始化方式进行修改。

![20](java_picture/20.png)

同时sort方法也进行了变化。

![21](java_picture/21.png)

# 面向对象特性使用说明：	

## 封装

![1](java_picture/1.jpg)

设置枚举类HuluColor 用于维护葫芦娃的颜色，名字，以及对应颜色用来排序的权值。

将权值和名字设置为private，同时设置getvalue以及getname函数作为外部接口实现对葫芦娃名字和权值的封装。

## 继承：

设置一个基础的类hulusort作为父类，内含一个abstract函数sort，以及一个final前缀修饰的函数print

![2](java_picture/2.png)

并设置2个子类 orchestration和choreography继承hulusort类，并在2个子类中分别实现不同的sort函数。

![3](java_picture/3.png)

![4](java_picture/4.png)

## 多态：

对于hulusort类中的abstract函数sort在orchestration类和choreography类中进行不同的实现。

![6](java_picture/6.png)

![5](java_picture/5.png)

## 合成：

在HuLuWa类中强合成了枚举类HuluColor

![7](java_picture/7.png)





# 面向对象语言机制使用说明：	

## 构造器：

HuluColor类 、HuLuWa类 以及hulusort类都含有一个构造器

![10](java_picture/10.png)

初始化葫芦娃的名称和颜色对应权值



![8](java_picture/8.png)

初始化葫芦娃的颜色



![9](java_picture/9.png)

初始化需要排列的葫芦娃队列的具体信息



## 修饰符

abstract:

![11](java_picture/11.png)

private:

![12](java_picture/12.png)

​																							(...)

public:

![13](java_picture/13.png)

​																						（...）

## 包

![15](java_picture/15.png)

​														将Granpa，HuluColor，HuLuWa类打包

![16](java_picture/16.png)

​																			在主程序中引用packet

# 数据结构 类图：

![14](java_picture/14.png)

# 输入输出：

## 输入

输入葫芦娃的初始序列

0表示大娃 1表示二娃...（没有设置输入正确性检查，默认输入合法）

![17](java_picture/17.png)

## 输出

输出葫芦娃的初始队列以及2种方式下葫芦娃排序后的结果

![18](java_picture/18.png)