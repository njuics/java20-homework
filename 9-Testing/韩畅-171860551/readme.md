# 第九次作业更新日志

## 概况

此次作业基于第八次泛型项目的基础上，利用JUnit对项目中相对重要的几个部分进行了单元测试。

## 测试内容

* @Before init  在单次测试方法开始前进行一些老爷爷类的生成和对葫芦娃的接生、起名等初始化工作
* @Test test_OldMan_GiveBirth  测试了老爷爷起名是否按照相关标准
* @Test(timeout = 1000) test_SortTime   测试了限定时间内排序是否可以完成
* @Test test_SortResult 测试了排序的结果是否正确