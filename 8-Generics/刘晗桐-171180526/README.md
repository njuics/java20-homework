# 泛型

利用泛型对排序方式进行了整合，新建了`SortMode`接口，接受一个类型参数

```java
public interface SortModes<T> {
	public void SortAscendable(List<T> oneList);
	public void SortAscnedator(List<T> oneList);
	public void SortDescend(List<T> oneList);
	public void SortDisorder(List<T> oneList);
}
```

这几种排序方式分别为<利用comparable进行升序排序>，<利用comparator进行升序排序>，<利用comparable进行降序>，以及<利用comparable进行乱序>

这样编写可以使方法使用更加清晰，提高代码可读性，便于根据新的被排序对象进行代码的扩展