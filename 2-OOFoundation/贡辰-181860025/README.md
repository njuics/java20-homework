1. orchestration

   设置3个类 

   ​    HuLuWa类：葫芦娃类，具有color属性（排队依据） 以及index（葫芦娃队列中的位置）

   ​	Grandpa类：负责指挥葫芦娃排队

   ​							包含一个函数gsort（HuLuWa, HuLuWa[]）

   ​							传入需要排队的葫芦娃以及当前的葫芦娃队列

   ​							查看当前葫芦娃的位置是否正确（color是否和index匹配）

   ​							若不匹配，则和对应位置葫芦娃换位置

   GrandpaSort类：负责进行排序，内含一个Grandpa和一个HuLuWa[]

   ​							  main函数

   

   2.choreography

   设置2个类

   HuLuWa类：葫芦娃类，具有color属性（排队依据） 以及index（葫芦娃队列中的位置）

   ​						同时为了让葫芦娃间互相协调

   ​						设置了一个函数 sort（HuLuWa[]）

   ​						传入当前的葫芦娃队列

   ​						自己找位置，若位置被占了，则和占位置的兄弟交换。

   HuLuSort类：负责进行排序。

   

   首先输入的是葫芦娃的初始排列
   
   0-6表示大娃到七娃
   
   然后程序输出排序结果
   
   ​	
