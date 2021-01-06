package Units;

import Interface.ShowSituation;

public abstract class Unit implements ShowSituation{
	// 健康
	protected int health;
	// 阵营
	protected FACTION_TYPE factionType;
	// 编号
	protected int id;
	protected static int unitNum = 0;
	// 诞生时间
	protected long birthTime;
	
	public abstract int getHealth();
	public abstract FACTION_TYPE getFactionType();
	public abstract int getId();
	public abstract long getBirthTime();
	// 挪到了接口里面
	// public abstract String[] situation(int line, int maxColLen);
	
	protected String strComplement(String str, int desLen) {
		int len = desLen - str.length();
		for (int i = 0; i < len; ++i)
			str += " ";
		return str;
	}
	
	
	public Unit(FACTION_TYPE f, int h) {
		// TODO Auto-generated constructor stub
		id = unitNum;
		unitNum++;
		factionType = f;
		health = h;
		birthTime = System.currentTimeMillis()*1000 + System.nanoTime();
	}
	
	public Unit(int h)
	{
		this(FACTION_TYPE.OTHERS, h);
	}
	
	public Unit(FACTION_TYPE f)
	{
		this(f, -1);
	}
	
	public Unit()
	{
		this(-1);
	}
	
}
