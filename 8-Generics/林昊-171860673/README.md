# 泛型作业说明

## 1 Sort类

`Sort`类是一些排序算法的集合，需要对任何`Comparable`的类型进行排序，也需要根据`Comparator`的指挥对`Comparable`的对象进行排序，所以将`Sort`中`insertionSort`从

```java
public static void insertionSort(ArrayList<CalabashKid> array){...}
public static void insertionSort(ArrayList<CalabashKid> array, Grandpa instructor){...}
```

更改为

```java
public static <T extends Comparable> void insertionSort(ArrayList<T> array){...}
public static <T extends Comparable, E extends Comparator> void insertionSort(ArrayList<T> array, E instructor){...}
```

这样可以提升`Sort`作为一种通用算法的的复用性，也能对类型进行安全检查。

## 2 Enums类

上次作业要求能够随机获得葫芦娃的性别。由于我将葫芦娃的性别实现为枚举类型，所以需要一个`Enums`类来随机选择一个枚举值。定义如下：

```java
public class Enums {
    private static Random rand = new Random(11);

    public static <T extends Enum<T>> T random(Class<T> enumClass) {
        return random(enumClass.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
```

这里`<T extends Enum<T>> `意思是当前静态方法中的`T`应当继承于`java.lang.Enum<T>`，这样就可以实现传入枚举类型的`class`参数，调用`enumClass.getEnumConstants()`方法获得当前传入枚举类型的所有枚举值，进而进行随机选择了。除此以外，这么做的好处还可以允许我们传入任意的枚举类型进行随机选择，做了类型的安全检查。

## 3 CalabashKid类

注意到我们需要实现一个 `Comparable`的葫芦娃类，那么需要如下代码：

```java
public class CalabashKid implements Human, Comparable<CalabashKid> {
	...
    @Override
    public int compareTo(CalabashKid calabashKid) {
    	...
	}
    ...
}
```

这里使用了`Comparable<CalabashKid>`泛型，用以后续所要重写的`compareTo`函数的参数。这么做的好处是可以确定互相比较的两个对象的类型安全。

### 3.1 CalabashKidComparator内部类

这里实现了一个静态的内部类`CalabashKidComparator`，它的代码框架如下：

```java
public static class CalabashKidComparator implements Comparator<CalabashKid>{
	...
	@Override
	public int compare(CalabashKid o1, CalabashKid o2) {
		...
	}
}
```

这里使用了`Comparator<CalabashKid>`泛型，用以所要重写`compare()`函数的参数。这么做的好处是可以确定`compare`对象的类型安全。

## 4 JadeEmperor类

### 4.1 CalabashKidArrayList内部类

这里代码实现如下：

```java
public static class CalabashKidArrayList<T extends CalabashKid> extends ArrayList<T> {

    public static <T extends CalabashKid> void sortByComparable(CalabashKidArrayList<T> array, Order order){...}

    public static <T extends CalabashKid> void sortByComparator(CalabashKidArrayList<T> array, Order order){...}

}
```

这个`CalabashKidArrayList`继承`ArrayList<T>`，但因为需要排除可能混入葫芦娃队伍里的蝎子精等其它妖怪，所以需要对类型做边界的限定：`<T extends CalabashKid>`。除此之外，这么做的好处还可以对增强泛化能力：除了可以对葫芦娃进行排序，还可以对葫芦娃的继承：拥有同种能力的葫芦娃等进行排序。

### 4.2 print函数

首先，玉皇大帝有打印葫芦娃名单的能力，但是玉皇大帝理应也能打印所有人类的名单。所以我也为`print`函数增加了泛化：

```java
private static <T extends Human> void print(ArrayList<T> array){...}
```

这样做可以提高代码的复用性。