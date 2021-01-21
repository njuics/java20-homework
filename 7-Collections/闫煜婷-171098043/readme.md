# 7-Collections

### 随机生成名字和性别

 ***HuluWa.java***

`HuluWa.getRandomName`方法利用`java.util.Random`类来随机生成字符串长度和字符内容，组成名字。

用枚举类型`Gender`存储性别，并实现了`get()`方法随机从可取值中生成性别。

### 根据性别将葫芦娃排成两队

 ***HuluWaQueue.java***

实现了`seqByGender`函数，接收一个`Gender`对象作为输入，输出只含对应性别葫芦娃的新队列。

### 排序和打印

#### 通过Comparator排序：

 ***Comparators.java***

通过继承`Comparator`类，重写`compare`方法，实现了按姓名正序比较器和按姓名倒序比较器。

在葫芦娃队列类中，调用`ArrayList.sort(Comparator)`方法并传入比较器，实现了队列的排序。

在爷爷类中，爷爷为葫芦娃进行排序的函数`sortHuluWas`中调用了`Collections.sort(List, Comparator)`方法，为队列进行排序。

#### 通过Comparable排序：

 ***HuluWaQueue.java***

用`ArrayList<HuluWa>`存储葫芦娃队列。

葫芦娃类通过重写`compareTo`方法，继承了`Comparable`接口，在葫芦娃类的`goToCorrectPos`方法中通过调用这个方法实现了和其他葫芦娃的自发比较和排序。

#### 打印：

借助ArrayList实现了`Iterable`接口，可以用for-in对其中的元素进行遍历并打印。

### 结果

```
orchestration:
排序前:
uiev zngk bix x n t wk qqni ajo yf 
正序排序后:
ajo bix n qqni t uiev wk x yf zngk 
倒序排序后:
zngk yf x wk uiev t qqni n bix ajo 
乱序排序:
wk zngk n x t ajo yf bix uiev qqni 

----------------------------------------

将葫芦娃按性别分为两队
choreography:
排序前:
male: t bix uiev 
female: wk zngk n x ajo yf qqni 
排序后:
male: bix t uiev 
female: ajo n qqni wk x yf zngk 
```

