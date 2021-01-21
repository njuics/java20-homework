# OOAdvanced


## 设计思想


### 面向对象

代码分为三个部分：*CalabashBrothers* 、*Sort*、和 *Homework3.java*。  
*CalabashBrothers*包中存放定义葫芦娃的类，每个葫芦娃都有一个判断大小的值id和名字name。

*Sort*包中存放排序的类和方法。

*Homework3.java*中存放main函数入口。


![UML pic](http://www.plantuml.com/plantuml/png/ZP8_KyCm3CNtV0gDxRMT6ClGemiJ31qvhgSuRk9hR0LRfjSh-Uuug0a9VpWo9K_vwKdFtWH6pz7MMOFgYAM67Nc-P90UurZx0wgaXK5Sm0Npm1uLj_1Afe2kDjjYZJc6wexEJy_pTTPccQen1DXMv3ML7flgVEtm2xNi3CVeerULxgpOaFil2m0oBjo-hLOmRVArEXukiKC6GszFN6aVn5oc6lcAl4hMO8grVEpO6rU2Gwj5MOo0sVm7BU5B4Aml9mbApQRe0TcR8ZUH1-qIE6sbMiY9QeqE5Da6lHv7inozV-Cap1CsVn3jvtdSazKdyiSRsNjeCpa9oA-PhQS_TIizH2lgXx4Y5zX7nVkNgAEMjOPQTBodmw5NfpDRD6ucaLrlsqQx8jhw7G00.png)

### 多态
因为因为 *Orchestration* 和 *Choreography* 两者都是排序算法，故二者都可以通过继承最基本的排序算法实现。

定义接口Ssort，里面有一个待实现的sort方法，*Orchestration* 和 *Choreography* 都需要实现这个方法。
这样运行时可根据实际情况调用其中任意一个方法。

    Ssort s=new Choreography();
    Ssort s=new Orchestration();
    s.sort();

###  静态
*CalabashBoy*类中定义了两个静态方法：*comapre*和*swap*，*comapre*用于两个葫芦娃对象的年龄比较，*swap*用于交换两个葫芦娃对象的位置。

在*Homework3.java*中，有两个静态变量：葫芦娃组成的数组和葫芦娃的数量，它们都在静态块中初始化。

## 执行流程
在main函数中，首先随机生成葫芦娃对象的序列，然后调用sort方法对葫芦娃进行排序.
某次运行结果如下图：

    老二 老大 老七 老四 老六 老五 老三
    Choreography:
    老大 老二 老三 老四 老五 老六 老七

    老四 老五 老七 老二 老大 老六 老三
    Orchestration:
    老大 老二 老三 老四 老五 老六 老七

两次排序中，第一行为随机生成的队列，第二行为排序方法，第三行为排序之后的队列。




    

