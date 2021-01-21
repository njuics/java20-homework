# homework8 Generics
### 1.简介
本次作业类的关系结构参考homework3中的UML图，功能实现与homework7一致。在此基础上，增加了对泛型的应用。
### 2.具体实现
* 将sort接口定义中将T限定到了Compareable接口上
~~~java
public interface Sort <T extends Comparable<? super T>>{
    void sort(ArrayList<T> characters, int option);

    default void shuffle(ArrayList<T> characters) {
        Collections.shuffle(characters);
    }
}
~~~

* 在Hulu、Grandpa继承KindCharacter类的关系中应用了构成自限定
~~~java
public abstract class KindCharacter<T> {...}

public class Grandpa extends KindCharacter<Grandpa> implements Sort<Hulu> {...}

public class Hulu extends KindCharacter<Hulu> implements Sort<Hulu>, Comparable<Hulu> {...}
~~~

* 实现Comparable接口时对泛型的应用
