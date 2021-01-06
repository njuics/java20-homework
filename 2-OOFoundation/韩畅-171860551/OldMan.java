import java.util.Random;
import java.util.Vector;

public class OldMan extends Character {
	private Vector<HuLuBaby> childList;

	// 构造函数
	// 阵营为正义阵营，维持一个葫芦娃的名单表
	public OldMan(String n, int s, int h, Ground g) {
		// TODO Auto-generated constructor stub
		super(n, s, h, g);
		this.factionType = FACTION_TYPE.JUSTICE;
		childList = new Vector<HuLuBaby>();
	}
	// 为葫芦娃接生，需要给出名字
	public void giveBirth(String n) {
		childList.add(new HuLuBaby(n, 10, 100, myGr, this));
	}

	// 使自己踏入地块中，仅仅做尝试
	public void getMeIn() {
		// TODO 错误检测
		findAMerginToStepIn();
	}

	// 使所有葫芦娃踏入地块中
	public void getAllTheBabyIn() {
		// TODO 错误检测
		for (HuLuBaby hu : childList) {
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
			if (temT != null && temT.getLongitude() > 0) {
				// TODO 这里的逻辑有点小问题，换位置不需要这么复杂
				Tile des = myGr.howIsXY(temT.getLatitute(), temT.getLongitude() - 1, temT, sightSize);
				childList.get(temR).swap(des);
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
}
