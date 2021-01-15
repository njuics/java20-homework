# 10-Build

### 自动化构建

添加了pom.xml文件，用maven构建了项目。

### 用外部依赖完善项目

1.由于之前的项目中用到了junit做单元测试，添加了junit作为依赖

2.添加了apache commons中的lang3作为依赖

```xml
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.11</version>
        </dependency>
```

其中的`StringUtils`类用来处理字符串非常方便。

用到了`RandomStringUtils`类，来实现葫芦娃名字的随机生成。

3.添加了google Guava项目的依赖供之后使用

Guava中提供了很多好用的集合类型，对java原有的集合进行补充和增强。

```xml
        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>23.5-jre</version>
        </dependency>
```