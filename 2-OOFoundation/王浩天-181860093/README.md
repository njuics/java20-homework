# 2-OOFoundation作业说明


## orchestration
在爷爷的指挥下，葫芦娃完成排队  
### 实现思路
用到了爷爷Grandpa和葫芦兄弟Calabash_Brothers两个类，利用爷爷类对葫芦兄弟类进行调度；   
首先提示输入1-7（表示赤橙黄绿青蓝紫七个颜色的葫芦娃）七个数字的任意排序，代表初始队列；  
爷爷会从头开始遍历队列，当发现当前位置与葫芦娃不匹配时，会直接将该葫芦娃与他应该去的位置上的葫芦娃交换位置；  
再观察刚刚被交换的葫芦娃是否处于正确位置，如果不是，则继续交换到正确位置；如果是，则再从头开始查找不处于正确位置的葫芦娃进行交换；  
当交换次数等于葫芦兄弟的次数时，说明已经完成排序；  
再令葫芦娃们从头开始报数，进行验证即可；     


### 具体实现
Calabash_Brothers类：  
  private int value;//区分不同葫芦娃   
  int getval()；//返回value值  
  void change_val(int i)；//更改value值，便于交换  
  void print() ；//报数时，输出自己的value值以及颜色  
  
Grandpa类： 
  void swap(Calabash_Brothers a,Calabash_Brothers b)；//交换两个葫芦娃的位置  
  void queue(int num,int now,ArrayList<Calabash_Brothers> lis)；//对葫芦娃进行排队  
以及输入输出函数：   
  public static void input(ArrayList<Calabash_Brothers> lis)；    
  public static void output(ArrayList<Calabash_Brothers> lis)；    
  
## choreography
葫芦娃相互协助，完成排队  
### 实现思路  
共进行六轮排序，每次从头开始，每个葫芦娃都与身后葫芦娃进行比较，如果value值大于身后的葫芦娃，则进行交换；  
六轮排序后，再通过报数进行验证；  

### 具体实现
Calabash_Brothers类：  
  private int value;//区分不同葫芦娃    
  int getval()；//返回value值  
  void change_val(int i)；//更改value值，便于交换    
  void print() ；//报数时，输出自己的value值以及颜色  
  
以及其他函数：  
  public static void swap(Calabash_Brothers a,Calabash_Brothers b)；//交换两个葫芦娃的位置  
  public static void queue(int num,ArrayList<Calabash_Brothers> lis)；//葫芦娃间相互协助，完成排队  
  public static void input(ArrayList<Calabash_Brothers> lis)；    
  public static void output(ArrayList<Calabash_Brothers> lis)；     
