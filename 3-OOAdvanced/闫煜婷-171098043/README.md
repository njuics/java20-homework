# 3-OOAdvanced

## 设计思路

【封装】将葫芦娃、爷爷、葫芦娃队列分别抽象成类，并尽量隐藏其内部成员变量及实现，仅提供必要的public方法作为外部接口。

【继承/接口、多态】因为要便于替换不同的排序算法，因此将比较器的基类作为参数放入排序方法中，并实现以不同字段为基准进行排序的“派生类”（实现比较器接口），在"派生类"中重载compare方法，并将"派生类"比较器对象传入排序方法中，利用多态机制，通过替换派生类对象来实现不同的排序字段。

## 类说明

### 葫芦娃类 HuluWa

以private权限存储葫芦娃的各种属性，包括姓名、辈分、当前所在位置，通过public的get和set方法提供外部访问接口。

实现了**构造器**，要求创建葫芦娃对象时传入对象的名字、辈分和所在位置。

葫芦娃通过goToCorrectPos方法来在前i个葫芦娃中向前走到正确的位置，在这期间通过exchangePos方法来和另一个葫芦娃交换位置（该方法为内部实现，用private隐藏）。该方法还接受一个比较器基类对象作为参数，用于指定葫芦娃比较大小的规则（比较字段）。

### 爷爷类 GrandFather

包括一个public方法sortHuluWas给葫芦娃排序，通过观察传入的葫芦娃队列，通过葫芦娃对象的setPos方法向队列中的葫芦娃发送信息，使其改变位置。该方法还接受一个比较器基类对象作为参数，用于指定葫芦娃比较大小的规则（比较字段）。

### 比较器 Comparators

包含一个类SeniorityComparator，实现了**java.util.Comparator包**的Comparator接口，并**重写了抽象方法**compare，按照辈分为葫芦娃排序。

将实现了Comparator接口的不同的派生类比较器传入上述提到的方法中，即可通过向上转型实现多态，从而改变葫芦娃的排序算法（使用不同的比较字段）。

### 葫芦娃队列类 HuluWaQueue

因葫芦娃只排成一队，故不需要实体队列对象，因此添加了**静态成员**`ArrayList<HuluWa>`来表示葫芦娃队列，并在**静态块**中为其初始化。

另外实现了一系列静态方法，包括报数、随机打乱队列、令葫芦娃自发排序。葫芦娃的自发排序过程为：从第一个葫芦娃开始，在前i个葫芦娃中通过自身的goToCorrectPos方法走到正确的位置，最后一个葫芦娃走到正确的位置后结束。（类似冒泡排序）

### 主类 HuluWaSort

实现了public静态main方法，创建了葫芦娃队列对象和爷爷对象，并依次完成了orchestration和choreography排序以及报数。

## uml图

![](http://www.plantuml.com/plantuml/png/fLDDRzD04BtxLunyIYlNKZcIAWgg14L259H87127gJDs5lR3cfsDg4B_EuqtJZVOxeLJeddptio-DrvwGPPWT5Pfz1xkWWxV4FOP043BQeT2eAo09wiSAtcSdq4hOMKRi6XeFk2qpiTYL9sTwHGfj-ZxBw98UD2gwceDoQgdpCRGBywVrtTERS1785NjLuiDzBlQecteq1NNWsttKy0xPdpyfBpSH63H8LrrEAXnQtVhcAdg1hx2BU3McHOPnV49hKwbeRIGrf_HqFFpdh9ZFXyOxUOzofOOziDNEvQe_3-R9EDErhyGu4QPLfCXApxHMSHjblSxObORIbEAqjJxxAuBwF--IOR5sjT0WVuvG2yegdejc7cMc37Ttv3SzPJPnP0IRRJ1F13Vr_LqYz-6kjOqtO11tCgnp1BdHYsEgnrQOJybPb3PMVnSlly0vCPt0YrMlx0Xo7_Y3iiWIfSlq_AZt4Shn3LMb8HrXE2KpBeBPNt8eqEUdkNJoF-KvTWjPEavbkNY-9WiINAgd5_dS7br1VbbdiBHYPGqCZR2ewHqeRTGCQ7Gc71SOm0DXoKoIxAROFHV)