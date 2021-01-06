# 增加测试

添加了 HuluwaTest 类：

```java
public class HuluwaTest {
    LinkedList<Huluwa> huluwaList = new LinkedList<Huluwa>();
    @Before
    public void initList(); // 初始化列表，建立一个有 7 个葫芦娃的队列。
    @Test
    public void testSort1();// 正序排队后，对排队结果进行测试
    @Test
    public void testSort2();// 反序排队后，对排队结果进行测试
}
```