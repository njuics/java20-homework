## Collections作业  
---
###  葫芦娃类Huluwa  
葫芦娃类有两个String类型的属性，name和gender用以表示姓名和性别。  
当使用构造方法Huluwa()构造对象时，将随机生成5个字符的name和其性别(Male或Female)。  

---
### 葫芦娃类比较器HuluwaAscendingComparator  
该类实现了Comparator接口，用以在排序时按升序比较葫芦娃。  
类似地，HuluwaDecendingComparator也实现了Comparator接口，用以降序排列葫芦娃。  

---
### 葫芦娃家族类Family  
该类的核心成员变量为一个ArrayList\<Huluwa\> array的容器用来储存葫芦娃。  
此外，为了完成各种排序要求，该类还实现了以下这些迭代器，供按序访问使用：  
ascendingIterator()  
decendingIterator()  
randIterator()  
maleAscendingIterator()  
maledecendingIterator()  
malerandIterator()  
femaleAscendingIterator()  
femaledecendingIterator()  
femalerandIterator()  