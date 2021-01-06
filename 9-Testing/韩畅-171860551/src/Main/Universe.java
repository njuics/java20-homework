package Main;

import Ground.Ground;
import Units.OldMan;

// 这是一个宇宙类，以后的物理引擎也会包含在里面
public class Universe {
	// 宇宙中包含一个Ground类
	public Ground mainGr;
	// 有一个正方单位管理者类对象老爷爷
	public OldMan oldMan;
	// 正方管理者接生7个葫芦娃单位

	// 代码块，在宇宙诞生前的开场白
	static {
		System.out.println("混沌初开，鸿蒙始辟……");
		System.out.println("天地造化，万物灵修……");
		System.out.println("一串不起眼的葫芦藤中……");
		System.out.println("孕育着数个通灵之体……");
	}

	public Universe() {
		// TODO Auto-generated constructor stub
		mainGr = new Ground();

	}

	// 展示场地
	public void showTheGround() {
		System.out.print(mainGr.seeAroud());
	}


}
