# 作业 5 提交说明 by 张福翔-171840514

### 文件结构

```
Base64Loader.java
Main.java
```

- Base64Loader 类：继承自 ClassLoader，实现了对 base64 对象的解码和加载。
- Main.java：执行的主程序。



### 执行流程

运行`Main`，程序会执行的操作如下所示：

1. 读取作业中给出的 base64 编码的字符串，将该字符串输入到 Base64Loader 中进行解码，并返回加载出的类类型。
2. 输出加载出的类的名称。
3. 输出该类的所有构造器（本例中只有一个）。
4. 使用该类的构造器创建一个实例，输出该实例（默认输出为`类名称@地址`）。
5. 输出该类的所有属性。
6. 输出该类的素有方法。



### 执行结果

运行后的执行结果如下（其中创建实例后输出的地址可能有所不同）：

```
Class Name: class Monster

Constructors of class class Monster are: 
Monster(java.lang.String,int,int)

Create instance of classclass Monster : Monster@6e0be858

Fields of Class class Monster are: 
public java.lang.String Monster.name
public int Monster.health
public int Monster.damage

Methods of classclass Monster are: 
public java.lang.String Monster.attack(Monster)
```



