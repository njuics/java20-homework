# HW7

171860687 钱正轩

## 葫芦娃与容器

葫芦娃对象有姓名和性别，在初始化函数内通过 `java.util.Random` 随机生成，葫芦娃被组织在一个 `List` 中，底层实现采用 `ArrayList`，包装在 `HuLuWaCollection` 类中

## 排序

葫芦娃本身实现了 `Comparable` 接口，可以按姓名升序、降序、乱序排序，也支持先按性别排序，性别内部再按姓名升序、降序、乱序排序，通过一个接口 `setOrder()` 来设定 `compareTo()` 的行为

除此之外葫芦娃还能返回支持同样排序功能的 `Comaprator`，实现方法为匿名内部类，采用静态方法（因为 `Comparator` 是葫芦娃类的属性而非实体的属性）

`HuLuWaCollection` 类通过调用 `HuLuWa` 类的方法进行排序，或是通过实现了 `Comparable` 直接排序，或是传入 `Comparator` 进行排序

```java
public void sortComparable(Order order, boolean sortByGender) {
    logger.info("sort via Comparable");
    huLuWList.forEach(x -> x.setOrder(order, sortByGender));
    Collections.sort(huLuWList);
}

// Main.java: huLuWaCollection.sortComparable(Order.DESC);

public void sortComparator(Comparator<HuLuWa> comparator) {
    logger.info("sort via Comparator");
    Collections.sort(huLuWList, comparator);
}

// Main.java: huLuWaCollection.sortComparator(HuLuWa.getComparator(Order.DESC));
```

## 输出

`HuLuWaCollection` 类可以返回 `Iterable` 对象或是 `Iterator` 对象，实现了正向和反向的迭代器

```java
public Iterable<HuLuWa> getIterable() {
    // 匿名内部类只有一个重载函数的情况下可以简写成 lambda（Iterable 接口只用实现 iterator() 方法）
    // return () -> getIterator();
    // lambda 可以进一步简写成方法引用
    return this::getIterator;
}

public Iterator<HuLuWa> getIterator() {
    return new Iterator<HuLuWa>() {
        private int index = -1;

        @Override
        public HuLuWa next() {
            index++;
            if (index >= huLuWList.size()) {
                throw new NoSuchElementException();
            }
            return huLuWList.get(index);
        }

        @Override
        public boolean hasNext() {
            return index < (huLuWList.size() - 1);
        }
    };
}
```

然后在测试的主函数里可以使用两种不同的方法打印

```java
public static void printIterable(Iterable<HuLuWa> list) {
    logger.info("print via Iterable");
    for (HuLuWa h : list) {
        System.out.println(h);
    }
}

public static void printIterator(Iterator<HuLuWa> it) {
    logger.info("print via Iterator");
    while (it.hasNext()) {
        HuLuWa h = it.next();
        System.out.println(h);
    }
}
```

## 接口比较

`Comparable` 与 `Comparator`

* `Comparable` 优势在于实例之间是可以自比较的
* `Comparator` 优势在于分离了类型的代码和用于比较的代码，且可以根据需求定义不同的 `Comparator`

实现了 `Comparable` 的类和“支持排序”这个属性联系更紧密，而 `Comparator` 一般用作临时排序某些本身不支持排序的类

`Iterable` 与 `Iterator`

* `Iterable` 表示类型本身支持遍历，一般是容器的属性，实现了 `Iterable` 的类能返回一个 `Iterator`
* `Iterator` 是迭代器，一般由实现了 `Iterable` 的类通过匿名内部类的方式生成，容器类型本身不会实现这个接口，因为每个迭代器是独立工作互不干涉的。使用内部类是因为迭代器需要知道容器的信息

`Iterable` 和 `Iterator` 从语义上就能区分