// 从人物类派生一个葫芦娃类
public class HuLuBaby extends Character{
	// 老爷爷类的索引
	private OldMan myOldMan;
	// 出生日期
	private long myBirthTime;
	// 获得我的出生日期
	public long getMyBirthTime() {
		return myBirthTime;
	}
	
	// 构造函数
	// 正义阵营
	// 记录出生日期
	public HuLuBaby(String n, int s, int h, Ground g, OldMan odm) {
		// TODO Auto-generated constructor stub
		super(n, s, h, g);
		this.factionType = FACTION_TYPE.JUSTICE;
		myOldMan = odm;
		myBirthTime = System.currentTimeMillis()*1000 + System.nanoTime();
		
	}
	// 如果右边的人比我小，则换
	public boolean swapIfMyRightIsOlderThanMe() {

		int desX = tileIAmOn.getLatitute();
		int desY = tileIAmOn.getLongitude()+1;
		if(myGr.isXYin(desX, desY)){
			Tile temT = myGr.howIsXY(desX, desY, tileIAmOn, sightSize);
			if (temT == null || temT.isUnitEmpty())
				return true;
			else {
				HuLuBaby temHulu = (HuLuBaby)temT.getUnitOnTile();
				if (temHulu.getMyBirthTime() > this.myBirthTime)
					return true;
				else {
					this.swap(temT);
					return false;
				}
			}
				
		}
		else {
			return true;
		}
	}
}
