## 测试葫芦娃

使用Junit4对Hulu类、Huluranks类、Sort类进行了测试

### 测试Hulu类

对Hulu类的3个方法进行了测试

对getName()和getGender用样例(name:007,gender:false)进行测试，测试get的名字和性别是否正确。

新建两个葫芦娃以测试compareTo()方法，修改静态成员sortway，检查compareTo()方法的行为是否正确。



### 测试Huluranks类

测试iterator()方法

构造一个名字依次为0、1、2、3、4的葫芦娃list，利用iterator()对list的成员进行正向迭代，比较每一次迭代成员的名字与预期是否相同，迭代过程中依次访问的葫芦娃的名字应该也是0、1、2、3、4，若不符合预期，说明没有正确迭代，以此来进行测试。



### 测试Sort类

测试sortbyway()和hulusort()方法

对sortbyway()方法的测试，测试其对于不同的Hulu.sortway值，排序的行为是否正确。测试了Hulu.sortway=0时，排序之后的葫芦娃list是否是升序排列，Hulu.sortway=1时，排序之后的葫芦娃list是否是降序排列。

此外，对排序的性能进行了测试，测试对50000个葫芦娃排序，程序是否可以在1000毫秒内完成。

当Hulu.sortway不为0或1或2时，没有对应的排序方式，所以sortbyway()方法应该抛出异常。利用testSortbywayException()测试输入的排序方式非法时（比如Hulu.sortway=3），sortbyway()方法有没有正确抛出异常。



测试huluSort()方法，huluSort()方法完成了两个作用，一是对葫芦娃队伍进行排序，二是将葫芦娃队伍分成男葫芦娃队和女葫芦娃队。因为其调用的sortbyway方法进行的排序，调用之后葫芦娃list是否正确排序已在sortbyway()方法中进行了测试，所以对该方法需要测试的是葫芦娃队伍分队成男葫芦娃的队伍和女葫芦娃的队伍，同性队伍中是否混入了异性。迭代检查malelist和femalist的gender即可。

另外由于程序中huluSort()是需要用到输入数据的，我将需要输入的数据写入字符串，然后传入输入流，以达到输入数据和Junit自动化测试的目的。