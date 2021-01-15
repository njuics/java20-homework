# 第十次作业

## 自动构建

1. **引入第三方库**

   在`pom.xml`中添加以下内容：

   **guava库**

   ```
   <dependency>
       <groupId>com.google.guava</groupId>
       <artifactId>guava</artifactId>
       <version>30.0-jre</version>    
   </dependency>
   ```

2. **代码修改**

   主要利用`google guava`库中的`Ordering`类，重构了排序部分操作。

   ```
       Ordering<T> ascsort = new Ordering<T>(){
           public int compare(T a,T b){
               return a.compareTo(b);
           }
       };
       Ordering<T> descsort = ascsort.reverse();
       Ordering<T> randomsort = Ordering.natural().nullsFirst().compound(new RandComparator<T>());
   ```

   