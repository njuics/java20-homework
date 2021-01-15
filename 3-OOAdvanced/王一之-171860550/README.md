# 3-OOAdvanced
本次作业是对2-OOFoundation作业程序的改进。 
   
程序分为两个package：
>characters
>>Unit  
>>HuLuWa  
>>Ground  
>>Tile  
>
>control  
>>LineUp

Say为一个接口，含方法sayName,print其名称  

Unit为抽象类，implements接口Say，并且是之后所有单位（如葫芦娃、妖怪等）的父类，目前属性与方法如下：  
int pos //表示位置，-1表示暂无位置  
public boolean compare(Unit u) //比较函数，默认比较位置   

HuLuWa为葫芦娃类，继承自Unit类，成员变量如下：  
final int rank//排名  
final enum color  
方法除构造函数外，重载compare方法，若传入的为葫芦娃，于其比较rank大小  
实现sayName，打印其rank。

Tile类为格子，可容纳一个单位，成员变量如下：  
private Unit member;//格子上的单位  
boolean isEmpty;//是否为空  
final int pos;//位置编号  
方法如下：  
构造函数分为直接生成与上面占有单位的生成。  
public Unit leave()//若不为空，更新member.pos与isEmpty，将member置空，  
public boolean enter(Unit m)//若为空，将member置为m，更新m.pos与isEmpty  
public Unit getMember()//返回member  
public static void swap(Tile ga, Tile gb)//交换两个格子的成员  

Ground为地面类，含有Tile的数组作为成员。
方法如下：  
public void sortChoreography(Unit[] hulu)  
//通过hulu数组访问每一个单位，每个身后有人的单位看自己是否需要和身后交换位置，不断重复，若某一次没有单位需要交换位置，则结束排序  
public void sortOrchestration()  
//直接对地面上的成员进行排序，此处用了冒泡排序  
public void randomInit(Unit[] units)  
//将Units随机分配到ground上  
public void printTile()  
//打印地面上的所有成员  

LineUp为列队，是控制类  
含有静态成员变量 huluNum，在开始的静态块中初始化为7并打印。   
main函数中，首先，在一个HuLuWa数组中生成7个葫芦娃；之后生成ground，调用randomInit将葫芦娃随机分配到ground中，之后排序并打印，为了区分两个排序方法，第一次降序，第二次升序。

UML图如下  
![UML图](http://www.plantuml.com/plantuml/png/TLFRQXj137tVhn3EomPVlg2KW2bjmKqBQUX3wOEyLjTBPaQBPYR5kEwtLtDPxBYD3JihwHpfIAEzym4bH6kQ4Ridx0bctHu5kq3YPt3J2v4xDeDJ-oTs10zuE3QWloDkVKZ0q_mXoE1wy7YuHqljRNDgrWQzXqSt12ZmFve2HlRPc2UZf_25lQAp1xRCXj11ntP4eJPpupdNXxY9tx0aMoQ-e7igLWgjUSEYPCDI4XPyEo4N1MGcK2txIjKSVBslhuEXgYGJBDajIUapPtGm-7Ts38V_z9x8RVOieB1lhmFLaQCgxvdQAxcKxgDzmLOZp_HJrd9Dg7Ag--W3Xg4xpPzvs87_XMERYaEF2oWlstEpxuMZszLsK_Jx3mXwr7PAEEjsiOefUGNTZkr7rPMLAYtguIyXeoWlzttfzIpXitHxya5K9xj_ekiz2t4lEEuFK_9zD6bTzAyx2cz-hrPvl4rwgBbSrXLgYc9WzQJI5J1Pv--0NH0sCu0R5dIztdYN1x8P73sEkjVJ6DFzvlBtqKBpShWM1mTjsIGLYTBx8h9cMQtU5ZqNZYpxZjmkMlCN)