题目中对葫芦娃进行排序，需要根据某一属性，在这里认为这一属性就是根据他们的**排行**进行排序。

> 首先定义一个Huluwa类，

这个类定义的变量就表示一个葫芦娃，这个葫芦娃有自己的**名字name**和自己的**排行index**，他可以报出自己排行第几`void report_num()`，并且可以与别的葫芦娃进行比较`boolean compare_less(Huluwa another)`，看谁的排行更靠前，并且可以主动与别的葫芦娃进行交换位置`void Swapwithnext(Huluwa[] pre_queue, int i, int j)`。

> 然后定义一个GrandPa类，

这个类定义的变量就表示一个爷爷，爷爷知道葫芦娃们的排行并且可以比较两个葫芦娃的排行大小`boolean CompareHuluwa_less(Huluwa one, Huluwa another)`，并且爷爷可以要求两个葫芦娃进行互换位置`void SwapTwoPos(Huluwa[] pre_queue, int i, int j)`（这里是爷爷发出指令，葫芦娃执行），爷爷还可以对这个葫芦娃的队列进行排序`void SortHuluwa(Huluwa[] pre_queue)`，还可以指挥葫芦娃们进行报数`void CmdReportNum(Huluwa[] Hulu_Queues)`（爷爷让这队葫芦娃们进行报数，报出自己的排行）。

> 最后定义一个Main类，

这个类定义一个有爷爷和七个葫芦娃的世界，在这个世界中，葫芦娃们可以随便进行排序`void DisorganizeLine()`，爷爷可以用orchestration对葫芦娃们进行排序`void orchestration_sort()`，葫芦娃们也可以用choreography内部进行排序`void choreography_sort()`，并且爷爷可以指挥葫芦娃们进行报数。



其中，orchestration和choreography都采用冒泡排序算法，如果两个算法进行替换的话，只需要将

orchestration中爷爷对两个葫芦娃的排行比较以及对两个葫芦娃进行换位

与

choreography中葫芦娃之间的排行比较以及他们主动更换位置

进行替换，即可进行两个算法之间的替换，修改的代码量较小。

