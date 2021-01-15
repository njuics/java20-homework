### 泛型

用泛型改写工具类`Sort`。

```java
public class Sort<T extends Creature & Comparable<T>, E extends Comparator<T>> 
```

对`Creature`的子类，并实现了`Comparable`接口的`T`进行排序，并接受比较器`E`，以实现自定义的比较。



`Sort`里实现了`SortAndShow`方法，对给定对象数组`T`通过比较器`E`进行插入排序,。

```java
void sortAndShow(ArrayList<T> arrayList, E e) {
        int n = arrayList.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (e.compare(arrayList.get(j), arrayList.get(j + 1)) < 0) {
                    T tmp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, tmp);
                }
            }
        }

        for (T t : arrayList)
            System.out.print(t.name + " ");
        System.out.println();
    }
```

因为`T extends Creature`,所以可以直接访问`Creature`的`protected`成员`name`。



用泛型改写有以下两个好处：

1. 可以对任何满足要求的对象进行排序，如果以后加入新的需求(比如说要对蛇精排序)，可以很方便的复用当前的代码。
2. 当前代码使用插入排序实现，如果以后考虑采用新的实现方式(比如说快速排序)，可以改变内部实现而不改变其接口，对用户更友好。