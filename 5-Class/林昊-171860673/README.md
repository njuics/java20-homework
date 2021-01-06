# README

## 运行方式

以下说明Windows系统中的运行方式：首先进入项目根目录，然后在命令行执行

```shell
javac God.java
java God input\
```

即可获得如下输出：

```shell
Instance: Monster@e9e54c2
Name: Boss
Health: 100
Damage: 10
Instance Constructors:
Monster(java.lang.String,int,int)
Instance Fields:
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
Instance Methods:
public java.lang.String Monster.attack(Monster)
```

其中2-4行是创建对象的属性值，第5-12行是创建的对象的属性和方法（不包含继承自`Object`类的属性、方法）

## 类加载

类加载功能主要在`CustomClassLoader`类中完成，它继承`ClassLoader`类，重载`findClass`函数并在重载函数中调用编写的`loadClassFromBase64File`函数执行文件系统中Base64编码的Java字节码文件输入。

在`God`类中，用

```java
CustomClassLoader clsLoader = new CustomClassLoader(args[0]);
Class<?> cls = clsLoader.loadClass("Monster");
```

执行自定义的类加载。

## 反射

作业要求需要我们创建一个该类型的对象实例，但因为调用

```java
	...
	printConstructors(cls.getDeclaredConstructors());
	...

private static void printConstructors(Constructor[] constructors){
        System.out.println("Class Constructors:");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
```

的输出结果是

```shell
Class Constructors:
Monster(java.lang.String,int,int)
```

可以发现`Monster`对象没有无参构造函数，因此系统无法调用无参数的构造函数实例化类。所以考虑改用如下方式利用有参构造函数实例化对象：

```Java
Constructor<?> declaredCons = cls.getDeclaredConstructor(java.lang.String.class, int.class, int.class);
declaredCons.setAccessible(true);
Object obj = declaredCons.newInstance("Boss",100,10);
```

该方法创建了一个名字叫Boss，生命值为100，伤害为10的怪物实例。我们可以利用`getDeclaredField("name").get(obj)`、`getDeclaredField("health").get(obj)`和`getDeclaredField("damage").get(obj)`的反射机制获取该对象的属性值。

最后，可以通过`getDeclaredConstructors`、`getDeclaredFields`和`getDeclaredMethods`的反射机制找出对象所有声明的构造函数、属性和方法。