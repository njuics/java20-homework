package Units;
import java.util.Comparator;
import java.util.Random;

import Ground.Ground;
import Ground.Tile;
import UnitCollection.ORDER;


// 从人物类派生一个葫芦娃类
public class HuLuBaby extends Character{
	// 老爷爷类的索引
	private OldMan myOldMan;
	private COLOR color;
	private int seq;
	
	// 构造函数
	// 正义阵营
	// 记录出生日期
	
	public HuLuBaby(String n, Ground g, OldMan odm, int seq) {
		// TODO Auto-generated constructor stub
		this(n, 10, 100, new Random().nextBoolean(), g, odm, COLOR.values()[new Random().nextInt(7)], seq);
	}
	
	public HuLuBaby(String n, int s, int h, Boolean se, Ground g, OldMan odm) {
		// TODO Auto-generated constructor stub
		super(n, s, h, g, se);
		this.factionType = FACTION_TYPE.JUSTICE;
		myOldMan = odm;
		color = COLOR.Others;
		//myBirthTime = System.currentTimeMillis()*1000 + System.nanoTime();
		
	}
	public HuLuBaby(String n, int s, int h, Boolean se, Ground g, OldMan odm, COLOR c, int seq) {
		super(n, s, h, g, se);
		this.factionType = FACTION_TYPE.JUSTICE;
		myOldMan = odm;
		color = c;
		this.seq = seq;
	}
	
	public COLOR getColor() {
		return color;
	}
	
	public int getSeq() {
		return seq;
	}
	
	// ---- 8th hw ----
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\n\t\t" + (sex ? "Male" : "Female") + "\t" + color;
	}
	
	public static Comparator<HuLuBaby> getComparator(ORDER od, boolean b){
		switch (od) {
		case ASC:
			return getASCComparator(b);
		case DESC:
			return getDESCComparator(b);
		case RANDOM:
			return getRandomComparator();
		default:
			return getRandomComparator();
		}
	}
	
	private static Comparator<HuLuBaby> getASCComparator(boolean b){
		return (o1,o2)->{
			if (b && o1.sex != o2.sex) {
				return (o1.sex ? -1:1);
				
			}
			else {
				return o1.name.compareTo(o2.name);
			}
		};
	}
	
	private static Comparator<HuLuBaby> getDESCComparator(boolean b){
		return (o1,o2)->{
			if (b && o1.sex != o2.sex) {
				return (o1.sex ? -1:1);
			}
			else return o2.name.compareTo(o1.name);
		};
	}
	
	private static Comparator<HuLuBaby> getRandomComparator() {
		return (o1,o2)->(new Random().nextBoolean()?1:-1);
	}		
	
	// 如果右边的人比我小，则换
	public boolean swapIfMyRightIsOlderThanMe() {

		int desX = tileIAmOn.getLatitute();
		int desY = tileIAmOn.getLongitude()+1;
		if(myGr.isXYin(desX, desY)){
			Tile temT = myGr.howIsXY(desX, desY, this, sightSize);
			if (temT == null || temT.isTileEmpty())
				return true;
			else {
				HuLuBaby temHulu = (HuLuBaby)temT.getUnitOnTile();
				if (temHulu.getBirthTime() > this.birthTime)
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
	
	@Override
	public String[] situation(int line, int maxColLen) {
		// TODO Auto-generated method stub
		String []res = super.situation(line, maxColLen);
		res[3] = strComplement(this.color.toString(), maxColLen);
		res[4] = strComplement("    " + myOldMan.getName(), maxColLen);
		res[5] = strComplement("    " + String.valueOf(seq) +"th baby", maxColLen);
		return res;
	}
	

	

	
}
