### 类
Huluwa类记录七个葫芦娃，index表示葫芦娃编号，name表示葫芦娃名称。  
Grandpa类表示葫芦娃爷爷。  
Sort类为抽象排序基类，由其子类BubbleSort和InsertSort重写其方法。
### 面向对象的排序
使用面向对象的方法进行排序，orchestration与choreography最大区别就在于操作的主体一个是爷爷，一个是葫芦娃们自己。  
对于绝大多数基于比较排序来说，只需要两个基本操作比较和交换。
对于以爷爷为操作主体的orchestration方式，Grandpa中提供了  
	
	boolean compare_small(Huluwa x,Huluwa);  
	void swap(Huluwa x,Huluwa y);
	
这两个方法表示爷爷对两个葫芦娃进行比较和交换顺序的操作。  

---
对于以葫芦娃为操作主体的choreography方式，Huluwa中提供了  
  
  	boolean is_small(Huluwa y);  
 	void exchange(Huluwa y);  
    
这两个方法表示葫芦直接的比较和交换顺序的操作。
那么排序就只需要基于所提供的这两个操作进行就可以了。 
### 支持多种排序
---
为了支持多种排序算法，首先给出了Sort作为抽象基类：

	class Sort{
		void orchestration_sort(Huluwa array[],Grandpa gp){

		}
		void choreography_sort(Huluwa array[]){

		}
	}

其中的两种不同的排序由其子类重写，使用时只需要利用继承的多态性，即可轻松地转换不同的排序算法。
这里提供了冒泡和插入两种排序方法以供测试使用。

        Sort method=new BubbleSort();  
        //Sort method=new InsertSort();  
        method.choreography_sort(array);  //或method.orchestration_sort(array,gp);
