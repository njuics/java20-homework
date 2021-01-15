# 设计思路

## 类设计

### Scheduler

main函数所在位置，调度代码执行。

### ManageHuLuWa

管理葫芦娃们的信息，调度插入排序算法和葫芦娃自行排序。

### SingleHuLuWa

管理单个葫芦娃的信息，对外提供接口，实现葫芦娃之间的优先级比较。

### Grandpa

管理爷爷的信息，可以从ManageHuLuWa获取葫芦娃们的信息，也可以指挥葫芦娃进行排序。

### Sort

排序算法，包含一个插入排序算法、爷爷指挥的Orchestration排序和葫芦娃互相协作的Choreography排序。

## 排序

### 按照排序算法排序

如下Scheduler.java中代码，依次创建manageHuLuWa对象，然后调度Sort.algorithmSort()执行插入排序，最后调用manageHuLuWa.print()函数打印葫芦娃数组信息。

```Java
ManageHuLuWa manageHuLuWa = new ManageHuLuWa();
manageHuLuWa.algorithmSort();
manageHuLuWa.print();
```

插入排序代码如下：

```Java
public static void algorithmSort(SingleHuLuWa huLuWaArray[]){
	for (int i = 1; i < huLuWaArray.length; i++) {
		SingleHuLuWa currHuLuWa = huLuWaArray[i];
		int j = i - 1;
		while (j >= 0 && huLuWaArray[j].getPriority() > currHuLuWa.getPriority()) {
			huLuWaArray[j + 1] = huLuWaArray[j];
			j--;
		}
		huLuWaArray[j + 1] = currHuLuWa;
	}
}
```


### 爷爷指挥的Orchestration排序

如下Scheduler.java中代码，依次创建manageHuLuWa2对象，用生成的初始葫芦娃数组信息创建grandpa对象：

```Java
ManageHuLuWa manageHuLuWa2 = new ManageHuLuWa();
Grandpa grandpa = new Grandpa(manageHuLuWa2);
grandpa.grandpaSort();
manageHuLuWa2.print();
```

然后调度grandpaSort执行排序，此处爷爷遍历葫芦娃数组，知道每个葫芦娃排序后应该处于的位置后直接安排他们到对应的位置排好即可：

```Java
public static void grandpaSort(SingleHuLuWa huLuWaArray[]) {
	SingleHuLuWa[] sortedArray = new SingleHuLuWa[7];
	for (int i = 0; i < huLuWaArray.length; i++) {
		int priori = huLuWaArray[i].getPriority();
		sortedArray[priori - 1] = huLuWaArray[i];
	}
	for (int i = 0; i < huLuWaArray.length; i++) {
		huLuWaArray[i] = sortedArray[i];
	}
}
```

最后调用manageHuLuWa2.print()函数打印葫芦娃数组信息。

### 葫芦娃互相协作的Choreography排序

首先需要完成SingleHuLuWa.java的compareTo()函数，方便葫芦娃之间的比较；然后在Scheduler.java中先创建manageHuLuWa3对象：

```Java
ManageHuLuWa manageHuLuWa3 = new ManageHuLuWa();
manageHuLuWa3.cooperationSort();
manageHuLuWa3.print();
```

接着调度cooperationSort进行排序，排序算法是插入排序，但是比较相邻元素的布尔表达式更换为：

```Java
huLuWaArray[j].compareTo(currHuLuWa)
```

这样就允许葫芦娃自发地相互比较，从而能够相互协作。最后调用manageHuLuWa3.print()函数打印葫芦娃数组信息。