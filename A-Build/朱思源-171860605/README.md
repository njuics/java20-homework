# A Build

## 第三方库

使用了org.apache.commons.lang3.RandomStringUtils进行随机名称构建

```
name= RandomStringUtils.random(20, true, true);
```

## 自动构建

添加了junit的依赖

```
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>RELEASE</version>
    <scope>test</scope>
</dependency>
```

添加了第三方库的依赖
```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.11</version>
</dependency>
```

自动构建
```
mvn compile
```

运行测试
```
mvn test
```

运行程序
```
mvn exec:java -Dexec.mainClass=Main
```