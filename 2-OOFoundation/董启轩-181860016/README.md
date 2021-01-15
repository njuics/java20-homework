定义CalabashBrother类表示葫芦娃，GrandFather表示爷爷。
class CalabashBrother：
三个变量：
String name;//葫芦娃的名字
int priority;//葫芦娃的排队优先级，取值为0～n-1，priority越小优先级越大
int position;//胡芦娃当前在队伍里的位置，取值为1～n，priority越优先，位置越靠前
//n为葫芦娃的个数，n默认为7

定义比较函数cmp，原理如下：
设两人为x,y,若：
1、x.priority小于y.priority,但x.position大于x.position,则需要交换位置，返回true；
2、x.priority大于y.priority,但x.position小于x.position,则需要交换位置，返回true；
3、其他情况不需要交换位置，返回false。

定义交换函数swapPosition，用于交换两个葫芦娃的position数据
定义函数find_position,让葫芦娃自己在队列中寻找合适的位置，参考排队时人的思维，寻找位置的方式如下：
a、比较自身和其他人的优先级大小确定自己应该处于的位置
b、寻找对应的位置入列，如原位置有人则与其交换位置


class GrandFather：
只包含一个函数，用于控制葫芦娃进行排队。思路如下：
1）让位置j与其后面的人比较，告诉GrandFather是否需要交换位置；
2）GrandFather根据返回值判断是否让葫芦娃进行位置交换；
3）冒泡排序完成，在此处因为数据结构的不同采用不同的书写方式。

在Sort.java中，定义了sort类型，并定义了葫芦娃数组bro[]用于存储数据，grandpa用于进行orchestration Sort；
choreography Sort则让数组中的每一个人依次使用find_position决定自己的位置即可；
同时为了初始化和完成两次排序任务，完成了具有随机打乱数组顺序的代码，这一部分为自行学习之后完成。
随机打乱数组顺序使用了Java的部分功能（Random）,通过随机数决定是否交换元素顺序来生成随机数组。
然后将打乱的两个数组pri[]（优先级数组）、 pos[](位置数组）按照顺序赋值给每一个bro的元素
排序算法的替换只需要改动grandpa的内容即可。
