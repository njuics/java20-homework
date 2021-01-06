// 包
package gourdsort;
// 主类
public class GourdSort{
	// 静态变量
	static int babynum;
	static GourdBaby[] brothers;
	static Cards cards;
	// 静态块
	static {
		babynum = 7;
		brothers = new GourdBaby[babynum];
		cards = new Cards(babynum);
	}
	// 主方法
	public static void main(String[] args)
	{
		System.out.println("-----The first way to sort as orchestration-----");
		initialize();
		orchestrationSort();
		printResult();
	
		System.out.println("-----The second way to sort as choreography-----");
		initialize();
		choreographySort();
		printResult();
	}
	// 初始化方法
	public static void initialize()
	{
		cards.shuffle();
		for(int i=0;i<babynum;i++)
		{
			brothers[i] = new GourdBaby(cards.deal());
			brothers[i].setpos(i);
		}
		System.out.println("The original order is as below:");
		for(int i=0;i<babynum;i++)
		{
			brothers[i].numberOff();
		}
	}
	// orchestration 排序方法
	public static void orchestrationSort()
	{
		int choice = 0;
		
		GrandFather gf = new GrandFather();
		gf.command(choice,brothers);
	}
	// choreography 排序方法
	public static void choreographySort()
	{
		int choice = 0;
		
		GourdBaby.queue(choice, brothers);
		try{Thread.sleep(500);}
		catch(InterruptedException e) {System.out.println(e.toString());}
	}
	// 结果显示方法
	public static void printResult()
	{
		System.out.println("The result order is as below:");
		for(int i=0;i<babynum;i++)
		{
			brothers[i].numberOff();
		}
	}
}

// 葫芦娃比较/交换操作接口
interface GourdCmpSwap{
	public abstract boolean cmp(GourdBaby gb1,GourdBaby gb2);
	public abstract void swap(GourdBaby gb1,GourdBaby gb2);
}






