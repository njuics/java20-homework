### 测试

用`Junit`对工具类`Sort`进行测试。



新建测试类`SortTest`并`import`所需的库。

```java
import org.junit.*;
import static org.junit.Assert.*;
```

在测试前后输出提示语。

```java
	@BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Test begin.");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        System.out.println("Test end.");
    }
```

分别对不同的数据对象，测试按默认顺序排序和按给定比较器排序两种排序方式。

`int`:

```java
@Test
    public void testInt() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 8, 9));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 8, 9));

        new Sort<Integer, Comparator<Integer>>().sort(arrayList);
        for (int i = 0; i < 6; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

@Test
    public void testIntComparator() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 4, 2, 6, 8, 9));
        ArrayList<Integer> testList = new ArrayList<>(Arrays.asList(9, 8, 6, 4, 2, 1));
        new Sort<Integer, Comparator<Integer>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 6; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }
```

`double`:

```java
@Test
    public void testDouble() {
        ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(4.5, 5.7, 2.8, 3.0, 1.3));
        ArrayList<Double> testList = new ArrayList<>(Arrays.asList(1.3, 2.8, 3.0, 4.5, 5.7));

        new Sort<Double, Comparator<Double>>().sort(arrayList);
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }

    }

@Test
    public void testDoubleComparator() {
        ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(4.5, 5.7, 2.8, 3.0, 1.3));
        ArrayList<Double> testList = new ArrayList<>(Arrays.asList(5.7,4.5,3.0,2.8,1.3));

        new Sort<Double, Comparator<Double>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }
```

`String`:

```java
@Test
    public void testString() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("ac", "bd", "ae", "bbc", "cnn"));
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("ac", "ae", "bbc", "bd", "cnn"));

        new Sort<String, Comparator<String>>().sort(arrayList);
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }

@Test
    public void testStringComparator() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("ac", "bd", "ae", "bbc", "cnn"));
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("cnn", "bd", "bbc", "ae", "ac"));

        new Sort<String, Comparator<String>>().sort(arrayList, Collections.reverseOrder());
        for (int i = 0; i < 5; i++) {
            assertEquals(arrayList.get(i), testList.get(i));
        }
    }
```



测试后发现原有排序有错误。。。修改后测试通过。



启示：单元测试真的很重要。

