# 5-Class

### 设计思路

实现了两个类：

* `MyClassLoader.java`: 继承了`ClassLoader`，并实现了`findClass`方法，在接收参数中添加了一个base64的字符串，在函数中对该字符串进行解析，得到二进制串后用`defineClass`方法生成并返回一个`Class`对象。
* `Main.java`: 创建一个`MyClassLoader`对象来解析base64字符串，得到对应的Class类后，利用反射机制找出其所有的fields/constructors/methods。

在由`Class`对象生成该类的一个实例时，因为该类没有默认public构造器，所以通过反射机制先获取构造器，并将该构造器的访问权限设置为可访问，才可使用构造器。因为无法在运行时实时输入`newInstance`方法的参数，只能提前看好构造器接收的参数类型，将`newInstance`的接收参数硬编码进代码中来构造一个对象。

### 运行结果

```
New an Instance: 
Monster@1540e19d
----------------
Name of the Class: Monster
----------------
Declared Fields of the Class:
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
----------------
Declared Constructors of the Class:
Monster(java.lang.String,int,int)
----------------
Declared Methods of the Class:
public java.lang.String Monster.attack(Monster)
----------------
Public Fields of the Class:
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
----------------
Public Constructors of the Class:
----------------
Public Methods of the Class:
public java.lang.String Monster.attack(Monster)
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class<?> java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
```

### 参考资料

[Class类api](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)

[oracle的java反射用法说明](https://www.oracle.com/technical-resources/articles/java/javareflection.html)

[java.lang.reflect包api](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/package-summary.html)