##  面向对象编程思维解决葫芦娃排序问题

#### 用程序当中的对象模拟现实中葫芦娃的排序问题

​		对于orchestration的方式，我们让爷爷作为一个指挥者，指挥葫芦娃们进行队伍整理。其在程序中表现为爷爷对象，每次与一对葫芦娃对象的交互过程，爷爷对象通过command()方法指挥这两个葫芦娃对象是否需要调整顺序。程序的指挥过程这与我们现实情况中指挥队伍调整是类似的。

​		对于choreography的方式，葫芦娃之间相互交流调整队伍，在程序中表现为一个葫芦娃对象与另一个葫芦娃对象交流的过程，communicate()方法模拟两个葫芦娃对象的交流过程，在交流过程中发现排队错了就交换顺序，排队正确就暂时不调整。



## 面向对象特性

#### 封装

​		在程序中，主要设计的类有排序的主类LineUp，人物类Human、Hulu、Grandpa。对数据进行了封装，对外提供对数据操作的接口。

#### 继承

​		葫芦和爷爷都是人，所以他们对应的类具有人的相关特性，因此设计Hulu和Grandpa是Human的继承类。

#### 多态

​		人与人之间充满着各种各样的交流，所以在Human类中我实现了一个简单的communicate()方法，但是对于葫芦娃排队这个场景，其交流过程是特殊的，所以在Hulu类中我对communicate()方法进行了重写，来实现排队时需要的交流过程模拟。这利用了面向对象的多态机制。



## 语言机制

#### 接口

​		在程序中我们抽象出了一个管理(Manage)的接口，爷爷是队伍的一个管理者，其实现Manage接口，实现当中的command()指挥方法。

#### 构造器

​		对于程序中的人物类，都自定义了构造器。

#### 静态变量和静态块

​		为方便了解人物数量，Human类中有一个静态变量total，并使用静态块将其初始化为0。

#### 包

​		程序中利用了package机制，Human、Hulu、Grandpa类放在了同一个包下，方便进行组织管理。

#### 修饰符

​		程序中中类的成员变量和方法使用了修饰符来控制访问权限。



## UML图

[UML图的url链接](http://www.plantuml.com/plantuml/png/TO_DJiGW58Ntzocwr13w2Ctir4HTcFW09nGxpC0jAQ0BPjvTob2ZITsTdvClznv2n1AJi-IXpfXqTmo-vrFgJ_X49cKHGlUO73XJBkDer5N4ESAIP3XDefPtzoGc7LzBiaerEvVOACJLNdymDcMIQhRpGd81dqcQaSIQDy3JsCHRQIlf29xqvi8N_F_yXu8SFJA9fhPfCNLcEEhb0qftBs1CEl-jDywpOVtkI-bWk3RhXPsKbw4-Ims_a_JzPRYnVqL3_Pnks5tVjdJGF2Pdlm40)

![uml](E:\大学学习\大四上\java\hw3\uml.png)

