#将什么看作对象？  


##将葫芦娃和爷爷看作对象  

1.对于葫芦娃，定义一个Calabash的类，每只葫芦娃就是这个类的一个实例  

类中包含一些数据:
>静态数组 name存储葫芦娃的名字 老大 老二...  
>变量identifier标识葫芦娃的排行，也是排序的依据  
>变量pos表示当前葫芦娃的位置  
>变量 calabashName存储葫芦娃的姓名  

2.对于老爷爷，定义一个Grandpa的类，因为只有一个老爷爷，所以类不需要实例化

Calabash和GrandPa有着共同的**行为模式** :
 
>observe()对于葫芦娃而言，这是相互比较位置，对于老爷爷而言，这是比较两只葫芦娃的位置  
>exchange()对于葫芦娃而言，这是相互交换位置，对于老爷爷而言，这是交换两只葫芦娃的位置  

##将整个排序过程当作一个类

整个排序的框架主要在main()方法中实现
>定义一个ArrayList用来装7个葫芦娃，在排序之前打乱顺序并给葫芦娃重定位  
>过程： 有序的ArrayList --> shuffleAndRepos()打乱并给葫芦娃定位 --> 输出当前位置 -->selfSort()葫芦娃协作排序-->葫芦娃报数-->shuffleAndRepos()打乱并给葫芦娃定位 --> 输出当前位置 -->GrandpaSort()老爷爷指挥排序-->葫芦娃报数  

##将每种排序算法当作一个类  

###可以定义多个排序算法类继承自同一个排序算法类，在每个类中重写排序算法，只要类名相近，通过main()方法中的父类SortMethod1的动态绑定，可以实现更改一个数字就可以调用其他所有排序算法  
>SortMethod1中定义两个排序方法selfSort(),grandpaSort()分别用**冒泡排序**来完成葫芦娃协作排序和老爷爷指挥排序  
>SortMethod2继承自SortMethod1，重写了两个排序算法，用**选择排序** 实现  
>还可以定义SortMethod3继承自SortMethod1继续用**其他排序算法**重写两个排序方法  
>将**CalabashSort.java**的第9行new SortMethod1()中的数字1改成数字2即可转换排序算法  

##运行结果
(排序前是随机打乱)  
before selfSort:  
老六 老三 老二 老七 老五 老四 老大   
After selfSort:  
老大 老二 老三 老四 老五 老六 老七   
before grandpaSort:  
老七 老三 老大 老二 老四 老五 老六   
After grandpaSort:  
老大 老二 老三 老四 老五 老六 老七  

