# 解决思路

### 类划分

* Calabash(葫芦娃类)：存储葫芦娃姓名和id，定义function葫芦娃比较与报数函数等。
* Grandpa(爷爷类)：指挥葫芦娃进行排序。
* World(世界基类)：产生并存储葫芦娃，定义乱序函数。
* Orchestration()：作为子类继承World，并产生爷爷对象，指挥葫芦娃排队。
* Choreography()：同继承World,葫芦娃间自行比较排序。



### 关键函数

**1.随机打乱数组函数**

```java
void ShuffleArrays(){
    //对葫芦娃进行随机排序
    System.out.println("打乱葫芦娃顺序");
    int len = huluwas.length;
    Random rand = new Random();
    for(int i= len;i>0;i--){
        int randId = rand.nextInt(i);
        swap(huluwas,randId,i-1);
    }
```

**2.排序函数**

```java
public void GrandpaSort(Calabash[] grandsons){
    //通过爷爷指挥进行排队
    int len = grandsons.length;
    for(int i=0;i<len;i++) {
        for(int j=0;j<len-i-1;j++){
            if(grandsons[j].pos>grandsons[j+1].pos){
                swap(grandsons,j,j+1);
            }
        }
    }
}
```

此处满足排序算法可替换，参数设置仅需传入葫芦娃array，便可实现排序。

葫芦娃爷爷指挥排序，通过爷爷观察并比较葫芦娃的pos，由grandpa类发出swap指令;

而葫芦娃相互协作完成排序，通过葫芦娃类自身函数发出位置比较，并自己产生swap指令完成位置调换。

### 函数调用结果
Orchesration world:
打乱葫芦娃顺序
二娃 四娃 六娃 五娃 七娃 大娃 三娃  
大娃 二娃 三娃 四娃 五娃 六娃 七娃  
choreography world:
打乱葫芦娃顺序
四娃 六娃 大娃 五娃 三娃 七娃 二娃  
大娃 二娃 三娃 四娃 五娃 六娃 七娃  




### 面向对象编程思想

*  **继承:** `Orchestration` , `Choreography`分别继承`World`基类，这样操作的原因是两个世界均是对葫芦娃进行操作，不同点仅在于排序的不同，数据类型以及产生，乱序方法均相同，故放在`World`基类中。
*  **封装**：例如对于`Grandpa`类操控葫芦娃进行排序等过程进行封装，在`Orchestration`类仅需调用相关接口，而隐藏具体的实现细节。

*  **多态:** 对于Sort函数而言，`World`基类中存放的是其抽象函数，而在`Orchestration` , `Choreography`中分别进行Override。

  `public abstract void Sort();   //--World`

  `public void Sort(){....};  //--Choreography`

  `public void Sort(Calabash[]huluwas){....}; //--Orchestration`
  

*  **接口:** 同封装操作。

*  **构造器:** World基类中含有构造器，而在其继承类中，采用默认构造器方式；Calabsh中显示定义含参构造器，**此时若未定义不含参构造器，则无法使用**

```java
    Calabash(String n,int p){
        this.name = n;
        this.pos = p;
    }
    Calabash(){
        name = null;
        pos = 0;
    }
```


* **静态变量:** 在`Orchestration`类中定义静态变量Grandpa.

  **静态块:** 利用静态块进行初始化

  ```java
  static Grandpa papa;
  static {
      papa = new Grandpa();
  }
  ```


* **包:**  `package com.company;`

* **修饰符:** 公共函数与变量使用public修饰，私有函数，变量使用private修饰；由于其中有继承关系，`World`基类中部分数据使用protected修饰



### 类图

[UML类图](http://www.plantuml.com/plantuml/png/bP1DJiCm48NtFeMNeCeNG2nQiM05bM31Cfeaan_9FzRO1fN27kxKE_KA-2VGA0AahZ9wVlEzl5ax3-I3agoHu1n_CYHRlcTLnMsevTZmgc9iLVIBopYv5x1vU1n2rqdS4C7EPUK1hI5V7ikGEJG-WySC4lm-ACVUsHItfMP0vmdyQFGozZyC1Lrqv-DkayLR0jrQED5l1aDeUW8xxCvcdoWWeGOt9481vFrlETMDfMgaRTSLteIBDj4OPO4myIRS7OnwprOgVew7Z-FXCoMLir-_2R4uoHNlKIE175-pC7VEw_rbD4By58YUJTyJziMGVYI-BnD_Dot3vfurwZOe-GK0)

