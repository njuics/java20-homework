# 关于这次的作业的设计思路  
葫芦娃是基类，七种不同的葫芦娃是子类，我这次依然沿用了这种设计，主要原因是想不出来在其他地方还怎么继承，怎么体现多态，虽然我个人认为用如下方式会好一些，但是我并没有在下例的实现中找到加入继承和多态的方法  
```Java
    public class Huluwa{
        int level;
        String name;
        //TODO
    }
```
当然静态变量静态块静态函数都是有的，用于统计从程序开始运行起产生的葫芦娃总数  
类图点击[这里](http://www.plantuml.com/plantuml/uml/TO_1JW8n48RlVOeU8H4VO0-6o05l4ZaPuw7fZhJ9q5cdhOGWFhjJ2w4zU9hTxvlzP_zbJ8PJtgDwofWFHW_wnr8EQV0XdKGcRy-DG_W2BEx6h46SpPjtPy8EDXHzyXHcbR-ztzM7kLgp2UDKBpcF8qCOhakDBB6hYvVuBNnc21R4xEhESDbjbVlBYRUynbb732GVJ-xO1n9R1p6nAJyiIke1VnXnM-AaJohA47vMBp3gnUBxGTS3wfbBrmwz0Y8TEhHcWD2HrT7qu15p7xF9F66FwX14kbRlqBMFgku_U5y2IosrX33cFVu2)查看