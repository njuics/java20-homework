# README

## 思路介绍

### 类加载器 MyClassLoader

将需要解码的字符串进行解码后得到byte流，然后写入到.class文件中，并使用该byte流创建Monster类

### 反射

使用类加载器得到Monster类后，调用

```java
getFields()
getDeclaredFields()
getMethods()
getDeclaredMethods()
getConstructors()
getDeclaredConstructors()
```

分别得到属性、方法和构造器，并对其进行输出

```java
获取的Field：
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
获取的DeclaredFiled：
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
获取的Method：
public java.lang.String Monster.attack(Monster)
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
获取的DeclaredMethod：
public java.lang.String Monster.attack(Monster)
获取的Constructor：
获取的DeclaredConstructor：
Monster(java.lang.String,int,int)
```

根据`getDeclaredConstructors()`返回的构造器，利用`getDeclaredConstructor({String.class, int.class, int.class})`获得对应的构造器即可调用`newInstance()`进行构造

这里需要注意的是，因为该构造器是私有的，直接调用会报错，因此加入`setAccessible(true)`即可访问