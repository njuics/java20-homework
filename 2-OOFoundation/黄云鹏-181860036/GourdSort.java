//package gourdsort;

public class GourdSort{
	static int babynum = 7;
	static GourdBaby[] brothers = new GourdBaby[babynum];
	static Cards cards = new Cards(babynum);
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
	public static void orchestrationSort()
	{
		int choice = 0;
		
		GrandFather gf = new GrandFather();
		gf.command(choice,brothers);
	}
	public static void choreographySort()
	{
		int choice = 0;
		
		GourdBaby.queue(choice, brothers);
		try{Thread.sleep(500);}
		catch(InterruptedException e) {System.out.println(e.toString());}
	}
	public static void printResult()
	{
		System.out.println("The result order is as below:");
		for(int i=0;i<babynum;i++)
		{
			brothers[i].numberOff();
		}
	}
}


class GourdBaby extends Thread
{
	private Color color;
	private int pos;
	private static GourdBaby[] brothers;
	GourdBaby(int v)
	{
		pos = -1;
		color = new Color(v);
	}
	public void run()
	{
		while(true)
		{
			lookAround();
			if(doneAll())
				break;
		}
	}
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
	public void numberOff()
	{
		System.out.println("I am the "+color.getColor()+" Baby!");
	}
	public boolean cmp(GourdBaby other)
	{
		if(this.getRank()<other.getRank())
			return true;
		return false;
	}
	public void swap(GourdBaby other)
	{
		int rk1 = this.getRank();
		int rk2 = other.getRank();
		this.setRank(rk2);
		other.setRank(rk1);
	}
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
	private static void threadSort()
	{
		for(int i=0;i<brothers.length;i++)
		{
			brothers[i].start();
		}
	}
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
	private static void quickSort()
	{
		
	}
	private static void mergeSort()
	{
		
	}
	public void printResult()
	{
		System.out.println("The result order is as below:");
		for(int i=0;i<brothers.length;i++)
		{
			brothers[i].numberOff();
		}
	}
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

class GrandFather
{
	private GourdBaby[] brothers;
	public boolean cmp(GourdBaby gb1,GourdBaby gb2)
	{
		if(gb1.cmp(gb2))
			return true;
		return false;
	}
	public void swap(GourdBaby gb1,GourdBaby gb2)
	{
		gb1.swap(gb2);
	}
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
	private void quickSort()
	{
		
	}
	private void mergeSort()
	{
		
	}
}

class Cards
{
	int num = 0;
	int next = 0;
	boolean[] visited;
	int[] cards;
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
	public int deal()
	{
		if(next<num)
			return cards[next++];
		return -1;
	}
	public void clear()
	{
		next = 0;
		for(int i=0;i<num;i++)
			visited[i] = false;
	}
}


