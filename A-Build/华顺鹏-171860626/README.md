# 使用第三方库

### Apache Commons

使用了包中的RandomStringUtils类，用来随机生成葫芦娃的名字

### Google Guava

使用了包中的Lists和Ordering，帮助生成葫芦娃队伍和排序的比较器



# 使用maven自动构建

### 添加依赖

<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.7</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/com.google.guava/guava-collections -->
    <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava-collections</artifactId>
      <version>r03</version>
    </dependency>

  </dependencies>

