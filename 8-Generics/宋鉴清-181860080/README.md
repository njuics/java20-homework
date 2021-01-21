### 如何使用泛型

定义了一个**Creature**基类，葫芦娃类继承该类，以后如果有妖精的话也继承该类，

然后定义一个`class Family <T extends Creature>`，该类型用来存储某一个种生物的整个家族，所以如果想要定义一个葫芦娃家族，那么就只需要定义一个实例`Family<Gourd> gourdFamily = new Family<Gourd>()`，就可以用该变量表示整个葫芦娃家族，该类型中有一个加入成员的接口`public void add_member(T x)`，该接口只允许加入T类型的变量，所以对于葫芦娃家族，可以防止一些蛇、蝎等妖怪混入到葫芦娃家族中。

针对上一次作业，需要自定义一个`NegativeSort`类对葫芦娃们进行逆排序，而因为这里的是`class Family <T extends Creature>`，所以需要对`NegativeSort`重写，它也只需要改成`NegativeSort <T extends Creature>`即可。

而且还采用`Iterable`和`Iterator`进行`foreach`输出，所以需要重写这两个类，也只需要分别改成`class CreatureIterable <T extends Creature> implements Iterable<T>`和`class CreatureIterator <T extends Creature> implements Iterator<T>`即可。



### 泛型的好处

（1）可以将运行时的错误变成编译时候的错误，

（2）减少强制类型转换

（3）提高Java程序的安全性

（4）对于使用泛型的`Family`既可以定义为葫芦娃家族，也可以定义为妖怪家族，而且可以防止妖怪混入葫芦娃家族，葫芦娃混入妖怪家族等。

（5）使代码可读性更好，可以在编译之前就可以知道变量类型。