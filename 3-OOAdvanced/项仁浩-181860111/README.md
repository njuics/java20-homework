### CalabashSort类

* 静态数组name保存七个葫芦娃姓名信息，静态常量NUM为葫芦娃个数
* shuffleAndRepos()方法将葫芦娃列表打乱，即让葫芦娃随机站位
* main()方法中定义了一个葫芦娃列表list，一个爷爷g，一个排序算法Method，下面打乱葫芦娃顺序并让他们报数，然后葫芦娃自己排序并报数，然后再打乱葫芦娃顺序并让他们报数，然后爷爷排序并让葫芦娃报数 



### Human,Calabash,Grandpa类

* Human类是Calabash类和Grandpa类的共同父类，Calabash和Grandpa都直接继承自Human
* Human类每个实例都有一个名字name，并且报数方法reportName()在这个地方实现
* 每个Calabash实例都有一个pos表示位置，prio标识排序的优先级，优先级越大越应该往后排
* Calabash和Grandpa有着相同的**行为模式**，即观测**observe()**和交换**exchange()**,两个方法分别实现观测葫芦娃的优先级大小和交换两只葫芦娃的位置的功能，被操作对象都是葫芦娃



### SortMethod,SortMethod1,SortMethod2类

* SortMethod是一个抽象类，类中需要待实现两个方法，一个是**orchestration()**,另一个是**choreography()**
* SortMethod1和SortMethod2都是直接继承自SortMethod类，并且都在类中实现了抽象类中的抽象方法，他们分别表示冒泡排序和选择排序，可以定义多个这样的类，**通过main()方法中Method的动态绑定可以实现改动一个数字就可以更改排序算法**



#### 代码对应的uml类图如下：

[click here](http://www.plantuml.com/plantuml/png/pPH1RwCm48Nl_0fBUo7QSDZTOrPHebPg3aqEZNggUXXW0bR1WsoJ9aByzm82unOZLJdLXmZcFS_xndBOA0rIbtdc2SXH5H0Xsr6ExoJV_h5VzzrYbUUnPaKPACNk88CGL7eagIkFzQjI6ZIFwjz7BRb8NbvPst0rrG_F-vKtBUV0XRzm-5LQdauPRaNyX0MfrcDCtKDjm-tA7CH8fJgO7iLKEvFV5gt0C_6OoIP2waEZ32orQtI65uqYdiHneLd3kFfSa9p6SDF3jzYMWy_Y2Oao1C4eL2ZFw9ji-0gDboW5aTWM5_o3114NCCC-o3RMjsYMvZ6S1tExRKO8cs28T0_RNguzwfJYods5nkgmi-uoevGaKYAXIA_-LaguFdAb_m-nQvOrhulPxIIZ5Dk2vYJyuSYIvMmdUuW9-nzpsAvvRkAzaRB_gp0tvz-VnjdzsXyQHa5W2cwrR-yMnxawVNnbGR0sMnsIoQoz3OgupBCF)





