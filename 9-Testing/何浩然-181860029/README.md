
我对于我的huluwa程序进行了以下的单元测试：
1. 将类命名为HuluwaSortingTest，数据域中有Sorting类的引用s，参数类型为Huluwa
2. 类中只有一个不带参数的构造函数，以此来初始化引用s，指向Sorting类的一个对象
3. 运用了  @BeforeAll，作为测试的最开始部分，输出starting作为开始字样；
    运用了    @AfterAll作为测试结束的字样，输出finished
4. 运用了@BeforeEach，判断s是否初始化成功了，不再是null，调用断言assertNotNull(s);
5. 然后是3个Test，第一个是在序列中插入原来就有的葫芦娃老大-老七，第二个是之后随机生成任意数目的葫芦娃，并且葫芦娃
的，名字和性别都是随机生成的。第三个是对序列中的葫芦娃进行排序，输出排序前后乱序和正序的葫芦娃的名字。
这其中用assertEquals(new Huluwa(i + 1).name,Integer.toString(i+1)+"brother");来比较老大-老七的姓名初始化是否正确
assertEquals(s.p.size(), num);来比较生成葫芦娃的数目是否正确
@Test(timeout = 2000)来验证排序的性能
