# 自动构建作业说明

## 1. 整体说明

本次作业使用`Maven`自动构建工具，编写的`pom.xml`文件如下

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                               http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>linh</groupId>
    <artifactId>JadeEmperor</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.1</version>
        </dependency>
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>30.0-jre</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <defaultGoal>package</defaultGoal>
        <sourceDirectory>./src</sourceDirectory>
        <testSourceDirectory>./test</testSourceDirectory>
        <outputDirectory>./out</outputDirectory>
    </build>
</project>
```

其中本项目的组ID为我的名字，项目名是`JadeEmperor-1.0.0`，最终需要打包为`jar`包。项目构建时采用`jdk 1.8`编译器编译。同时，项目需要引入`org.apache.commons`、`com.google.guava`、`junit`三个第三方`jar`包，并且设定`junit`只在`test`的测试编译和测试运行范围内可用。最后，定义默认的`Maven`构建目标是生成`package`，源目录为`./src`，单元测试源代码目录为`./test`，输出的类文件目录为`./out`。

后续需要使用到的第三方库内的API有

```java
import org.apache.commons.lang3.RandomStringUtils;
import com.google.common.collect.Collections2;
import com.google.common.collect.Comparators;
import static org.junit.Assert.assertTrue;
```

注意我使用`com.google.common.collect.Comparators`，而不使用`com.google.common.collect.Ordering`的原因是Google在guava的API doc里提到如下内容：

>### For Java 8 users
>
>If you are using Java 8, this class is now obsolete. Most of its functionality is now provided by [`Stream`](https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html?is-external=true) and by [`Comparator`](https://docs.oracle.com/javase/9/docs/api/java/util/Comparator.html?is-external=true) itself, and the rest can now be found as static methods in our new [`Comparators`](https://guava.dev/releases/snapshot-jre/api/docs/com/google/common/collect/Comparators.html) class. See each method below for further instructions. Whenever possible, you should change any references of type `Ordering` to be of type `Comparator` instead. However, at this time we have no plan to *deprecate* this class.

虽然Google并不打算在现在反对使用`Ordering`类，但为了代码的向后兼容性和维护的简易性考虑，我决定不使用`Ordering`类并遵从建议：继续保留`jdk 1.8`自带的`Comparator`类，但选用Google提供的`Comparators`类的`isInOrder`方法进行测试。

## 2. 第三方库使用详细说明

### 2.1. JadeEmperor类


#### 2.1.1. org.apache.commons.lang3.RandomStringUtils

原先我采用随机数生成葫芦娃名字的方法，但`org.apache.commons.lang3.RandomStringUtils`直接提供了`random`方法用来生产随机字符串，所以我将`JadeEmperor`类中的`getGivenName()`函数简写成如下形式：

```java
private static String getGivenName() {
    return RandomStringUtils.random(rand.nextInt(2) + 1, 0x4e00, 0x9fa5, false, false);
}
```

这大大简化了代码量。

#### 2.1.2. com.google.common.collect.Collections2

原先划分葫芦娃性别队列的时候我用一个一个遍历并判断的方法，这里尝试改用`Collections2.filter`方法，可以直接创建男葫芦娃和女葫芦娃的视图，然后直接加入两个葫芦娃队列：

```java
public static void divideCalabashKids() {
	maleCalabashKidArray = new CalabashKidArrayList<>();
	maleCalabashKidArray.addAll(Collections2.filter(calabashKidArray, calabashKid -> calabashKid.getGender() == Gender.MALE));
	femaleCalabashKidArray = new CalabashKidArrayList<>();
	femaleCalabashKidArray.addAll(Collections2.filter(calabashKidArray, calabashKid -> calabashKid.getGender() == Gender.FEMALE));
}
```

虽然这样写需要遍历两次`calabashKidArray`，但使用`addAll()`方法可以相比较原来遍历`calabashKidArray`时一个一个`add()`而言获得更好的效率。此外，我让`filter`的第二个参数调用匿名的lambda表达式定义过滤规则。这样说来采用`Collections2.filter()`也算是一个有趣的尝试。

### 2.2. SortTest类

#### 2.2.1. com.google.common.collect.Comparators

在对`Sort`类的单元测试中，我原来采用了排序后从第二个元素（如果有）开始遍历直到最后一个，逐个判断相邻元素大小关系的方法（如下）

```java
@Test(timeout = 10000)
public void testInsertionSortArray() throws Exception {
	ArrayList<Integer> arrInt = createIntegerArrayList(100000);
	int arrLength = arrInt.size();
	Sort.insertionSort(arrInt);
	for(int i = 1; i < arrLength; ++i){
		assertTrue("Some pair is inversed!",
			arrInt.get(i-1) <= arrInt.get(i));
	}
}
```

但这种实现方法不是很聪明的样子，而且每次`assertTrue`都需要调用系统调用，效率较低。改用`Comparators.isInOrder()`方法后，可以对整个方法的返回值仅执行一次`assertTrue()`，提高了执行效率，减少了代码量：

```java
@Test(timeout = 10000)
public void testInsertionSortArray() throws Exception {
	ArrayList<Integer> arrInt = createIntegerArrayList(100000);
	Sort.insertionSort(arrInt);
	assertTrue("Some pair is inversed!",
		Comparators.isInOrder(arrInt, Integer::compareTo));
}
```

#### 2.2.2. org.junit.Assert.assertTrue

这里使用了`junit`第三方库的`assertTrue`作为单元测试方法，不再赘述。

## 3. 结果

```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< linh:JadeEmperor >--------------------------
[INFO] Building JadeEmperor 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ JadeEmperor ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory F:\大四上\Java高级程序设计\homework10\src\main\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ JadeEmperor ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 8 source files to F:\大四上\Java高级程序设计\homework10\out
[WARNING] /F:/大四上/Java高级程序设计/homework10/src/algorithm/Sort.java: F:\大四上\Java高级程序设计\homework10\src\algorithm\Sort.java使用了未经检查或不安全的操作。
[WARNING] /F:/大四上/Java高级程序设计/homework10/src/algorithm/Sort.java: 有关详细信息, 请使用 -Xlint:unchecked 重新编译。
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ JadeEmperor ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory F:\大四上\Java高级程序设计\homework10\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ JadeEmperor ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ JadeEmperor ---
[INFO] Surefire report directory: F:\大四上\Java高级程序设计\homework10\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running algorithm.SortTest
@BeforeClass
Begin Unit Test for Sort
End Unit Test for Sort
Begin Unit Test for Sort
End Unit Test for Sort
Begin Unit Test for Sort
End Unit Test for Sort
@AfterClass
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 13.363 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ JadeEmperor ---
[INFO] Building jar: F:\大四上\Java高级程序设计\homework10\target\JadeEmperor-1.0.0.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  17.582 s
[INFO] Finished at: 2020-11-23T22:37:24+08:00
[INFO] ------------------------------------------------------------------------
```

