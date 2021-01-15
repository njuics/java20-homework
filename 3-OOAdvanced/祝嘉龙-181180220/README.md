## 需求分析
+ 整个问题的本质其实就是一个排序输出过程，但是要求以不同的方式实现。其中效果不变而方式改变的地方有两处，一是排序使用的算法，二是比较大小、交换位置操作的实施者（葫芦娃或爷爷）。故程序中可将这些地方以多态等机制实现，其余用普通的类实现即可。
+ 为便于葫芦娃自己之间互相交换位置，将葫芦娃的队列设计为葫芦娃类的静态属性，这样葫芦娃们将能根据自己的站位调节队列。
## 代码设计
以下为本次作业的具体类图：


![](http://www.plantuml.com/plantuml/png/RP11Ry8m38Nl-HKv1Wd-mGv877Pa4fDsG1pSuZQMKgTot4seuxzFfQCAWLFKvw_sUs-R54I7BfWT1AWW-KCKjPkDdLuKCp-Ji9VQOr81fSYPllDHCBO2lR-O1sYQlWlmkGUJKvD-FsS-9DQOKXJxzhi9s6XnwH4GQhqMDmsneZHGertOqLGn1WIsTUnw47J4khR4kZBVaSus_K2VQLTZwW0fsRo6SKOx87O75UBsUChGkOBHZ4b1gRxQ6qsSK7IQkSNDgc2geQe25ioo-DvPjlbViMt_bEjkUBrOpnE-cZvb7QS6RKAcAAINsrSV4ztgduDRXWuNFykVnvCDn5Z4Itvece2kZCr3Lw7icyQjoXYVqRsm_qNgNMvyYtmUkl07)
+ 为实现比较交换操作的多态，面向算法模块提供一个`Processor`接口，包含两种基本方法`compare(i, j)`和`swap(i, j)`。派生出`Orchestration`和`Choreography`两个类以实现不同的排序方式（分别调用`Calabash`和`Grandpa`来实现）。
+ 考虑到算法本身属于策略的一部分，并未将算法部分实现为多态机制。而是在`Sorter`排序类下实现不同的静态排序算法，它们均以`Processor p`作为入口参数。
## 运行
运行使用`java CalabashSort`