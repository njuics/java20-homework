本次作业在前面作业的基础上加入了maven的自动构建和google-guava的第三方库扩展

maven配置等操作基本严格按照指南手册的要求进行

guava的使用主要在排序器Ordering方面，利用其中的`natural(),reverse(),from()`等方法直接对`Hulus`类进行排序（按名字的字典正/反序）；并且在测试环节利用`isOrdered()`方法来判断是否已经排好序
