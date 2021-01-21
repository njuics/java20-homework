### 作业2

在`Orchestration`类中，一切排序由爷爷完成。

爷爷通过`grandpaCompare`和`grandpaSwap`两个方法来比较和交换葫芦娃的位置。



在`Choreography`类中，一切排序由葫芦娃自己完成。

葫芦娃通过`selfCompare`和`selfSwap`两个方法(葫芦娃自己的类内方法)来比较和交换葫芦娃的位置。



代码中使用冒泡排序来模拟排队的过程，在实现了比较和交换操作后，可以很方便地将排序算法更换为你喜欢的其他算法。只需要改变`Orchestration`和`Choreography`中`sort`函数的实现即可。

