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

* *调用接口*：通过`Orchestration`和`Choreography`作为函数调用接口操作，仅需在里面设置`run`函数便成完成封装

* *继承：*`Orchestration` , `Choreography`分别继承`World`基类，这样操作的原因是两个世界均是对葫芦娃进行操作，不同点仅在于排序的不同，数据类型以及产生，乱序方法均相同，故放在`World`基类中。
* *封装*：例如对于`Grandpa`类操控葫芦娃进行排序等过程进行封装，在`Orchestration`类仅需调用相关接口，而隐藏具体的实现细节。

