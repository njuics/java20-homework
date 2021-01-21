# 171830583 穆朋朋 homework10思路

本次作业基于**homework9**，增加对**Google guava**库的使用，并使用maven自动构建。

### 第三方库的使用：Google guava库
新增**HuluwaList**类的sortByName()方法时使用**Google guava**库的3个类：

```
import com.google.common.collect.Lists;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;
```
### 实现功能
1. 使用**Lists**类新建**ArrayList**对象，这个基本没什么用，只是另一种写法；
2. 使用**Ordering**类完成对**HuluwaList**的按姓名排序，并在测试类**HuluSortByNameTest**中用**Ordering**类对排序结果进行检查；
3. 使用maven完成对项目的自动构建；

### pom.xml说明
```
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding> 
    </properties>
```
前两句设置属性：JDK版本为1.8，后一句是设置编译插件的编码方式，如果没有这句，maven测试时和生成的jar包中的中文都是乱码；

```
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
        </dependency>
        
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>30.0-jre</version>
        </dependency>
    </dependencies>
```
本项目依赖的两个库Junit和Google guava，在pom.xml中配置好后就可以直接使用。

### 项目构建与执行
进入项目的pom.xml所在目录，只需执行命令
```
mvn package
``` 
即可自动完成测试并构建相应的jar包:hulusort-0.1.0.jar；

使用命令
```
java -jar .\target\hulusort-0.1.0.jar
```
可以执行我实现的**Main**类的main()函数，输出排序结果。