// 包
package gourdsort;

//葫芦娃类
class GourdBaby extends Thread // 继承线程类
{
	// 私有成员变量
	private Color color;  // 颜色
	private int pos;  // 队列中的位置
	private static GourdBaby[] brothers;  // 葫芦娃队列
	// 构造方法
	GourdBaby(int v)
	{
		pos = -1;
		color = new Color(v);
	}
	// 线程执行方法
	public void run()
	{
		while(true)
		{
			lookAround();
			if(doneAll())
				break;
		}
	}
	// 其他方法
	public void setpos(int p)
	{
		pos = p;
	}
	public int getRank()
	{
		return color.getVal();
	}
	public void setRank(int v)
	{
		color.setVal(v);
	}
	// 报数方法
	public void numberOff()
	{
		System.out.println("I am the "+color.getColor()+" Baby!");
	}
	// 比较方法
	public boolean cmp(GourdBaby other)
	{
		if(this.getRank()<other.getRank())
			return true;
		return false;
	}
	// 交换方法
	public void swap(GourdBaby other)
	{
		int rk1 = this.getRank();
		int rk2 = other.getRank();
		this.setRank(rk2);
		other.setRank(rk1);
	}
	// 线程同步方法
	private synchronized void lookAround()
	{
		if(pos>0)
		{
			if(cmp(brothers[pos-1]))
				swap(brothers[pos-1]);
		}
		/*
		if(pos<brothers.length-1)
		{
			if(!cmp(brothers[pos+1]))
				swap(brothers[pos+1]);
		}
		*/
	}
	private synchronized boolean doneAll()
	{
		boolean doneall = true;
		for(int i=0;i<brothers.length;i++)
		{
			if(brothers[i].getRank()!=i)
			{
				doneall = false;
				break;
			}
		}
		return doneall;
	}
	// 排队方法（排序算法调用）
	public static void queue(int idx,GourdBaby[] bros)
	{
		brothers = bros;
		switch(idx)
		{
		case 0: threadSort(); break;
		case 1: bubbleSort(); break;
		case 2: quickSort(); break;
		case 3: mergeSort(); break;
		default: threadSort(); break;
		}
	}
	// 多线程排序
	private static void threadSort()
	{
		for(int i=0;i<brothers.length;i++)
		{
			brothers[i].start();
		}
	}
	// 冒泡排序
	private static void bubbleSort()
	{
		int n = brothers.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
			{
				if(!brothers[j].cmp(brothers[j+1]))
					brothers[j].swap(brothers[j+1]);
			}
	}
	//其他排序
	private static void quickSort()
	{
		
	}
	private static void mergeSort()
	{
		
	}
	// 内部类
	class Color
	{
		private String col = null;
		private int val = 7;
		Color(int v)
		{
			setVal(v);
		}
		public String getColor()
		{
			return col;
		}
		public int getVal()
		{
			return val;
		}
		public void setVal(int v)
		{
			val = v;
			switch(v)
			{
			case 0: col = "Red"; break;
			case 1: col = "Orange"; break;
			case 2: col = "Yellow"; break;
			case 3: col = "Green"; break;
			case 4: col = "Cyan"; break;
			case 5: col = "Blue"; break;
			case 6: col = "Purple"; break;
			default: break;
			}
		}
	}
}
