# 类加载器

## 实现

在[自定义类加载器](https://njuics.github.io/java20/5.html#22)给出的模板上进一步实现通过Base64编码加载类的`CustomClassLoader`

并通过反射机制输出该类型对象的所有方法和属性

## 运行

```
java CustomClassLoader.java
```

## 结果

```
## class name:
Monster       
## constructors:
Monster(java.lang.String,int,int)
## mythods:
public java.lang.String Monster.attack(Monster)
public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException   
public final void java.lang.Object.wait() throws java.lang.InterruptedException
public boolean java.lang.Object.equals(java.lang.Object)
public java.lang.String java.lang.Object.toString()
public native int java.lang.Object.hashCode()
public final native java.lang.Class java.lang.Object.getClass()
public final native void java.lang.Object.notify()
public final native void java.lang.Object.notifyAll()
## fields:
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
```

