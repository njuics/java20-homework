# 9-Testing

181860051	李舟俊潇



​	本次作业针对`7-Collections`和`8-Generics`的代码进行测试。测试的主要功能为葫芦娃姓名产生的互异性、分性别筛选的正确性和排序（升序、倒序、乱序）的正确性。

​	在测试类`CalabashBrothersTest`中，我定义了一个`ArrayList`，用以存储随机产生（在构造函数中进行）的用来测试的葫芦娃序列。



## 姓名互异性测试

​	因为要对每个葫芦娃进行区分，所以要对随机产生的葫芦娃姓名进行互异性测试，即判断是否两两互异，当存在两者相同时则测试不通过。

​	代码如下：

```java
	@Test
    public void repetitiveNameTest(){
        System.out.println("repetitiveNameTest");
        for(int i=0;i<num;++i){
            for(int j=i+1;j<num;++j){
                Assert.assertNotEquals(bro.get(i),bro.get(j));
            }
        }
    }
```





## 性别测试

​	通过遍历原类中筛选不同性别葫芦娃的函数结果的正确性，我将这些函数的筛选结果进行遍历，判断结果中每个葫芦娃的性别是否与正确的性别相同，若不同则测试不通过。

​	代码如下：

```java
    @Test
    public void maleTest(){
        System.out.println("maleTest");
        ArrayList<Brother> boy=CalabashBrothersSort.findMale(bro);
        Iterator<Brother> it=boy.iterator();
        if(it.hasNext())
            Assert.assertEquals(it.next().gender,true);
    }
    @Test
    public void femaleTest(){
        System.out.println("femaleTest");
        ArrayList<Brother> girl=CalabashBrothersSort.findFemale(bro);
        Iterator<Brother> it=girl.iterator();
        if(it.hasNext())
            Assert.assertEquals(it.next().gender,false);
```





## 排序测试

​	对于升序、降序的验证，只需要对在原类中排序的结果与调用了`Collections.sort`方法排序后的结果进行比较，若有不同则测试不通过。

​	对于乱序的验证，则需要验证排序后的结果与原来的结果、升序排序后的结果、倒序排序后的结果都不同，若有相同则测试不通过。

​	代码如下：

```java
	@Test
    public void ascendingSequenceTest(){
        System.out.println("ascendingSequenceTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,1);
        Collections.sort(bro);
        Assert.assertEquals(result,bro);
    }
    @Test
    public void descendingSequenceTest(){
        System.out.println("descendingSequenceTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,2);
        Collections.sort(bro);
        Collections.reverse(bro);
        Assert.assertEquals(result,bro);
    }
    @Test
    public void outOfOrderTest(){
        System.out.println("outOfOrderTest");
        ArrayList<Brother> result=CalabashBrothersSort.brosSort(bro,3);
        Assert.assertNotEquals(result,bro);
        Collections.sort(bro);
        Assert.assertNotEquals(result,bro);
        Collections.reverse(bro);
        Assert.assertNotEquals(result,bro);
    }
```

