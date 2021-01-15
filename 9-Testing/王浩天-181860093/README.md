# 9-Testing作业说明  
本次作业基于Junit框架，在最初的葫芦娃排序程序（即第三次作业）上进行修改，开发的JUnit单元测试用例
## 实现思路   

### 对Orchestration和Choreography两种排序方法进行测试  
每个测试类中包含两个ArrayList<Calabash_Brothers>的葫芦娃队列  
public static ArrayList<Calabash_Brothers> start=new ArrayList<Calabash_Brothers>();//用于参与排序  
public static ArrayList<Calabash_Brothers> ans=new ArrayList<Calabash_Brothers>();//作为正确结果与排序结果进行比较  

public void create_ans()；//对ans队列进行初始化，即排列结果为1-7  
public void create_start()；//通过随机数生成1-7的随机组合对start进行初始化  
boolean if_equal(ArrayList<Calabash_Brothers> a,ArrayList<Calabash_Brothers>b)；//比较两个队列是否相同，用于判断测试的正确性  
### 进行测试  
@Test  
	public void testSort() {  
		create_ans();  
		create_start();  
		new Orchestration().sort(start);  
		assertEquals(true,if_equal(start,ans));  
	}  
经测试后，排序方法通过测试样例，返回结果为true
