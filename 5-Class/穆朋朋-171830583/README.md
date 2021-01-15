# homework5: 类加载
## 穆朋朋 171830583

1.  CustomClassLoader类为自定义的类加载器。

题目要求用Base64编码的字节码字符串加载类型，则可省去读文件的一些步骤。

只需要将该字符串用Base64库解码成byte数组，自定义的类加载器可直接使用ClassLoader的defineClass()方法获得结果。
```
b=Base64.getDecoder().decode(s);    // 解码；
...
return defineClass(name, b, 0, b.length); // 返回类对象；加载前不知道类名，name用的null;
```

2.  Main类为主类，获得加载的类的属性、方法，创建实例等

调用CustomClassLoader类获得该类的类对象；

之后利用getDeclaredFields()、getDeclaredMethods()、getDeclaredConstructors()方法获得该类的属性、方法、构造函数等相关信息；
```
Field[] f=objClass.getDeclaredFields(); // 属性
Method[] m=objClass.getDeclaredMethods();   // 方法
Constructor<?>[] con=objClass.getDeclaredConstructors();    // 构造函数；
```
由输出：
```
构造函数：
Monster(java.lang.String,int,int)
```

发现该类的构造函数为 Monster(java.lang.String,int,int)，利用这个构造函数con[0]创建对象实例：
```
Object snake= con[0].newInstance("snake",100,5);
```

3.  代码输出结果：
```
属性：
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage
方法：
public java.lang.String Monster.attack(Monster)
构造函数：
Monster(java.lang.String,int,int)
创建对象实例：
Monster@70dea4e
```

4.  更多细节可看代码，写了注释。