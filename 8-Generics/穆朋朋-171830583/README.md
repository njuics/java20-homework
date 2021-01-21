# 171830583 穆朋朋 homework8思路

我选择从Homework3进行改写。

为HuluwaList增加泛型\<**T** extents **Huluwa**\>，得到

```public class HuluwaList<T extends Huluwa> { ... }```

优点：
1. 使**HuluwaList**支持**Huluwa**和其子类，比如可能出现的战斗型葫芦娃,增加了代码的可拓展性；
2. 同时可以防止蛇精、蝎子精等妖怪混入队列；


