# 9-Testing

### 测试内容

1. 对HuluWaQueue.java中按性别分离为两个队列的方法`sepByGender`的正确性进行测试
2. 对葫芦娃排序方法`sortHuluWas`的正确性进行测试
3. 对葫芦娃排序方法`sortHuluWas`的效率进行测试

### 测试方法

在每个Test开始前执行`initQueue`方法，对葫芦娃队列进行初始化。

在每个Test结束后执行`delQueue`方法，释放葫芦娃队列queue。（由于java的垃圾回收机制，只是释放了指针，对象由java自动回收。）

1. 对HuluWaQueue.java中按性别分离为两个队列的方法`sepByGender`的正确性进行测试：

   用`assertTrue`方法检查两个队列中的葫芦娃对象是否全为male和female，并且队列的元素总个数和原来相同。

2. 对葫芦娃排序方法`sortHuluWas`的正确性进行测试：

   遍历排序后的队列，用葫芦娃对象的`compareTo`方法进行验证，每两个相邻的葫芦娃对象都满足前者小于后者。

3. 用`@Test(timeout = 10)`限制排序时间为10ms，测试排序是否能在规定时间内完成。

