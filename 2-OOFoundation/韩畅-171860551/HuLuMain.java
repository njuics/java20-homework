

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
		u.oldMan.giveBirth("Red Baby");
		u.oldMan.giveBirth("Orange Baby");
		u.oldMan.giveBirth("Yellow Baby");
		u.oldMan.giveBirth("Green Baby");
		u.oldMan.giveBirth("Cyan Baby");
		u.oldMan.giveBirth("Blue Baby");
		u.oldMan.giveBirth("Purple Baby");
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
