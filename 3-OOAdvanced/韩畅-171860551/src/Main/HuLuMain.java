package Main;

import Units.COLOR;
import Units.OldMan;

// 此处为葫芦娃程序的入口
public class HuLuMain {

	public static void main(String[] args) {
		// 宇宙引擎诞生 场地初始化
		Universe u = new Universe();
		// 老爷爷诞生
		u.oldMan = new OldMan("Old Man", 100, 100, u.mainGr);
		// 老爷爷走上自己的场地
		u.oldMan.getMeIn();
		// 引擎展示场地情况
		u.showTheGround();
		// 老爷爷为各个葫芦娃接生（同时取名）
		u.oldMan.giveBirth("Red Baby", COLOR.RED);
		u.oldMan.giveBirth("Orange Baby", COLOR.ORANGE);
		u.oldMan.giveBirth("Yellow Baby", COLOR.YELLOW);
		u.oldMan.giveBirth("Green Baby", COLOR.GREEN);
		u.oldMan.giveBirth("Cyan Baby", COLOR.CYAN);
		u.oldMan.giveBirth("Blue Baby", COLOR.BLUE);
		u.oldMan.giveBirth("Purple Baby", COLOR.PURPLE);
		// 老爷爷让所有的葫芦娃走上场地
		u.oldMan.getAllTheBabyIn();
		// 引擎展示场地情况
		u.showTheGround();
		// 老爷爷让所有的葫芦娃走成一个有序的排列
		u.oldMan.orderTheBabyToASeq();
		// 引擎展示场地情况
		u.showTheGround();
		// 老爷爷让各个葫芦娃随机交换位置
		u.oldMan.exchangeRandomly();
		
		// 引擎展示场地情况
		u.showTheGround();
		// 老爷爷让各个葫芦娃自行商量交换位置以排成有序
		u.oldMan.orderTheBabySwapToSort();
		// 引擎展示场地情况
		u.showTheGround();
	}
}
