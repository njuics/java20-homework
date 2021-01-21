# 集合框架应用作业说明

## 输出示例

如下输出所示，第1-2行是葫芦娃出生的顺序。3-8行是用Comparable方法的葫芦娃中文名正序、反序和乱序的输出结果；9-17行是用Comparable方法，分性别后按葫芦娃中文名正序、反序和乱序的输出结果；18-23行是用Comparator方法的葫芦娃中文名正序、反序和乱序的输出结果；24-32行是用Comparator方法，分性别后按葫芦娃中文名正序、反序和乱序的输出结果；33-40行是正序排序的正反向Iterable结果和Iterator结果。

```shell
依次出生的葫芦娃
张蒲; 杨狭; 李掎; 司马喳; 陶钝; 上官铂; 韩忽; 李兄; 欧阳介; 李究; 
Comparable的名字正序排序
韩忽; 李究; 李兄; 李掎; 欧阳介; 上官铂; 司马喳; 陶钝; 杨狭; 张蒲; 
Comparable的名字反序排序
张蒲; 杨狭; 陶钝; 司马喳; 上官铂; 欧阳介; 李掎; 李兄; 李究; 韩忽; 
Comparable的名字乱序排序
李兄; 韩忽; 上官铂; 司马喳; 张蒲; 欧阳介; 陶钝; 李究; 李掎; 杨狭; 
Comparable的性别分开的正序排序
MALE: 韩忽; 李兄; 司马喳; 陶钝; 杨狭; 
FEMALE: 李究; 李掎; 欧阳介; 上官铂; 张蒲; 
Comparable的性别分开的反序排序
MALE: 杨狭; 陶钝; 司马喳; 李兄; 韩忽; 
FEMALE: 张蒲; 上官铂; 欧阳介; 李掎; 李究; 
Comparable的性别分开的乱序排序
MALE: 李兄; 陶钝; 司马喳; 韩忽; 杨狭; 
FEMALE: 李掎; 上官铂; 欧阳介; 李究; 张蒲; 
Comparator的名字正序排序
韩忽; 李究; 李兄; 李掎; 欧阳介; 上官铂; 司马喳; 陶钝; 杨狭; 张蒲; 
Comparator的名字反序排序
张蒲; 杨狭; 陶钝; 司马喳; 上官铂; 欧阳介; 李掎; 李兄; 李究; 韩忽; 
Comparator的名字乱序排序
陶钝; 司马喳; 李兄; 杨狭; 张蒲; 韩忽; 李掎; 上官铂; 欧阳介; 李究; 
Comparator的性别分开的正序排序
MALE: 韩忽; 李兄; 司马喳; 陶钝; 杨狭; 
FEMALE: 李究; 李掎; 欧阳介; 上官铂; 张蒲; 
Comparator的性别分开的反序排序
MALE: 杨狭; 陶钝; 司马喳; 李兄; 韩忽; 
FEMALE: 张蒲; 上官铂; 欧阳介; 李掎; 李究; 
Comparator的性别分开的乱序排序
MALE: 李兄; 司马喳; 韩忽; 杨狭; 陶钝; 
FEMALE: 欧阳介; 李究; 张蒲; 李掎; 上官铂; 
正序排序的正向Iterable结果
韩忽; 李究; 李兄; 李掎; 欧阳介; 上官铂; 司马喳; 陶钝; 杨狭; 张蒲; 
正序排序的反向Iterable结果
张蒲; 杨狭; 陶钝; 司马喳; 上官铂; 欧阳介; 李掎; 李兄; 李究; 韩忽; 
正序排序的正向Iterator结果
韩忽; 李究; 李兄; 李掎; 欧阳介; 上官铂; 司马喳; 陶钝; 杨狭; 张蒲; 
正序排序的反向Iterator结果
张蒲; 杨狭; 陶钝; 司马喳; 上官铂; 欧阳介; 李掎; 李兄; 李究; 韩忽; 
```

## 实现说明

1. 葫芦娃家族用`CalabashKidArrayList`进行管理，可以实现任意长度的葫芦娃家族管理。`CalabashArrayList`是一个定义在`JadeEmperor`类中的静态类，它继承了`ArrayList`，并且元素继承`CalabashKid`，防止队伍中混入除葫芦娃以外的，如蝎子精等的异类。

2. 葫芦娃的名字采用中文姓+名随机生成的方式实现。这里我取百家姓中最常见的几个姓氏组织为字符串数组`familyNameArr`，另取随机数生成“名”的一个汉字，编码为GB2312。将姓氏和名字做字符串连接即可得到随机生成的葫芦娃姓名。对葫芦娃的性别，采用随机数生成枚举类型。

3. 如果要对葫芦娃的名字字典序进行排序，需要用到

   ```java
   Collator collator = Collator.getInstance(Locale.CHINA);
   ```

   这样可以提供中文字符串的字典序排序。

4. 题目要求将葫芦娃们分成两个队伍，此时用另外两个`CalabashKidArrayList`对男葫芦娃和女葫芦娃进行管理

   ```java
   private static CalabashKidArrayList<CalabashKid> maleCalabashKidArray;
   private static CalabashKidArrayList<CalabashKid> femaleCalabashKidArray;
   ```

   可以通过遍历`calabashKidArray`将各个葫芦娃分别加入`maleCalabashKidArray`或`femaleCalabashKidArray`。

5. 因为要求`Comparable`和`Comparator`接口进行排序，但是需要完成正序、反序、乱序的功能，因此需要对`Comparable`的`compareTo`方法和`Comparator`的`compare`方法进行重载。首先需要把`CalabashKid`类的定义修改为（关键是implement的部分）

   ```java
   public class CalabashKid extends Human implements Comparable<CalabashKid>
   ```

   然后考虑`Comparator`的继承，：

   ```java
   public static class CalabashKidComparator implements Comparator<CalabashKid>{
   	Collator collator = Collator.getInstance(Locale.CHINA);
   	@Override
   	public int compare(CalabashKid o1, CalabashKid o2) {
   		switch(o1.order) {
   			case ASC:
   				return collator.compare(o1.getName(), o2.getName());
   			case DESC:
   				return collator.compare(o2.getName(), o1.getName());
   			case RANDOM:
   				return Math.random() > 0.5 ? 1 : -1;
   			case DEFAULT:
   			default:
   				return o1.getPriority() - o2.getPriority();
   		}
   	}
   }
   ```

   此处我将它实现为`CalabashKid`的内部静态类，不仅有更好的封装，也方便外部类直接调用。这里最后一种default情况是按照原来任务要求的优先级排序，此处不具体展开。前面的`ASC`, `DESC`和`RANDOM`方法对应了正序、反序和乱序的排序逻辑。

   还需要重载`compareTo`如下：

   ```java
   @Override
   public int compareTo(CalabashKid calabashKid) {
       CalabashKidComparator calabashKidComparator = new CalabashKidComparator();
       return calabashKidComparator.compare(this, calabashKid);
   }
   ```

   这里可以直接调用内部类的`compare`方法，节省代码量，也提供更好的封装和可维护性。

6. 题目还要求利用`Iterable`和`Iterator`接口，这里考虑遍历的情况：迭代可以正向，亦可反向进行。因此如果我们已经有一个正序的`CalabashKidArrayList`，我们就可以直接用反向迭代的方法获得反序的`CalabashKidArrayList`。具体的正向和反向的迭代器代码如下：

   ```java
   public static class CalabashKidIterable implements Iterable<CalabashKid>{
   	@Override
   	public Iterator<CalabashKid> iterator(){
   		return new Iterator<CalabashKid>(){
           	@Override
   			public boolean hasNext() {
   				return index < calabashKidArray.size();
   			}
   
   			@Override
   			public CalabashKid next(){
   				CalabashKid currCalabashKid = calabashKidArray.get(index);
   				index++;
   				return currCalabashKid;
   			}
   
   			private int index = 0;
   		};
   	}
   }
   
   public static class CalabashKidReversedIterable implements Iterable<CalabashKid>{
   	@Override
   	public Iterator<CalabashKid> iterator(){
   		return new Iterator<CalabashKid>(){
   			@Override
   			public boolean hasNext() {
   				return index >= 0;
   			}
   
   			@Override
   			public CalabashKid next(){
   				CalabashKid currCalabashKid = calabashKidArray.get(index);
   				index--;
   				return currCalabashKid;
   			}
   
   			private int index = calabashKidArray.size() - 1;
   		};
   	}
   }
   
   ```
   
   这里我同样使用了内部类的方法，使得可以直接访问外部类中定义的`calabashKidArray`成员。
   
   如果使用`Iterable`的方法进行迭代，可以利用Java的语法糖进行实现。这里以正向迭代为例展示代码：
   
   ```java
   CalabashKidIterable calabashKidIterable = new CalabashKidIterable();
   for(Human curHuman : calabashKidIterable){
   	System.out.print(curHuman.toString() + " ");
   }
   ```
   
   而如果以`Iterator`的方法进行迭代，我们需要用到`iterator()`，以及`hasNext()`和`next()`成员函数。同样以正向迭代为例展示代码：
   
   ```java
    Iterator<CalabashKid> calabashKidIterator = new CalabashKidIterable().iterator();
    while(calabashKidIterator.hasNext()){
    	Human curHuman = calabashKidIterator.next();
    	System.out.print(curHuman.toString() + " ");
    }
   ```
   
   可以看到我成功实现了两种迭代方法。

