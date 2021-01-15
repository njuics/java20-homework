# OOFoundation

### Orchestration

  1 基本思想：

​				通过编制的方式排队，我们需要两个类，一个葫芦娃类（Class Calabash)，表示待排序的对象，一个控制类(Class Grandpa)，负责排序的调度

  2 类的设计

##### 			(1)	Calabash

​					包括葫芦娃的名字，年纪特征。

​					葫芦娃可以说出自己的名字；外界可以通过接口获得其名字和年纪。

#####            (2)	Grandpa

​					爷爷可以发出的指令：

​									1.创建葫芦娃

​									2.让葫芦娃们随意站队

​									3.让葫芦娃们报数

​									4.给葫芦娃们排序



### Choreography

1.  基本思想：

   ​		通过协作的方式排队，葫芦娃们可以看到互相的位置并且自己进行位置的调整

2.  类的设计

##### 			 	   Calabash

​					包括葫芦娃的名字，年纪特征。

​					葫芦娃的行为：

​						1. 葫芦娃可以说出自己的名字；

​						2.可以通过接口获得其它葫芦娃的名字和年纪。

​                   	 3.可以通过compare方法比较和另一个葫芦娃的大小

​						4.通过swap方法换位



### 排序的替换

​	如需替换，在两个java文件中只要替换newSort函数的内部实现，其他部分不用修改

### 运行方法

​	在目录下：

​	javac Orchestration.java

​	java Orchestration

​	javac Choreography.java

​	java Choreography



​		

​					

​			

