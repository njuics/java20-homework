# A-Build

这次作业中，使用Apache Commons和Google Guava第三方库对葫芦娃程序进行了以下修改：

1. 原本测试程序中对葫芦娃的队列进行排序时，按名字的字典序升序排序使用葫芦娃类的compareTo方法，降序和随机序则使用huluwa.tools包中的DescendingComparator和RandomComparator两个类。引入Guava库后，使用com.google.common.collect.Ordering类代替Comparator作为比较器，compareTo方法用Ordering.natural()方法返回的自然序比较器代替，DescendingComparator用Ordering.natural()和Ordering.reverse()方法产生的自然序逆序比较器代替，而RandomComparator则用Ordering.arbitraty()方法返回的随机比较器代替。

   这样做之后不仅程序中不再需要这几个被替代的类，减少了代码量，并且可以使用Ordering.isOrdered()方法直接检验队列是否符合特定的顺序，比原先排序后用循环遍历队列要方便得多。

2. 程序中用huluwa.tools包中的GenderFilter类来获取葫芦娃的队列中，指定性别葫芦娃的子队列，该类原先使用遍历原队列的方法将指定性别的葫芦娃逐个加入子队列中，引入Apache Commons Collections库后，改为使用org.apache.commons.collections4.CollectionUtils类的filter方法，只需要三行代码就能完成筛选性别的任务：

   ```java
   static public <T extends Character> List<T> filter(List<T> list, Gender gender) {
       ArrayList<T> subList = new ArrayList<>(list);
       CollectionUtils.filter(subList, t -> t.getGender() == gender);
       return subList;
   }
   ```

   比原先要简洁许多。

此外，程序中在测试葫芦娃CalabashBrother类的两个Choreography形式排序方法时，需要提供较大的栈空间，即为JVM提供参数-Xss128m，这个设置原先只能配置在IDE中。而在使用Maven进行自动构建之后，通过在pom.xml里加入一个build plugin，可以将该设置变为“可移植”的，在其他机器上构筑时也能自动根据该设置进行测试。