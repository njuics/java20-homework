# 用 Maven 构建项目

本次实验代码基本沿用上一次的代码，但是使用了 Guava 第三方库对代码进行了重构

* 使用了 `com.google.common.base.MoreObjects` 类的 `toStringHelper` 方法重写了类型的 `toString()` 方法
* 使用了 `com.google.common.collect.Ordering` 创建了比较器用于测试，之前测试排序功能是 clone 一个新的列表然后使用 Java 原生的排序方法对其排序后使用 assertEquals 进行比较，现在只需要用类型本身的比较方法实现一个 `Ordering` 对象，然后调用其 `isOrdered` 方法即可

除此之外，由于引入了第三方库，故在 pom.xml 中添加了 maven-assembly-plugin 这个插件，用于打包带有依赖的 jar 包，可以直接 `java -jar target/xxx.jar` 运行，打包命令为

```
mvn assembly:single
```