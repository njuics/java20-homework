package gourdcollection;

import java.util.Comparator;
import java.util.Random;

class GourdBabyNormalComparator implements Comparator<GourdBaby> { // 正序比较器
	public int compare(GourdBaby gb1, GourdBaby gb2) { // 重写compare方法
		return gb1.compareTo(gb2);
	}
}

class GourdBabyInvertedComparator implements Comparator<GourdBaby> { // 逆序比较器
	public int compare(GourdBaby gb1, GourdBaby gb2) { // 重写compare方法
		return -gb1.compareTo(gb2);
	}
}

class GourdBabyRandomComparator implements Comparator<GourdBaby> { // 乱序比较器
	public int compare(GourdBaby gb1, GourdBaby gb2) { // 重写compare方法
		Random r = new Random();
		int rand1 = r.nextInt();
		int rand2 = r.nextInt();
		return rand1-rand2;
	}
}
