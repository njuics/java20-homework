# HomeworkA-Build
### 添加的第三方库
~~~ java
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.13.1</version>
~~~
----
~~~ java
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-engine</artifactId>
<version>5.5.2</version>
<scope>test</scope>
~~~
----
~~~java
<groupId>org.apache.commons</groupId>
<artifactId>commons-lang3</artifactId>
<version>3.11</version>
~~~
----
~~~java
<groupId>org.apache.commons</groupId>
<artifactId>commons-text</artifactId>
<version>1.9</version>
~~~
### 代码的增强
* 利用maven框架对代码进行了重构
* 利用Junit框架对代码进行了测试
* 利用org.apache.commonslang3.StringUtils中的StringUtils.capitalize实现了首字母大写
* 利用org.apache.commons.text中的RandomStringGenerator实现了随机生成姓名
