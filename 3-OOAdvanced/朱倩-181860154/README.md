# **3-OOAdvanced**



## 一、类的设计

1. **`HuLuWa`类**（葫芦娃）

   数据成员：

   - `name`：葫芦娃的名字
   - `rank`：葫芦娃的排行（1~7）

   成员函数：

   - `boolean youngerThan(HuLuWa h);`//判断自身是否比另一个葫芦娃`h`排行小
   - `void exchangeWith(HuLuWa h);`//和另一个葫芦娃`h`交换位置
   - `int getRank();`//返回自己的排行
   - `void tellName();`//报数

2. **`Grandpa`类**（爷爷）

   成员函数：

   - `boolean needExchange(HuLuWa h1, HuLuWa h2);`

     //判断两个葫芦娃`h1`和`h2`是否需要交换（假定`h1`此时排在`h2`前面）

   - `void exchange(List<HuLuWa> queue, int pos1, int pos2);`

     //将葫芦娃队列`queue`中`pos1`和`pos2`位置上的葫芦娃交换位置

3. **`Sort`接口**（包含两种排序形式的函数接口）

   成员函数：

   - `void orchestration(Grandpa grandpa, List<HuLuWa> queue);`

     //由葫芦娃们的爷爷来指挥葫芦娃们行动，完成排队过程

   - `void choreography(List<HuLuWa> queue);`

     //葫芦娃相互协作，完成排队过程

4. **`BubbleSort`类**（是`Sort`接口的一种实现，当需要用其他排序算法替换时，只需写好实现`Sort`接口的另一种排序算法并调用之）

5. **`Control`类**（包含`main`函数，还负责控制葫芦娃随机站队、排队、排队后报数的过程）

   成员函数：

   - `static void initQueue(List<HuLuWa> queue);`

     //初始化葫芦娃队伍，使七个葫芦娃随机站队

   - `static void printQueue(List<HuLuWa> queue);`

     //让葫芦娃从第一个到最后一个报数

   - `static void sort(Sort sort, Grandpa grandpa, List<HuLuWa> queue);`

     //完成葫芦娃排队的整个过程的演示，包括调用`initQueue`初始葫芦娃队列，调用`Sort`类中指挥和协作两种排队形式对应的函数完成葫芦娃排队过程，调用`printQueue`进行排队后的报数

   - main函数：

     ```java
     public static void main(String[] args) {
         List<HuLuWa> queue = new ArrayList<>();
         Grandpa grandpa = new Grandpa();
         BubbleSort bubblesort = new BubbleSort();
         sort(bubblesort,grandpa,queue);
     }
     ```

   

   ### 类图：

   ![PlantUML diagram](http://www.plantuml.com/plantuml/png/dPBFIyCm5CVl_IlUiMFTOBiwP2YYXo7eX1t4GzO-ss2QrEH576F-xQPfscvqA7hPyfBF-_w0BWqnJROKKIgOCN1dLtR3O1y1JDQakSn1iXBhaKi2pUHRv8QlXekFa0HQOEI0yLOfWKp2JbcPetugc8o3UE613yKpmC_KFUIuuLISFjTYETAZqujxdb28UsVchWvHY7phFBEgoTpPIiJi9eXtmhC4skDyc25USKEB1hY4TuisTAgKcNMdkNTs0-fNbYAibIPlxRMKJWiqf1bn9UCsMTxy9p1q65sqgscXD2g7LiKkFWjsZQ_iTYlGE_Eo4bYY9DCd6VypIbZzFKgVv5f9qafusxqXvvKU9bw3IquFDNrEO41Ncii_uCPLZUk-_fJ0eDtF8atBad4PFk3d5s0wDtMnPWaMqschUdnLUnxFeNyKq9wfVqw89ShCbk8R)

   

## 二、面向对象编程思想

**封装**：将葫芦娃，爷爷，排序算法，模拟排队的过程四个部分分别封装为四个类：`HuLuWa`,`Grandpa`,`Sort`和`Control`，并将其用于排队的各种细化行为封装为函数。

**继承**：`BubbleSort`通过继承`Sort`接口，继承了`Sort`中的抽象方法。

**接口**：`Sort`接口提供两类排序形式的抽象方法。

**构造器**：`HuLuWa`类中用构造器完成对其名字和排行的初始化。

**包**：将本次作业用到的所有类都置于包`cn.edu.nju.zq.homework3`中。

**修饰符**：将类中的数据成员设成private以保护其不被其他类随意修改；将类中需要被外界使用的成员函数设成public以供调用，只供自身类使用的成员函数设成private以防止被其他类调用。



## 三、运行结果

在`java20-homework\3-OOAdvanced\朱倩-181860154`目录下运行如下指令：

```
javac -encoding UTF8 cn/edu/nju/zq/homework3/*.java
java cn/edu/nju/zq/homework3/Control
```

输出结果：

```
----------orchestration----------
Original queue:
老四 老三 老七 老大 老五 老二 老六
After sorting:
老大 老二 老三 老四 老五 老六 老七

----------choreography----------
Original queue:
老五 老七 老四 老二 老六 老大 老三
After sorting:
老大 老二 老三 老四 老五 老六 老七
```









