
// 这是一个宇宙类，以后的物理引擎也会包含在里面
public class Universe {
	// 宇宙中包含一个Ground类
	public Ground mainGr;
	// 有一个正方单位管理者类对象老爷爷
	public OldMan oldMan;
	// 正方管理者接生7个葫芦娃单位
	public Universe() {
		// TODO Auto-generated constructor stub
		mainGr = new Ground();
		
	}
	// 展示场地
	public void showTheGround() {
		System.out.print(mainGr.seeAroud());
	}
	
	//public static void main(String[] args) {
		//Universe u = new Universe();
		//u.oldMan.orderTheBabyToASeq();
		//u.mainGr.seeAroud();
	//}
	// 葫芦娃随机走上边缘
	// 老爷爷让他们走到一排按序拍好
	// 老爷爷发出随机交换指令
	// 老爷爷发出自主排序指令
	// 老爷爷发出随机交换位置指令
}
