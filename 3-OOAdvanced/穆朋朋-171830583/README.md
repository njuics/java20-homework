# 171830583 穆朋朋 homework3思路

## 类的设计
![类图](http://www.plantuml.com/plantuml/png/VPB1KiCW48RlF0N7zf0yWUDKUr1dr8Fr1NO8JL32CWlOgTftTrEZ9TZ8hT_-_F-_DAiGWMBghN3Gw-11QQbShPjKkvTKTyccW1JbXn2IZx8GWhnboaIEnxWe5Lga2MbrN0zmiJpYGt5_1vd39f9nhHmgJ3m8tEilU4FJo03xHrQnQP7rn5Ac4p4l5A0jnGfx3wIVSRRPlGcns2-Ozyndr0svPMROWV_3khJTMbrYJ-myP9qfia6AUPd246bwwSv5JLjGkhWen4zRUV5PLMDlaQs0J3FzCCbowxeqv7c1s7cKNU-lR8kpaXi2rtYOdGTcwmv9OqlWkxqG1o6-d-C1ZED7EFsp_7knvFbnK5MNvpxQ-XJmlwvOSQLTathx1G00)

`Hulu`: 葫芦有颜色color;

`Huluwa`: 继承Hulu的color属性，并拥有新属性name和rank，其中rank用于Choreography排序；实现Comparable接口，葫芦娃直接可互相比较大小；

`HuluwaList`: 是葫芦娃的队列；

`SortHuluwaList`: 接口，有个sort()方法，可对HuluwaList排序；

`SortByAlgo`: 实现SortHuluwaList接口的排序器，直接用算法对HuluwaList排序；

`Grandpa`: 爷爷类，也是个实现SortHuluwaList接口的排序器，实现Orchestration排序；

`SortChoreography`: 实现SortHuluwaList接口的排序器，完成Orchestration排序

以上类的设计体现了**封装**和**继承**，同时以父类`SortHuluwaList`引用指向三个子类`SortByAlgo`,`Grandpa`,`SortChoreography`，调用sort()方法在运行时刻会重定向到子类的实现，体现了**多态**机制；

**接口、构造器、静态变量、静态块、包、修饰符等**语言机制均有体现：

1. 接口、构造器、修饰符正常设计都会用到，不再赘述；

2. 使用static变量numHuluwa来计数程序创建过的葫芦娃总数，使用静态块初始化static变量；使用包package来组织这些类于命名空间cn.edu.nju.hulusort中。

最后使用`Main`作为主类作为入口；


