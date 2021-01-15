# 3-OOAdvanced 作业设计说明

## Huluwa 类

职责：代表抽象的单个葫芦娃，有编号和名字，接受排序，实现用于比较的接口，能够报数（报名字）

数据成员：

`public int order`

`public String name`

方法：

`protected Huluwa()`

`public final void reportNumber()`

`public final void swap(Huluwa other)`

实现接口：

`compareTo(Object o)`



额外说明：

1. 由于是抽象葫芦娃，不应该存在实例，所以构造函数定为protected，交由子类实现
2. reportNumber和swap定为final，不需要由子类升级改造了



## Dawa, Erwa, Sanwa, Siwa, Wuwa, Liuwa, Qiwa 七个类

职责：继承了Huluwa类，代表实际的大娃~七娃

方法：

`对应的默认构造函数 public Xwa()`



额外说明：

1. 在默认构造函数里硬编码了编号和名字，安全有余（比如使用者无法定义一个编号为5的大娃），灵活不足



## Grandfather 类

职责：爷爷在逻辑上只有一个，采用单例模式，提供对葫芦娃队列的排序功能

数据成员：

`public static Grandfather grandfather`

方法：

`public void SortHuluwa(ArrayList<Huluwa> queue)`

静态代码块

```java
static {
    grandfather = null
}
```



## SortHuluwa 类

职责：main函数所在类，调用爷爷的排序和葫芦娃的排序

方法：


`static void Shuffle(Object[] array)`：模拟打乱队伍顺序

`static void SortByChoreography()`：编舞法排序，主要是调用爷爷的排序

`static void SortByOrchestration()`：协同法排序，主要思想是葫芦娃查看自己位置和编号是否匹配，不匹配则交换




## SortAlgorithm 类

职责：通用的排序类，需要待排序对象实现MyComparable接口，这里采用委托的思想，爷爷不直接设计排序算法，交由`SortAlgorithm`类设计排序，爷爷只调用`SortAlgorithm.sort(object[] objs)`，实现不管

方法：

`public static void sort(Object[] objs)`



## MyComparable 接口

职责：自定义的接口，用于排序比较

接口：

`public int compareTo(Object o)`



## PlantUML

## 代码

```
@startuml
class Huluwa {
    + int order
    + String name

    # Huluwa()

    + final void reportNumber()

    + final void swap(Huluwa other)

    + int compareTo(Object o)

}

class Grandfather {
    - static Grandfather grandfather

    - Grandfather()
    
    + static Grandfather getInstance()

    + void sortHuluwa(Huluwa[] queue)
}

class Dawa {
    + Dawa()
}

class Erwa {
	+ Erwa()
}

class Sanwa {
	+ Sanwa()
}

class Siwa {
	+ Siwa()
}

class Wuwa {
	+ Wuwa()
}

class Liuwa {
	+ Liuwa()
}

class Qiwa {
	+ Qiwa()
}

Huluwa <|-- Dawa
Huluwa <|-- Erwa
Huluwa <|-- Sanwa
Huluwa <|-- Siwa
Huluwa <|-- Wuwa
Huluwa <|-- Liuwa
Huluwa <|-- Qiwa

interface MyComparable {
    public int compareTo(Object other)
}
MyComparable <|.. Huluwa

class SortAlgorithm {
    + static void sort(Object[] objs)
}

class SortHuluwa {

    + static void main(String[] args)

    - static void Shuffle(Object[] array)

    - static void SortByOrchestration()

    - static void SortByChoreography()
}

@enduml
```

## UML类图

![](http://www.plantuml.com/plantuml/png/VLF1ZjGm33sJhuZ4fQFLx1TmM5XMW0Iiq21nG1pSZDjcbIR5JLYDOFuTarff8rNCPTpt_EoNsBcR8r1CerF6mJphzycbPz2_bURVZRO-wa1d9Fa-HRA-rnv6L1bwAOhce2IbinwS_XNiMHDEWUBdDBP8kmdpCqoDj0nnG5gIfB49umI4NqFps3wXOITCNvKuVKVWpntyKudTevuZH6iggbzZ9LaRkZbaJ9hkoJ5-y8nxW-K4uZrGbBClVzz_w9y94nvMZszXlSlyqMp81yhaYnkEQkO4NgWbh3XRA5iptv8m7DNCHrie3clkIwd7aJ0oaLT_ZiVikW8Ug0OMYpLYQo0RgW2sKIEvkrBMHwGE3EfFb_iyVcWToXLEgNNMxA-6RCzLRNLS-VPM5hJSNw3uslM1R1n6ALmcNmOhPNcaeNsQkUvMNjx8ZdW4wvlbbR0Og6UnhDqsxJIahdEujW4YkEodSiStbqSo0ywH60---K_Y_H08Gqym3PTbcdVepsbqVm40)