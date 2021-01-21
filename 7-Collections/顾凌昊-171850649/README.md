# 改进葫芦娃管理系统
## 葫芦娃类
利用构造器支持随机生成葫芦娃，包括英文姓名和性别； 
实现Comparable接口，能够和其他葫芦娃进行比较 
## 葫芦娃管理接口
将葫芦娃的添加、排序和打印操作抽象成一个接口。给出了Grandpa和SuperGrandpa两个实现类 
## Grandpa类
利用Collections API和其中的ArrayList类实现了葫芦娃的管理； 
额外支持葫芦娃的随机排序以及返回某一性别的葫芦娃列表 
## SuperGrandpa类
该类不使用Collections中的现有方法，通过实现Comparator、Iterable接口完成葫芦娃的管理 
用数组存储葫芦娃数据。具有一个实现了Iterator接口的内部类，用以实现对葫芦娃数组的遍历
