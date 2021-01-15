## 自动构建

#### 1.引用第三方库

葫芦娃名字的生成需要随机生成字符串，原本产生随机字符串时是通过不断地产生随机字符，组合成字符串。现在通过导入`org.apache.commons.text.RandomStringGenerator`，可以产生指定长度的随机字符串。



之前排序时，为了使葫芦娃能够根据名字排序，继承了`Comparable`类，重写了`CompareTo`，在实现反向排序时还定义了新的比较器，较为繁琐。因此可以使用`google guava`库中的`Ordering`排序器简化代码。实现通过名字的排序只要调用`Ordering.usingToString()`，反向排序只需调用`Ordering.usingToString().reverse()`

#### 2.编写pom.xml文件

由于引用了`org.apache.commons.text`库，因此在`pom`文件中要导入如下的依赖

```
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-text</artifactId>
    <version>1.9</version>
</dependency>
```



还引用了`google guava`库，因此`pom`文件中要增加如下内容

```
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>30.0-jre</version>    
</dependency>
```



为了使编译生成的jar文件可以通过`java -jar target.jar`直接运行，增加`build`配置

```
	<build>
        <plugins>    
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>2.5.5</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>cn.edu.nju.Main</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>    
        </plugins>
    </build>
```

