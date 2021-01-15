本项目分为4个类：

Kid：娃类

Grandpa：爷类

sortMethod：排序方法类

Main：程序主入口



1，Kid类：

存储了娃的姓名和年龄，同时保存了告诉娃的相互协作时的排序方法（sortMethod类型对象）。

调用findMyPosition就可以让娃在队列中和别的娃相互协作，以插队的方式加入到队伍中。

实现所有娃的排序，就分别调用每个娃的findMyPosition方法，让他们每个人自己找到自己的位置。



2，Grandpa类：

存储了爷爷指挥葫芦娃排序的排序方法（sortMethod类型对象）。

调用orchestrationSort就可以直接使用冒泡排序方法对所有娃进行排序。



3，sortMethod类：

保存了当前指定的方法号methodNumber，可以修改方法号指定两个Kid的比较函数。

比较时，调用cmp方法便可知道两个Kid的优先级大小关系，可以在cmp方法中方便地自定义比较函数，从而实现对排序方法的快速修改。



4，Main类：

创建了娃们和爷的对象，使其随便排列，然后使用两种方法对娃们进行排序。