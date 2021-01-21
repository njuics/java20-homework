# 面向葫芦娃编程
## orchestration方法排序
  首先根据CalabashBrother类创建葫芦娃对象，以葫芦娃的排名为参数，类的成员变量包括排名和姓名，构造函数中根据排名设置葫芦娃姓名。同时实现返回对象变量的getRank和getName函数。
  <br> 在Solution类中的main函数创建数量为7的一个葫芦娃对象数组，调用shuffle函数打乱顺序。
  <br> 实现GrandFather类，包含一个变量sordMode，其值1/2/3分别对应设置选择排序、冒泡排序、快速排序，并分别实现这三种排序函数。GrandFather中的主函数在排序前后，循环输出葫芦娃的姓名，相对于爷爷依次念出名字。
  <br> 具体排序过程中的葫芦娃对象排名比较通过getRank函数取值再比较，用临时变量实现对象的交换。

## choreography方法排序
  先前过程相同，在CalabashBrother类中实现用于比较本对象与另一个对象大小关系的campare函数，用于交换本对象和另一个对象的swap函数，自身报数即输出自己名字的numberOff函数，以及设置变量值的setRank和setName函数。
<br> 在Solution类中具体实现排序函数，利用冒泡排序，使葫芦娃们互相比较大小（调用campare函数），如果大小位置不对则自行调换位置（调用swap函数），在排序前后让葫芦娃自己报数（调用numberOff函数）。
