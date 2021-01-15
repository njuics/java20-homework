## 9-Testing

本次主要测试排序的功能，排序功能由‘GrandFather’来完成，测试排序的功能在BoysSortTest类中实现。此外为体现测试结果一般性，另外在RecoverTest类中对GrandFather具有的安抚葫芦娃使其恢复能量的技能进行了测试。

#### 测试模块

- 本模块在Testing.java文件中实现
- 使用JUnitCore里的runClasses方法执行BoysSortTest, RecoverTest两个class，并将结果存储在一个Result类型数据runResult中，并使用循环将所有存储在getFailures的错误信息依次输出，并最终输出测试结果。

#### 排序测试

- 测试前输出了葫芦娃的初始序列，也是排序完成后的正常序列，然后将队列打乱顺序并输出队列。

- 测试的内容是执行排序方法，然后使用assertEquals断言判断排序结果是否符合预期序列。

- 测试结束后输出葫芦娃排序后的序列，并输出测试结束

- 测试结果输出如下

  ![](https://i.loli.net/2020/11/11/H5mYLfGkFBJ7rMa.png)

  ![image-20201111201658051](https://i.loli.net/2020/11/11/FTaM3rOyl7U9gLe.png)

#### 安抚技能测试

- 测试前输出了葫芦娃的当前序列与当前血量，并让葫芦娃们受到伤害，随机减少部分血量并输出结果

- 测试的内容是爷爷每安抚过一个葫芦娃之后都会assertEquals断言判断生命值是否为满

- 测试结束后输出安抚后葫芦娃的血量，并输出测试结束

- 测试结果输出如下

  ![image-20201111201739913](https://i.loli.net/2020/11/11/iEb3BcHoXLj2Ofg.png)

  ![image-20201111201815334](https://i.loli.net/2020/11/11/tiUmPG6ZdeVMKY7.png)

