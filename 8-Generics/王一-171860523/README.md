# README

使用泛型修改了homework7中的接口类

从

```java
public interface MySort {
    public List sort(List list, int mode) throws Exception;
}
```

改为

```java
public interface MySort<T> {
    public List<T> sort(List<T> list, int mode) throws Exception;
}
或者可以改为
public interface MySort<T extends Creature> {
    public List<T> sort(List<T> list, int mode) throws Exception;
}
```

homework7中，定义的MySort接口，根据接口分别实现了两个类：

```java
public class CalaAllSort implements MySort
public class CalaSexSort implements MySort
```

但是在重写函数的过程中，因为接口定义的函数只有List，而需要排序的是List\<CalaBro\>，因此只能对List进行类型转换，这样一来很容易出错。在使用泛型改写接口之后，定义时就可以使用如下定义：

```java
public class CalaAllSort implements MySort<CalaBro>
public class CalaSexSort implements MySort<CalaBro>
```

这样一来，sort函数接受的就是List<CalaBro\>，同时返回的也是List<CalaBro\>，不需要进行类型转换