# HW 5

171860687 钱正轩

## 加载类

实现了自定义的 ClassLoader，并且重写了 `findClass` 方法，从 base64 编码中解码出字节信息然后调用 `defineClass` 方法获得 Class 对象

此处有一个问题，就是在传入的 name 为空字符串的时候使用

```java
c = Class.forName("", false, loader);
```

这个方法获取 Class 对象时并没有按照委派模型使用自定义 loader 顺序调用而是直接调用了 bootstrap class loader，所以最后使用了如下语句获得 Class 对象

```java
c = loader.loadClass("");
```

然后打印出构造器，方法，字段

```
===Class Name===
Monster
===Constructors===
===DeclaredConstructors===
Monster(java.lang.String,int,int)
===Methods===
public java.lang.String Monster.attack(Monster)
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
===DeclaredMethods===
public java.lang.String Monster.attack(Monster)
===Fields===
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
===DeclaredFields===
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
```

## 创建实例

一开始的想法是遍历 Constructor 然后获取参数类型并生成参数实例，但是没有能够解决使用 `int.class` 生成实例的问题，最终是选择硬编码获取构造器传入参数生成实例，由于 Monster 类定义的构造器是包访问权限，故需要将其权限设为可访问然后再调用