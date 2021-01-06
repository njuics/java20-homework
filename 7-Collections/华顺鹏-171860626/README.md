### 葫芦娃的家族不断壮大，葫芦娃的名字/性别随机生成

设计的是输入一个表示葫芦娃数量的变量，创建相应数量的葫芦娃对象。

名字的随机生成利用的是org.apache.commons.lang包下RandomStringUtils类的randomAlphabetic()方法，随机生成一个长度为5、由大小写字母组成的字符串作为葫芦娃的名字。

性别的随机生成是利用Random类的nextBoolean()方法随机生成一个Boolean变量表示男女。

### 容器类存放葫芦娃，并进行排序

利用ArrayList存放葫芦娃。

设计Hulu类实现Comparable接口，通过重载compareTo()函数，然后利用collections的静态方法sort()对葫芦娃进行排序。

借助collections的静态方法shuffle()实现乱序。

利用一个静态变量sortway控制是正序、反序还是乱序。

### 迭代打印

一种方式是直接利用循环打印排序后的ArrayList中的葫芦娃信息。

另一种方式，设计了HuluIterable类实现了Iterable接口，通过调用类中的iterator()方法，可以生成一个前向遍历的迭代器，调用reverseIterator()方法，则生成一个反向遍历的迭代器，然后借助迭代器打印已排序后的葫芦娃信息。