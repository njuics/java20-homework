// 包
package gourdsort;

//爷爷类
class GrandFather implements GourdCmpSwap // 实现了葫芦娃比较/交换接口
{
	private GourdBaby[] brothers;
	// 比较方法
	public boolean cmp(GourdBaby gb1,GourdBaby gb2)
	{
		if(gb1.cmp(gb2))
			return true;
		return false;
	}
	// 交换方法
	public void swap(GourdBaby gb1,GourdBaby gb2)
	{
		gb1.swap(gb2);
	}
	// 指挥方法（排序算法调用）
	public void command(int idx,GourdBaby[] bros)
	{
		brothers = bros;
		switch(idx)
		{
		case 0: bubbleSort(); break;
		case 1: quickSort(); break;
		case 2: mergeSort(); break;
		default: bubbleSort(); break;
		}
		
	}
	// 冒泡排序
	private void bubbleSort()
	{
		int n = brothers.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
			{
				if(!cmp(brothers[j],brothers[j+1]))
					swap(brothers[j],brothers[j+1]);
			}
	}
	// 其它排序
	private void quickSort()
	{
		
	}
	private void mergeSort()
	{
		
	}
}
