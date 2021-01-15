# 3-OOAdvanced

181860051  李舟俊潇



## 设计思路

​	在`2-OOFoundation`的基础上，我为本葫芦娃排序程序添加了如下**面向对象**特性：

### 封装

​	我将**爷爷指挥葫芦娃排序**和**某个葫芦娃与其他葫芦娃合作排序**（比较、交换）的行为，分别封装在`GrandFather`类和`Brother`类中。当在排序过程中需要进行这两个行为时，只需分别调用两类中封装的方法即可。

### 修饰符

​	我将**有可能被其他类调用**的爷爷与葫芦娃的属性和封装排序行为的方法设为`public`；将例如葫芦娃内部比较等只在本类中被调用的方法设为`private`，以**防止被其他类调用**。

### 继承

​	在原来的实现上我新定义了一个类`Human`，用来在本问题中表示**作为一个人类需要拥有的属性与行为**（种类、名字以及报数行为），并令`GrandFather`类和`Brother`类继承自`Human`类，以表示爷爷与葫芦娃**都是一个人类**。

​	在`Human`类的基础上，我令爷爷和葫芦娃都拥有了**各自独特的属性与行为**，如葫芦娃有自己在兄弟中的排行顺序，爷爷和葫芦娃拥有各自的排序行为等。

### 静态变量与静态块

​	我在`Human`类中定义了静态变量`type`与静态块`shoutOutName`，以表示一个人类的种类与报数行为**不会被改变**。

### 构造器

​	我在`GrandFather`类和`Brother`类分别定义了构造器，以初始化爷爷与葫芦娃的名字、排行等属性。

### 接口

​	我定义了排序算法的接口`Sort`，这个接口中重载了方法`beginSort`：

```java
public interface Sort {
    //choreography方法调用
    public Brother[] beginSort(Brother[] bro);
    //orchestration方法调用
    public Brother[] beginSort(GrandFather grandpa,Brother[] bro);
}
```

​	`choreography`方法和`orchestration`方法分别调用了上述函数，来进行葫芦娃内部排序和爷爷指挥排序的两种不同排序行为。

### 多态

​	除了原来的冒泡排序算法类`BubbleSort`外，我又新增了选择排序算法类`SelectSort`，并用这两个类去实现接口`Sort`。在这两个类中，我对接口`Sort`中`beginSort`方法的两个重载，分别调用了`GrandFather`类和`Brother`类中与`BubbleSort`和`SelectSort`有关的不同行为，来实现分别运用冒泡和选择排序来进行葫芦娃内部排序和爷爷指挥排序：

```java
public class BubbleSort implements Sort{
    public Brother[] beginSort(Brother[] bro){}
    public Brother[] beginSort(GrandFather grandpa,Brother[] bro){}
}
```

```java
public class SelectSort implements Sort {
    public Brother[] beginSort(Brother[] bro){}
    public Brother[] beginSort(GrandFather grandpa,Brother[] bro){}
}
```

​	排序行为实现完毕后，在`choreography`方法和`orchestration`方法中我通过Sort接口分别引用两子类`BubbleSort`与`SelectSort`的实例，来实现不同排序行为：

```java
//冒泡排序
Sort method=new BubbleSort();
return method.beginSort(...);

//选择排序
Sort method=new SelectSort();
method.beginSort(...);
```

### 包

​	我将爷爷与葫芦娃的行为以及排序算法的代码实现都放在了包`cn.edu.nju.javahomework03`中，`Main`类需要通过`import cn.edu.nju.javahomework03.*`来调用。







## 类图

![](http://www.plantuml.com/plantuml/png/lPHFRniX4CNl-ocGUt4KE-gVOr8fIQMqFIG-k58FLG-OdLr8O5Z1O2TQ-RiNR6mJMtOZLQfFCFD-y7ZWlVR47GMZAw6vz-oUA-ohFbP9YUNvtAgQcLWRJiafR7_zPjoryxD-kTMCRvqb2Iwsh1CIFBbOjpZSrGbCTmGHqZgmhUETV3b5h8meLAIuZZ9VQ6VhaJ-oW-DOMpErZjxEUD0WA37tGDBMVtM6mSp0JPgcK3hmGLFIBgkgu-A9jy060Y-W3XVu62uU-PnBQs1XtTFxJmFshdK0sEUR-1OCHzPNBFxE6uLSi_KTC7hfuFDWrHzShlkvWzp0PKcip7bf0qq2FSJkCFjPx_4rXNF7as46pmHOx-rR21AvBiwirH0rmc8Tn3RM5Eg74Ijc7xV8oaUqL4zq3Pvki9ukUBSNwqWXHP7pL9hC2-uPpFuYaRFFnyxYuQunAhBP-1dlZc0wxk2d8dddBD86t-pPfE8fwW6U3o2CjOEmyelx8a4ydJY-1zsamUj5Kc4XxNV_Gq9Aq4qGJj9s5VFh-DMDoRYdK_p-BSGvk8OBOEaFiNaPE_eMMeM7_w-po-F2yjsrQTpnqHvSt7-OpJGaZYdJQJ20v5cQlzbAl_mNB-LZdEOlmw4PzZ_TH3_fIytiUCmILsKDkug5rAdAXQvArT52GLJNW7Km-Wy0)

