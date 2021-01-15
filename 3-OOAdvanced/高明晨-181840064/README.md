## 基本功能
### 类与接口  
---
Huluwa类记录七个葫芦娃，index表示葫芦娃编号，name表示葫芦娃名称。  
Grandpa类表示葫芦娃爷爷。  
SortMethod接口，实现两种不同方式的排序接口。  

    public interface SortMethod{
        public void orchestrationSort(Huluwa array[],Grandpa gp);
        public void choreographySort(Huluwa array[]);
    }  

Sort类为抽象排序基类，实现SortMethod接口，由其子类BubbleSort和InsertSort重写其方法。  

### 类视图  
---
![Grandpa](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuKhEIImkLd0lIinBAKYivb80WgJy_9pKn3o5vFpSWiIYrE3Sn9mS3O_IdDBoH8KA7IYZKjCQhBWiFpD5eRWyiG2hYbekXzIy5A0z0000)  
![Huluwa](http://www.plantuml.com/plantuml/png/POun2iCm34Ltdy9ZUeOicKgxTCa9r4Ia1ai6IsvIIk_U90h5K8C7FNsUVYSAMGj5DqGGyPSIomnlvzSNMDS_ujBkOwyvyEGP20s8WePXZt6XrktG1CsfhQUVwS3tb282-o0zGOoDnVphM3zJ63qkmmDumdfPrG2M6VCD2EsMrJLwtKurjKnG3TPDAjk4kgdEET5_xkCwvB5G_080)
![Sort](http://www.plantuml.com/plantuml/png/ROyn3i8m303tli8ZIFG3m52n03CZOd1JguaKuiXnG1NmTn8615Az-Sutk4kAeldg6-oJ2Xe5up4bEB7eeu4oNt5ZDm2BiLI1EWxrQ778FjyHK0IdysMr5mn3H1ZZSZFJ6yj2F0f6EytafNarbSFssRQmottlwRElNR0aJd_iCIGI_RSTXQ6yymO0)

### 面向对象的排序
---
使用面向对象的方法进行排序，orchestration与choreography最大区别就在于操作的主体一个是爷爷，一个是葫芦娃们自己。  
对于绝大多数基于比较排序来说，只需要两个基本操作比较和交换。  
对于以爷爷为操作主体的orchestration方式，Grandpa中提供了  
	
	boolean compare_small(Huluwa x,Huluwa);  
	void swap(Huluwa x,Huluwa y);
	
这两个方法表示爷爷对两个葫芦娃进行比较和交换顺序的操作。  
对于以葫芦娃为操作主体的choreography方式，Huluwa中提供了  
  
  	boolean is_small(Huluwa y);  
 	void exchange(Huluwa y);  
    
这两个方法表示葫芦直接的比较和交换顺序的操作。
那么排序就只需要基于所提供的这两个操作进行就可以了。 
### 支持多种排序
---
为了支持多种排序算法，首先给出了Sort作为抽象基类，实现SortMethod接口：

    public abstract class Sort implements SortMethod{
    }


其中的两种不同的排序由其子类重写，使用时只需要利用继承的多态性，即可轻松地转换不同的排序算法。
这里提供了冒泡和插入两种排序方法以供测试使用。

        Sort method=new BubbleSort();  
        //Sort method=new InsertSort();  
        method.choreographySort(array);  //或method.orchestrationSort(array,gp);
  
## 面向对象特性
### 封装、修饰符与访问控制
在上一次作业的基础上，将Huluwa类的两个私有属性index和name访问控制设置为private：  

        public class Huluwa{
            private int index;
            private String name;
            ...
        }  
而其它的类方法，都使用public修饰符作为访问控制。

### 继承与多态
InsertSort和BubbleSort两个类继承Sort抽象基类，并实现了Sort中两种不同的排序，从而可以使用Sort作为统一类型，进行调用相应方法，实现多态：  
    
    public class BubbleSort extends Sort{
            public void orchestrationSort(Huluwa array[],Grandpa gp){
                ...
            }
            public void choreographySort(Huluwa array[]){
                ...
            }
    }  
### 接口
抽象接口SortMethod定义了两种不同的排序，并由抽象类Sort实现：  

    public interface SortMethod{
        public void orchestrationSort(Huluwa array[],Grandpa gp);
        public void choreographySort(Huluwa array[]);
    }
### 构造器
对葫芦娃类提供构造器Huluwa(int index),由传入参数确定其name属性。
### 静态变量与静态块
对葫芦娃类定义静态变量num，用于对葫芦娃的数量进行计数，使用静态代码块进行初始化：  

    public class Huluwa{
        ...
        public static int num;
        static{
            num=0;
        }
        ...
    }

### 包
Huluwa和Grandpa放在character包中，SortMethod,Sort,BubbleSort,InsertSort,放在sort包中。  
在Main中使用时，导入：  

        import sort.*;
        import character.*;



