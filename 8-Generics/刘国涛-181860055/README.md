# 泛型改写葫芦娃

## 泛型改写排序方式

在作业7中，排序方式（升序、降序、随机排序）的实现是通过在Collection中引入三个`Comparator<Calabash>`私有静态变量来实现的，这种方式不便于扩展和代码复用。

在本次作业中，将排序方式通过策略模式和泛型抽象为一个虚基类

```java
public abstract class orderStrategy<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public abstract int compare(T a,T b);
}
```

并在不同的排序策略中继承这一基类，并重载compare方法即可

## 工厂模式改写葫芦娃产生

参考了课件当中的`IFactory`接口和`IntegerFactory`的实现，在本次作业中通过工厂模式改写了葫芦娃的创建过程

由于葫芦娃的能力各不相同（大力、喷火、喷水），因此会有

```java
StrongCalabash extends Calabash
FireCalabash   extends Calabash
WaterCalabash  extends Calabash
```

对于葫芦娃们能力特异化的现象，通过工厂模式能够规范化这一创建过程

```java
public class CalabashFactory implements IFactory<Calabash> {
    public Calabash create(String[] args){
        if(args[0].equalsIgnoreCase("StrongCalabash")){
            return new StrongCalabash(args[1],args[2].equals("male"));
        }
        else if(args[0].equalsIgnoreCase("FireCalabash")){
            return new FireCalabash(args[1],args[2].equals("male"));
        }
        else if(args[0].equalsIgnoreCase("WaterCalabash")){
            return new WaterCalabash(args[1],args[2].equals("male"));
        }
        else{
            return new Calabash(args[1],args[2].equals("male"));
        }
    }
}
```



## 如何编译运行此项目

```
javac -d out control/*.java model/*.java order/*.java factory/*.java
java -classpath out control.Main
```

