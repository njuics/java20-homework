1. 程序中共有4个类`HuluBro`,`Grandpa`,`Self`与`HuluSort`
其中`HuluSort`作为`main`主程序所在类负责初始化（创建葫芦兄弟并随机排列）等功能；
`HuluBro`定义了葫芦兄弟本身具有的属性（名字`name`与用于排序的关键字`key`）及相关方法（如与兄弟比较key的大小等）；
`Grandpa`,`Self`分别对应orchestration和choreography两种排序形式。

2. `main`中过程可分为：创建葫芦兄弟并命名的初始化`initialize()`，对其进行随机排列`randomShuffle()`，进行排序`orchestrationSort()/choreographySort()`以及最后的报数`allCall()`。
其中排序阶段采用两种排序算法：选择排序与冒泡排序，可通过对注释的调整进行简单替换。

3. 在`choreographySort()`中，由`Grandpa`类中的方法来对葫芦兄弟进行两两判断，从而进行合适的位置交换，其方法过程均在`Grandpa`类中。

4. 在`orchestrationSort()`中，由`HuluBro`类中的方法，也即葫芦兄弟本身的相关方法进行判断，如果有可交换位置则交换。
