# 第八次作业

## 泛型

在这次作业中，我将以下类用泛型进行改写：

* 升序、降序及乱序排序用到的 comparator **AscCmp**、**DescCmp** 和 **RandomCmp** 类
* 用于存放葫芦娃们的框架类 **MyCollection** 类

而以下类保持原样没有用泛型进行改写：

* 葫芦娃 **CalabashBoy** 类

并新增了类 **CalabashBoyFactory** 以实现在用泛型改写的集合中生成新的葫芦娃实例。



### 修改 CalabashBoy

虽然无需用泛型对 CalabashBoy 进行改写，但是需要对其进行如下修改，以为改写 MyCollection 做准备：

* 将在 MyCollection 中需要用到的方法

  * getName
  * getGender

  声明在接口 People 中

* CalabashBoy 实现 People 接口

只有完成了上述方式，并在实现 MyCollection 时显示表达 MyCollection 跟某种 People 是有关系的，才能在 MyCollection 中当类型尚未明确时能够使用 People 中声明的方法。



### 实现CalabashBoyFactory

~~~java
interface IFactory<T>{  //接口也可以参数化
    T create();
}

public class CalabashBoyFactory implements IFactory<CalabashBoy>{
    public CalabashBoy create(){
        return new CalabashBoy();
    }
}
~~~

利用 ppt 中的类似思路实现上述代码，以实现在 MyCollection 中生成新的葫芦娃实例。



### 改写 MyCollection

根据以上解释，利用泛型修改 MyCollection，将类声明为

~~~java
public class MyCollection<T extends Comparable<T> & People> implements Iterable<T>{...}
~~~

显示表达 MyCollection 跟某种 Comparable 及某种 People 是有关系的

修改构造函数，传入生成葫芦娃的工具实例，并用该工具生成指定数量的葫芦娃实例

~~~java
public MyCollection(int n, IFactory<T>f){
    numOfCB = n;
    this.factory = f;
    for(int i=0;i<n;i++)
        CBList.add(this.factory.create());
}
~~~

除此之外，剩余的改写任务较为简单。



### 改写 AscCmp

~~~java
public class AscCmp<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a,T b){
        return a.compareTo(b);
    }
}
~~~

改写 AscCmp 时，同样需要显示表达其是跟某种实现了 Comparable 的类是有关系的，才能在泛型类中使用 compareTo 方法。DescCmp 及 RandomCmp 的改写跟上述改写类似。



### 好处

通过上述改写，只要实现了 Comparable 及 People 接口的类都可以使用该代码以实现相应的功能，在实际编程中能够有效地提高代码的复用率。

