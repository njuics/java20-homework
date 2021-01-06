# 设计说明

## 面向对象特性设计

### 封装

1. `JadeEmperor`类提供public的`main`函数访问权限，玉皇大帝可以管理所有人间生死，因此也可以管理的爷爷和葫芦娃生死，所以它封装了两个private成员变量`Grandpa`和`CalabashKid`。同时，玉皇大帝手握世间的随机种子，这里用来给葫芦娃随机打乱顺序，因此也封装了private成员变量`rand`、private成员函数`shuffle`和`swap`。此外，玉皇大帝只想自己一个人查看葫芦娃的顺序，因此封装了private成员函数`print`
2. `Human`抽象类提供protected成员变量`name`和public抽象成员函数`getName`：即人类都有名字，但是他们不想让别人随意修改
3. `Calabash`类提供三种构造器。葫芦娃可以告诉别人自己的名字和优先级，但不想让别人随便修改，因此有private成员变量`priori`和继承得到的`name`和public成员函数`getPriority`和`getName`；同时，葫芦娃还可以互相比较优先级，因此提供public成员函数`compareTo`
4. `Grandpa`类提供两种构造器。爷爷可以告诉别人自己的名字，也不想让别人随便修改，因此有继承得到的`name`和public成员函数`getName`
5. `Sort`类用到了一些Java泛型，用来做不同的排序操作，对外提供public成员函数`insertionSort`、`orchestration`和`choreography`

### 继承

1. `Grandpa`和`CalabashKid`都是人类，因此继承抽象类`Human`，从protected成员变量`name`继承为自己的private成员变量`name`，同时也继承了public成员函数`getName`并实现。
2. `Grandpa`和`CalabashKid`分别implement了接口`Comparator`和`Comparable`，方便进行比较。

### 多态

1. 泛型：`Sort`类采用泛型机制，implement了`Comparable`和`Comparator`接口，可以适用于除了葫芦娃以外其它对象之间的排序算法

2. 向上转型：`JadeEmperor`类中`print`函数里用

   ```Java
   for (Human curHuman : calabashKidArray){
       System.out.println(curHuman.getName());
   }
   ```

   进行遍历，这里基类`Human`在运行时提升为`CalabashKid`子类完成向上转型

3. 构造器的多态：`CalabashKid`类和`Grandpa`类继承了`Human`类，因此构造子类对象的时候会先构造父类，实现了构造器的多态

## Java语言机制设计

### 接口

1. `Grandpa`类implement了`Comparator`接口，并Override了它的`compare`成员函数
2. `CalabashKid`类implement了`Comparable`接口，并Override了它的`compareTo`成员函数

### 构造器

1. `Grandpa`类实现了三种构造器，分别是无参构造器、带1个优先级参数的构造器和带2个参数（优先级参数和姓名参数）的构造器
2. `CalabashKid`类实现了两种构造器，分别是无参构造器和带1个姓名参数的构造器

### 静态变量

1. `JadeEmperor`类中`calabashKidArray[]`、`grandpa`和`rand`是三个静态变量，全局只能有一份内存空间存储

### 静态块

1. 静态块在`JadeEmperor`类中用到，这段代码在首次创建这个类的对象或首次访问这个类的静态成员时执行且仅执行一次，如下所示：

   ```Java
   static {
       // 爷爷出生
       grandpa = new Grandpa("爷爷");
       // 葫芦娃出生
       calabashKidArray = new CalabashKid[7];
       calabashKidArray[0] = new CalabashKid(1, "老大");
       calabashKidArray[1] = new CalabashKid(2, "老二");
       calabashKidArray[2] = new CalabashKid(3, "老三");
       calabashKidArray[3] = new CalabashKid(4, "老四");
       calabashKidArray[4] = new CalabashKid(5, "老五");
       calabashKidArray[5] = new CalabashKid(6, "老六");
       calabashKidArray[6] = new CalabashKid(7, "老七");
       // 一个打乱葫芦娃的随机数种子
       rand = new Random();
   }
   ```

### 包

1. `Sort`类是一种算法，因此集成到algorithm目录下，在`Sort.java`代码第一行加上`package algorithm;`语句，然后在需要引用这个包的`JadeEmperor`类首部加上`import algorithm.Sort;`即完成包的导入
2. `Human`抽象类是一种生物Creature，其它还有怪物Evils等生物，因此可以把`Human`抽象类集成到creature目录下，在第一行加上`package creature;`。然后在需要引用这个包的`JadeEmperor`、`CalabashKid`和`Grandpa`类首部加上`import creature.*;`即可

### 修饰符

1. 访问权限修饰符public、protected和private都在设计当中用到了，其中protected在抽象类`Human`中用到
2. `@Override`修饰符在`Grandpa`类和`CalabashKid`类继承和implement的时候有用到

## UML图

![UML类图](http://www.plantuml.com/plantuml/png/XLDDgzim4BpxLopfnS7sWvuAZnvU2Q6bXLAQt48E6rcn1RParafBIFtVkx9biYI6T_77pEnulBjwwpsIlxHDeXhiU_YEfTwsdIP7S4i0RinxeuPYWmsUiAz_c1BK_VaB4LuFHwdyIcZB3g6QxfBwpOXh8H02pbeqDjrvChOw7DVm2d-SaOAYho_dSwFJHUulTgcnFWU-B0awOk9UEYHuwZsXyZ3zyhTBYpRywuSf0bXiTJ2OTKDMQV-JmT5a4h4DksewezAmSMs7XAT6FuFUKMojw63uMi5Iu6oE3BzbWatNZm1Bbx0yXWbSoFXhTFFNCIVp32z5PrIDuVJUfS9ohXfYu9qZBtSWCxRNv8spWKdtFAlNXsPdZbIjGzk2B4ZoxRD8rOwqgmYx-hfa4uSQgc6URDJCsUAIXNXPV4xNyYLsvjqMo0RaiDYDQ0cV_nN5j2q2UdcHanRrKYxXK28tHfwurSSLEAuAz_Y9PVxJIaPzqaIBCARaJTkIp_T_)

如上图所示是我的此次作业的最终设计的UML类图，`JadeEmperor`是玉皇大帝静态类，`CalabashKid`是葫芦娃类，`Grandpa`是爷爷类，`Sort`是排序静态类，`Human`是抽象类，`Comparable`和`Comparator`是Java内置的两个接口（如果图片不可见的话可以进入[UML图路径](./README.assets/UMLFig.png)查看UML类图）