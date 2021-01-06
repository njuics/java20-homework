# 9-Testing

在本次作业中，根据"Test everything that could possibly break"的原则，为葫芦娃程序开发了以下单元测试，测试类源文件在test子目录下：

1. BubbleSorterTest

   这是对冒泡排序器BubbleSorter类的单元测试类，对它用于排序的方法sort()进行了不同的单元测试：

   ```java
   public <T extends Swappable<T>> void sort(List<T> list, Comparator<? super T> comparator)
   ```

   单元测试类在initQueue()方法中初始化一个由1000个葫芦娃组成的队列，在每次测试之前，执行shuffle()方法打乱队列的顺序，从而避免了初始化多个队列。然后在testSortAscending(), testSortDescending(), testSortRandom()三个测试方法中，将字典序升序、降序和随机序的Comparator作为参数传给sort()方法，对队列进行排序。完成排序后，遍历一遍队列，利用junit的断言方法检查队列是否符合规定的顺序。下面是这些方法所使用的注解：

   ```java
   @BeforeClass
   public static void initQueue()
   @Before
   public void shuffle()
   @Test
   public void testSortAscending()
   @Test
   public void testSortDescending()
   @Test
   public void testSortRandom()
   ```

2. QuickSorterTest

   这是对快速排序器QuickSorter类的单元测试类，同样测试它实现快速排序的方法sort()。

   QuickSorterTest类中初始化队列，以及打乱队列顺序，执行测试的方法和BubbleSorterTest类中的相似，不过它使用由50000个葫芦娃组成的队列。并且在每个测试中，除了检查排序结果的正确性，还设置了@Test注解的属性timeout = 2000，即要求排序(和检查)要在2s内完成，以此来体现快速排序的效率。

3. CalabashBrotherTest

   这是对于葫芦娃CalabashBrother类的单元测试类。葫芦娃类中需要测试的方法包括bubbleSort()和quickSort()，这两个方法是Choreography方式的排序方法(两个Sorter中实现的是Orchestration方式的排序)：

   ```java
   public void bubbleSort(List<CalabashBrother> list, int lastIndex,
                          Comparator<? super CalabashBrother> comparator) throws NotInQueueException
       
   public void quickSort(List<CalabashBrother> list, CalabashBrother base,
                             int baseIndex, boolean forward, Comparator<? super CalabashBrother> comparator)
       throws NotInQueueException
   ```

   仍然使用与BubbleSorterTest中相同的方法初始化葫芦娃的队列，打乱顺序，执行测试。对于冒泡排序和快速排序，使用两条不同的长度为1000和50000的队列。除了对冒泡排序和快速排序使用不同顺序的排序结果进行正确性的检查以外，也对快速排序的用时做了要求。并且，这两个方法是会抛出NotInQueueException异常的，这个自定义异常表示调用方法的葫芦娃本身并不在队列list中。针对这个异常，另外设计了两个方法，检查在这种情况下方法是否能正确地抛出异常：

   ```java
   @Test(expected = NotInQueueException.class)
   public void testBubbleSortException() throws Exception
   @Test(expected = NotInQueueException.class)
   public void testQuickSortException() throws Exception
   ```

   **需要注意的是，由于实现中使用葫芦娃之间的相互调用来代替Choreography体系中消息的传递，在执行CalabashBrotherTest类中的测试时，需要提供较大的栈空间。经测试，64M大小可以满足条件。**

4. GenderFilterTest

   对于GenderFilter类的单元测试，这个类提供静态方法filter()从队列中过滤出指定性别角色的子队列：

   ```java
   static public <T extends Character> List<T> filter(List<T> list, Gender gender)
   ```

   测试流程比较简单，在测试方法中初始化一条葫芦娃的队列(性别随机生成)，然后用filter()方法分别过滤出男性、女性的子队列。再检查过滤的结果是否正确即可。