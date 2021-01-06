# 9-Testing



## 1. 测试内容

排序算法中升序和降序算法的正确性



## 2. 测试方法

在每次测试前通过：

```java
@Before
    public void setUp() {
        //random order
        queue=new ArrayList<>();
        for(int i=0;i<7;i++){
            queue.add(HuLuWa.getNewHuluwa());
        }
    }
```

随机生成大小为7的葫芦娃队列（`HuLuWa.getNewHuluwa()`返回一个名字、性别随机的葫芦娃对象）



在升序测试中调用升序算法将葫芦娃队列排序，然后检查是否排序后的葫芦娃是否为升序：

```java
@Test
    public void testAscSort() throws Exception{
        Control.ascSort(queue);
        for(int i=0;i<6;i++){
            assertTrue(queue.get(i).compareTo(queue.get(i+1))<=0);
        }
    }
```



降序算法测试方法与升序类似：

```java
@Test
    public void testDescSort() throws Exception{
        Control.descSort(queue);
        for(int i=0;i<6;i++){
            assertTrue(queue.get(i).compareTo(queue.get(i+1))>=0);
        }
    }
```



