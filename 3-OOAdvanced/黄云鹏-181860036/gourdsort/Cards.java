// 包
package gourdsort;

//卡牌类
class Cards
{
	int num = 0;
	int next = 0;
	boolean[] visited;
	int[] cards;
	// 构造方法
	Cards(int n)
	{
		num = n;
		visited = new boolean[num];
		cards = new int[num];
		for(int i=0;i<num;i++)
		{
			visited[i] = false;
			cards[i] = i;
		}
	}
	// 洗牌方法
	public void shuffle()
	{
		clear();
		for(int i=0;i<num;i++)
		{
			while(true)
			{
				int rand = (int)(100*Math.random())%num;
				if(visited[rand])
					continue;
				cards[i] = rand;
				visited[rand] = true;
				break;
			}
		}
	}
	// 发牌方法
	public int deal()
	{
		if(next<num)
			return cards[next++];
		return -1;
	}
	// 清局方法
	public void clear()
	{
		next = 0;
		for(int i=0;i<num;i++)
			visited[i] = false;
	}
}