# 171830583 穆朋朋 homework9思路

添加了两个测试：
1. HuluwaListTest测试类
    测试HuluwaList的泛型功能，看HuluwaList<T extends Huluwa>类是否支持Huluwa的派生类：class HuluwaCombat extends Huluwa
2. HuluSortTest测试类
    测试3种排序器的功能是否正确；思路是先构造一个有序的HuluwaList的对象和3个无序的HuluwaList的对象，对无序的3个对象分别用3种排序器排序，再和有序的HuluwaList对象比较；