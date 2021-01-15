

# 工程结构说明

## 包

所有文件均在cn.edu.nju.HuLuWa下

## UML类图

![image-20200924202518339](http://www.plantuml.com/plantuml/png/bLBBJiCm43mtNx4IbuG-le13UQW2gLKH875071PdarfrxCfse5BXtzauTMEL4pcjPoQxCslFdKVhsqPbD-YzeeKaLSBbT0gtbj2tbZAXq3b8w4C6unFzzWwrbMK6Kv3QGuDxPbDrNZ0Gk9hy2lTy_idYtt3rpQFkssNxYcVWMfKhrDcryD9eXcQpg4kWgEeznWPiy29CT3kIWk9fPrmi7-uwmvpTIn40OLhjqrozxKyZIn2Aq2PdH_xHk92ZdzlxEiGTMDJRhdxsLkeQn4PgSlGKqF5Hd4VXqDQJKfqeBm16_070YVj2jNqn-SUmrWcdALWJbrj9NIwiqS5QeYjW57qUbnMkho-7kq6t3RCtmTrW2YsRhEciwUHS9apJe2wNd3JLfO9M-tLL_MMJUEaJJASTBwzRE9TaAnG4_IlWC03_RpCdNVAZ_mK0)



## Creature类

生物类，是该项目的基础类，爷爷和葫芦娃均由该类派生而来，拥有生物号和位置两个信息，此外，每个生物具有唯一的ID，通过静态变量count自增实现。

```java
protected int specie;
protected int pos;
protected int ID;
static private int count;
static{
	count = 0;
}
Creature(){ID = count++;} //为每个生物生成唯一的ID
```

## Action接口

动作接口，目前只有walkTo函数用于控制生物行走方式，以后可加入防御，攻击等等。

```java
public interface Action {
    void walkTo(BattleField battleField,int pos);
}
```



## HuLuWa类

葫芦娃类，继承于生物类，实现了Acction接口，生物号为1，多了两个属性“排名”和“中文排名”（方便输出），以及各种各样的函数。

```java
private int rank;
private String chineseRank;
void tellRank();  				   //报数
void walkTo(battleField,pos);	  	//实现接口，走向战场的目标地点
int findFrontPos(battleField); 		//在战场中找到应该在自己前面的那个人的位置
```

## OldMan类

爷爷类，继承于生物类，实现了Action接口，生物号为0，多了一些函数

```java
int askRank(huLuWa); //询问指定葫芦娃的排名
void arrangePos(battleField,huLuWa);
// 在战场中为指定葫芦娃安排位置
void commandLine(battleField);
// 找到战场中的所有葫芦娃，并让他们排位一排
void countOff(battleField);
// 爷爷大喊一声“报数”！
void walkTo(BattleField battleField,int pos);
// 实现接口，爷爷走动
```

## BattleField类

战场类，其中包含有一个大小为20的数组，可以安放各种生物。

## Main类

做初始化工作，当sortMode为0时进行监管排序，为1时进行协同排序

```java
void init();   //初始化
void osSort(); //监管排序
void cgSort(); //协同排序
void main();   //运行程序
```

# 初始化&程序运行

所有葫芦娃被随机分配在战场1-8格的位置，而爷爷在第0格，sortMode默认为0（进行监管排序），为1时进行协同排序

# 监管排序算法

爷爷从战场中找到每个葫芦娃，每找到一个，就询问他他的排名（老大，老二...）,并按照排名带领他与目标位置的葫芦娃交换位置，再递归的为目标地点的葫芦娃找到正确位置，若本来就在正确位置则不对该葫芦娃进行任何操作，去下一个地点找新的葫芦娃。

排序完成后，爷爷在战场中大喊一声报数，葫芦娃开始按战场格子顺序报数。

# 协同排序算法

从大娃开始，每个娃都找其前一个人在哪，并自觉地站到他的身后（大娃站在爷爷后面）

站定后爷爷面前的第一个娃开始向后报数（即按战场格子顺序报数）



