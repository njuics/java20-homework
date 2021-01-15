# 8-Generics作业说明

## 类的实现  
### Human类：//基类  
  将value设为泛型，便于修改葫芦娃的特性  
  public class Human < T extends Myinteger >  
  T value;//用于区分身份，能力等  
  String name;//姓名  
  Human(T i,String na);//构造函数  
    
  class Myinteger implements Comparable< Myinteger >  
  利用Myinteger类继承Comparable接口来比较两个人的val值，使得参与排序的均为人类  
  
Calabash_Brothers和Grandpa均继承自Human类，并继承自Myinteger实现位置的比较
### class Calabash_Brothers< T extends Myinteger > extends Human： 
  boolean compare_val(Calabash_Brothers< T > a)；//与其他的葫芦娃比较value值  
  void swap(Calabash_Brothers< T > a)；//与其他的葫芦娃交换位置  
  
### class Grandpa< T extends Myinteger > extends Human： 
  ArrayList< Calabash_Brothers< T > > lis=new ArrayList<>();//爷爷管理着一个葫芦娃队列  
  boolean compare(Calabash_Brothers< T > a,Calabash_Brothers< T > b)；//比较两个葫芦娃的value值  
  void swap(Calabash_Brothers< T > a,Calabash_Brothers< T > b)；//交换两个葫芦娃的位置  
  void queue(int num,int now)；//爷爷根据自己的观察给葫芦娃调换顺序  
  void countoff() ；//爷爷让葫芦娃们从队列开始报数  

## sort_method  
//Orchestration和Choreography继承Sort_method接口，重写sort()以实现两种排序方法
### public abstract interface Sort_method< T >；  
  void sort(ArrayList< Calabash_Brothers > lis);  
  
### class Orchestration< T > implements Sort_method< T >；  
  void sort(ArrayList< Calabash_Brothers > lis); //在爷爷的指挥下，葫芦娃完成排队  
     
### class Choreography< T > implements Sort_method< T >;  
  void sort(ArrayList< Calabash_Brothers > lis);//葫芦娃们相互协助，完成排队      

## main函数    
首先提示输入1-7（表示赤橙黄绿青蓝紫七个颜色的葫芦娃）七个数字的任意排序，代表初始队列；  
然后分别调用Orchestration和Choreography的排序方法，并分别输出排序结果；  
  输入函数：public static void input(ArrayList< Calabash_Brothers< Myinteger > > lis)  
