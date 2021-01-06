﻿程序类图如下
![img-20200925](http://www.plantuml.com/plantuml/png/ZLJDpfim43n_F8MFeFHxWaPHr4hzELGzKFLILMW32xPgREIVz0Sbprul3Yuaj6foiMV7ixC3vcWT6ETxcGrGVuCE6VVIdunc-_qRBHiqXyEOFUrg2TQoTw7sokW0F8tXe1FrXUrQeK0oeHohjLTkMNkEjT8PeRelNvc27aiaoZFnpo0zXitkffidi22KTXswpmJa4tBMec5sXjRiMFiEGtvJOzfnD5FjfBL4K4oYjPyug4TAF5w3bDJfabrI7fq1rGomokCMnzjO6ZCMVdzl0Y_crQc8rEHrcxDiRxLnFJgkcvM3C3kQ5cfaPI1yc0XZDgSGe5avfCxZAinLLGssuALZKRAg5dve6DsNtBUjnAtZYHfpsc3S6nVz8B57vRRI8-FlPqBCyCzBzPfhWpfaF_2Vz18iztbnH_veQexMcR3LYjWh82TVrzXppSGV3bMJdYDBTkqYLHQj_JlPr63bUrFll-J2VtKXYRYL8PqbwIXwVP1w6V7uVBtA5sFPj2mM9A644o35BxfnTp5FX1w4ojE51jFPQFSOagJFo6y0)

初始来看，整个过程可以抽象为几个具体对象：葫芦娃个体、葫芦爷爷和排序本身
## 类相关
考虑使用`HuluBro`类表示葫芦娃个体，其中静态常量`count`和`nameSet`分别表示葫芦娃个数(7)和各自的名字(大娃、二娃等）

`grandpa`类中的两个方法表示葫芦爷爷的比较与交换功能

接口`SortMethod`则综合了排序方法应当有的功能：对葫芦娃随机排列`randomShuffle`、以某种方式进行排序`sort`以及排序后的报数`callHuluBro`，

类`Choreography`与`Orchestration`则分别实现了接口`SortMethod`中的`sort`方法

最终`HuluSort`作为主过程所在类负责执行
## 特性说明
在接口`SortMethod`中，随机排列和报数这两个方法与具体的排序方式无关，所以用`default`方式来直接定义

`Orchestration`在实现`SortMethod`接口的同时，还直接继承了`Grandpa`类，这样相当于隐性地创建了Grandpa类对象，让葫芦爷爷来实现葫芦娃间的排序

类`Choreography`与`Orchestration`最终由`Sortimplement`类进行整合，整体作为一个package。
用户只能通过具有`public`属性的`Sortimplement`类中的方法来获得不同的排序方法，而在主过程类`HuluSort`的`run()`方法则接受的是其实现的接口`SortMethod`，这样用户只能间接生成和执行两种不同的排序方式，而不用直接获得其内部的运行方式
## 过程说明
`main`方法中首先使用`initialize`对HuluBro数组进行初始化（赋值等操作），然后利用`run`分别执行两种排序方式（算法均为冒泡排序）
排序方式分为三步：随机排列、（冒泡）排序、报数
