# A-Build作业说明

基本代码与之前作业相比没有大的改动，用guava库和apache.commons.lang3库增强了代码，用mvn构建了项目

## guava库

`import com.google.common.base.MoreObjects;`

使用其中的`toString`方法，改进了原本葫芦娃类简单的`toString`

```java
public String toString() {
    //return "name: " + name + ", gender: " + gender;
    return MoreObjects.toStringHelper("Huluwa").add("name", getName()).add("gender", getGender() == Gender.male ? "male" : "female")
            .toString();
}
```

配套更新了`pom.xml`

## apache.commons.lang3库

`import org.apache.commons.lang3.RandomUtils;`

`import org.apache.commons.lang3.RandomStringUtils;`

使用随机类进行葫芦娃名字、性别的生成

```java
name = RandomStringUtils.randomAlphabetic(5);
gender = RandomUtils.nextBoolean() == true ? Gender.male : Gender.female;
```