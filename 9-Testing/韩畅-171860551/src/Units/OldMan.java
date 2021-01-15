package Units;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import Ground.Ground;
import Ground.Tile;
import UnitCollection.CharacterColl;
import UnitCollection.ORDER;

public class OldMan extends Character {
//	private Vector<HuLuBaby> childList;
	private CharacterColl<HuLuBaby> childList;

	// ---- 一些随机起名的参数 ----
	private static final String FuYinBase = "bcdfghjklmnpqrstvwxyz";
	private static final String YuanYinBase = "aeiou";
	private static final String FuYinBaseSuf = "ygklmnpsxztv";
	private static final int MIN_NAME_LEN = 2;
	private static final int NAME_LEN_OFF = 2;

	private String randANewName()
	{
		Random rand = new Random();
		int wordsNum = MIN_NAME_LEN + rand.nextInt(NAME_LEN_OFF);
		StringBuilder nameBd = new StringBuilder();
		for (int i = 0; i < wordsNum; ++i){
			int fuYinInd1 = rand.nextInt(FuYinBase.length());
			int fuYinInd2 = rand.nextInt(FuYinBaseSuf.length());
			int yuanYinInd = rand.nextInt(YuanYinBase.length());
			
			nameBd.append(FuYinBase.charAt(fuYinInd1));
			nameBd.append(YuanYinBase.charAt(yuanYinInd));
			nameBd.append(FuYinBaseSuf.charAt(fuYinInd2));
			if (i != wordsNum-1)
				nameBd.append(" ");
		}
		return nameBd.toString();
	}
	
	// 构造函数
	// 阵营为正义阵营，维持一个葫芦娃的名单表
	public OldMan(String n, int s, int h, Ground g) {
		// TODO Auto-generated constructor stub
		super(n, s, h, g, true);// 必然是男性
		this.factionType = FACTION_TYPE.JUSTICE;
		//childList = new Vector<HuLuBaby>();
		childList = new CharacterColl<>();
	}

	// 为葫芦娃接生，需要给出名字
//	public void giveBirth(String n, COLOR c) {
//		childList.add(new HuLuBaby(n, 10, 100, new Random().nextBoolean(), myGr, this, c, childList.size() + 1));
//	}
//
//	public void giveBirth(){
//		Random r = new Random();
//		childList.add(new HuLuBaby(randANewName(), 10, 100, r.nextBoolean(), myGr, this, COLOR.values()[r.nextInt(7)], childList.size() + 1));
//	}
	
	// ---8th hw 之前由老爷爷决定葫芦娃的视野和血量等实现不太合适
	// --- 下面的实现将属于两侧的属性区分开来
	public void giveBirth(){
		Random r = new Random();
		childList.add(new HuLuBaby(randANewName(),myGr, this, childList.size() + 1));
	}
	// 使自己踏入地块中，仅仅做尝试
	public void getMeIn() {
		// TODO 错误检测
		findAMerginToStepIn();
	}

	// 使所有葫芦娃踏入地块中
	public void getAllTheBabyIn() {
		// TODO 错误检测
		Iterable<HuLuBaby> ls = childList.getIterable();
		for (HuLuBaby hu : ls) {
			hu.findAMerginToStepIn();
		}
	}

	// 命令所有的葫芦娃走到1,0至1,6的位置
	public void orderTheBabyToASeq() {
		// TODO 命令友方做移开尝试
		boolean success = true;
		for (int j = 0; j < 3; ++j) {
			for (int i = 0; i < 7; ++i) {
				if (childList.get(i).findWayToXY(1, i) == false)
					success = false;
			}
			if (success == true)
				break;
		}
	}

	// 命令葫芦娃随机平行交换位置
	public void exchangeRandomly() {
		for (int i = 0; i < 20; ++i) {
			Random r = new Random();
			int temR = r.nextInt(7);
			// 随机到一个葫芦娃
			Tile temT = myGr.whereIsHim(childList.get(temR));
			HuLuBaby temBaby = childList.get(temR);
			if (temT != null && temT.getLongitude() > 0) {
				// TODO 这里的逻辑有点小问题，换位置不需要这么复杂
				Tile des = myGr.howIsXY(temT.getLatitute(), temT.getLongitude() - 1, temBaby, sightSize);
				temBaby.swap(des);
			}
		}
	}

	// 命令各个葫芦娃互相自行调整位置以排序
	public void orderTheBabySwapToSort() {
		boolean done = false;
		while (done == false) {
			done = true;
			for (int i = 0; i < 7; ++i) {

				if (!childList.get(i).swapIfMyRightIsOlderThanMe())
					done = false;
			}
		}
	}

	@Override
	public String[] situation(int line, int maxColLen) {
		// TODO Auto-generated method stub
		return super.situation(line, maxColLen);
	}
	
	public void ReadOutMyBabyListByIterable() {
		System.out.println("Read Out My Baby List By Iterable: ");
		Iterable<HuLuBaby> ls = childList.getIterable();
		int i = 1;
		for (HuLuBaby h: ls) {
			System.out.println(String.valueOf(i++) + " " + h);
		}
	}
	
	public void ReadOutMyBabyListByIterator() {
		System.out.println("Read Out My Babies By Iterator: ");
		Iterator<HuLuBaby> it = childList.getIterator();
		int i = 1;
		while(it.hasNext()) {
			System.out.println(String.valueOf(i++) + " " + it.next());
		}
	}
	
	public void sortChildList(ORDER od) {
		System.out.println("Sort my babies by the " + od + " order");
		childList.sortLs(od);
	}
	
	public void sortChildList(ORDER od, boolean sex) {
		System.out.println("Sort my babies by the " + od + "order and group by sex" );
		childList.sortLs(od, sex);
	}
	
	public void sortChildListByComparator(ORDER o, boolean b) {
		Comparator<HuLuBaby> c = HuLuBaby.getComparator(o,b);
		System.out.println("Sort my babies by the comparator");
		childList.sortByComparator(c);
	}
	
	public void shuffle() {
		System.out.println("Shuffling ... ");
		childList.shuffle();
	}
	
	public CharacterColl<HuLuBaby> getChildList(){
		return childList;
	}
	
}
