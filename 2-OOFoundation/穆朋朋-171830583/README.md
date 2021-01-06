# 171830583 穆朋朋 homework2思路
首先是类的设计：涉及的基本对象有葫芦娃和爷爷，所以需要设计葫芦娃类Calabash和爷爷类Grandpa以及完成创建、调度等操作的主类CalabashBrothersSort.  
Calabash类：成员变量有color记录该对象的颜色；为了之后的Choreography形式的排序，使用rank变量记录该对象在队列中期望的排名；  
Grandpa类：没有成员变量，有一个对七葫芦娃排序的方法；  
CalabashBrothersSort类：主类，在其main()函数创建七葫芦娃的ArrayList并打乱顺序，分别使用3种排序方法进行排序；  

1. 用算法排序：实现简单的选择排序；
2. Orchestration形式的排序：创建爷爷对象，调用其方法对ArrayList排序；
3. Choreography形式的排序:这里我采用的思路是，每个葫芦娃告诉其他所有葫芦娃自己的颜色(排行)，然后某个葫芦娃在获得其他葫芦娃的颜色时与自己比较，进而修改自己期望的rank，本阶段之后每个葫芦娃都知道了自己应该排在的位置；最后将对应的葫芦娃通过交换的方式排到该位置即可。