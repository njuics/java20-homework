## 自动构建

此次试验在上一次实验的基础上，使用了一些第三方库对代码进行了改善，并利用*Maven*进行自动构建.

#### 第三方库

##### Apache Commons

1. 使用`org.apache.commons.lang3.RandomStringUtils`中的 *randomAlphabetic(a,b)* 函数随机生成长度 *a~b* 的字符串，作为`Creature`对象的姓名
2. 使用`org.apache.commons.lang3.RandomUtils`中的 *nextBoolean()* 函数随机生成一个布尔变量，作为`Creature`对象的性别

##### Google Guava

使用`com.google.common.collect.Ordering`模块，定义 *Ordering* 对象并重写其比较方法`compare`，利用 *Ordering* 类的`sortedCopy`方法对葫芦娃进行排序。

#### 自动构建

按约定建立文件目录结构，并编写 *pom.xml* 文件，主要是在其中添加使用到的第三方库的相关依赖项：

```xml
<dependency>
	<groupId>com.google.guava</groupId>
	<artifactId>guava</artifactId>
	<version>30.0-jre</version>
</dependency>

<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-lang3</artifactId>
	<version>3.11</version>
</dependency>
```

