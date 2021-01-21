# 8 -Generics

## 泛型改写

1. 将所有的比较器抽象成一个虚基类，在继承的基础上实现正序，逆序，乱序的比较器。之前的版本只能对葫芦娃进行排序，改写后也可以对其他物种排序。

`

```
abstract class Sortset<T extends Comparable<T>> implements Comparator<T> {`
 `@Override`
  `public abstract int compare(T a,T b);`
`}
```

`

2.将CalabashCollection改写成泛型 ` public class CalabashCollection <T extends Calabash>`

显示说明放的是葫芦及其子类，防止其他类型混入



## 运行方式

目录下，运行run.sh文件 ：./run.sh



