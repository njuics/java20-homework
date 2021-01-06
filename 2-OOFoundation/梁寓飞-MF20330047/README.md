## 类的创建 
类`Calabash`，保存葫芦娃对象  
数据职责包括：每个葫芦娃的排名`level`：1~7的整数   
行为职责包括：每个葫芦娃可以展示自己的名字，可以和另一个葫芦娃进行`level`的比较，可以和另一个葫芦娃交换在队列中的位置

类`Grandfather`，用于创建爷爷对象  
行为职责包括：比较两个葫芦娃之间的`level`大小，交换两个葫芦娃在队列中的位置  

接口`Sort`：作为排序算法的接口  

类`BubbleSort`：继承类`Sort，用于实现Orchestration和Choreography两种类型的冒泡排序算法     


## 排序算法的替换
编写新的排序算法，只需继承Sort类，实现Orchestration和Choreography两个抽象方法，传递给mySort方法即可。
