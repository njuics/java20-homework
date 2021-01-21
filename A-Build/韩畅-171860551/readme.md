# HW10 更新日志

## 概述

本次项目沿用HW9包含泛型、测试用例等相关代码。使用maven对项目进行了重构。其中添加了org.apache.commons.lang3.tuple.Pair对简单寻路系统的相关方法的返回值进行了改进，从而提高了代码效率。

## 测试输出

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running BaseTest.HuLuTest

Sort my babies by the ASCorder and group by sex
Sort my babies by the DESCorder and group by sex
Sort my babies by the comparator
Sort my babies by the comparator
Sort my babies by the ASCorder and group by sex
Sort my babies by the comparator
Sort my babies by the RANDOM order
Sort my babies by the DESCorder and group by sex
Sort my babies by the ASCorder and group by sex
Sort my babies by the comparator
Sort my babies by the comparator
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.12 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.267 s
[INFO] Finished at: 2020-11-23T18:18:50+08:00
[INFO] ------------------------------------------------------------------------
```

