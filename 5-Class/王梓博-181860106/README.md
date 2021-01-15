# 第五周作业

本周作业需要实现一个类加载器，通过该加载器从给定的字符串中加载类型，并创建一个该类型对象的实例，通过 java 反射机制找出该对象所有属性和方法。将上述要求分为：

* 实现一个类加载器，通过该加载器从给定的字符串中加载类型
* 创建一个该类型对象的实例，通过 java 反射机制找出该对象所有属性和方法

实现两个类 CustomClassLoader 和 Main ，分别实现上述要求

其中，CustomClassLoader 类继承 ClassLoader 类，实现 loadClassFromFile 方法，以从给定的文件名中载入类，并用 Base64 编码的解码器对读入的内容进行解码并返回得到的字节码；重载了 findClass 方法，利用 loadClassFromFile 方法读入字节码，并返回由defineClass 方法返回的 Class 对象。

Main 类中利用 CustomClassLoader 的 findClass 方法加载储存在 class.txt 中的字节码中的类，用 Class 类中的 getName、getDeclaredFields、getDeclaredMethods、getDeclaredConstructors 方法获得类的名字、属性、方法及构造器，根据得到的信息

> name:Monster
>
> method #0: public java.lang.String Monster.attack(Monster)
>
> constructor #0: Monster(java.lang.String,int,int)
>
> field #0: public java.lang.String Monster.name
>
> field #1: public int Monster.health
>
> field #2: public int Monster.damage

可知，类有三个属性，分别为字符串 name、整形 health、整形 damage，有一个需要输入三个参数的构造器，由此，并利用 Constructor 类的 newInstance 方法创建一个该类型的对象实例。