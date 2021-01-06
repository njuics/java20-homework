package gourdcollection;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class GourdCollection {
	
	public static void main(String[] args)
	{
		ArrayList<GourdBaby> gbs = new ArrayList<GourdBaby>(); // 葫芦娃数组序列
		ArrayList<GourdBaby> male_gbs = new ArrayList<GourdBaby>(); // 男葫芦娃数组序列
		ArrayList<GourdBaby> female_gbs = new ArrayList<GourdBaby>(); // 女葫芦娃数组序列
		// 随机生成15个葫芦娃
		for (int i=0;i<15;i++) { 
			GourdBaby newgb = randomGourdBaby();
			if(newgb.isMale() == true){
				male_gbs.add(newgb); // 生成男葫芦娃数组序列
			}
			else {
				female_gbs.add(newgb); // 生成女葫芦娃数组序列
			}
			gbs.add(newgb); // 生成葫芦娃数组序列
		}
		
		// 葫芦娃原始序列
		System.out.println("======葫芦娃原始随机序列======");
		for (GourdBaby gb:gbs) {
			gb.selfIntroduce();
		}
		// 正序排序测试(Comparable)
		System.out.println("========葫芦娃正序序列=======");
		sortByComparable(gbs);
		// 反序排序测试(Comparator)
		System.out.println("========葫芦娃反序序列=======");
		sortByInvertedComparator(gbs);
		// 正序排序测试(Comparator)
		System.out.println("========葫芦娃正序序列=======");
		sortByNormalComparator(gbs);
		// 乱序排序测试(Comparator)
		System.out.println("========葫芦娃乱序序列=======");
		sortByRandomComparator(gbs);
		
		// 男葫芦娃原始序列
		System.out.println("======男葫芦娃原始随机序列======");
		for (GourdBaby gb:male_gbs) {
			gb.selfIntroduce();
		}
		// 正序排序测试(Comparable)
		System.out.println("========男葫芦娃正序序列=======");
		sortByComparable(male_gbs);
		
		// 女葫芦娃原始序列
		System.out.println("======女葫芦娃原始随机序列======");
		for (GourdBaby gb:female_gbs) {
			gb.selfIntroduce();
		}
		// 正序排序测试(Comparator)
		System.out.println("========女葫芦娃正序序列=======");
		sortByNormalComparator(female_gbs);
	}
	public static GourdBaby randomGourdBaby(){ // 随机生成一个葫芦娃
		String name = "";
		String sex = "";
		Random r = new Random();
		for(int i=0;i<4;i++)
		{
			int rand = 0;
			if (i == 0){
				rand = 'A'+Math.abs(r.nextInt() % 26);
			}
			else {
				rand = 'a'+Math.abs(r.nextInt() % 26);
			}
			
			name += (char)rand;
		}
		if (r.nextBoolean() == true) {
			sex = GourdBabySex.male;
		}
		else {
			sex = GourdBabySex.female;
		}
		
		GourdBaby gb = new GourdBaby(name,sex);
		return gb;
	}
	public static void sortByComparable(ArrayList<GourdBaby> gbs) {// 利用葫芦娃的compareTo方法正序排序
		Collections.sort(gbs);
		Iterator<GourdBaby> iter = gbs.iterator();
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
	}
	public static void sortByNormalComparator(ArrayList<GourdBaby> gbs) { // 利用 GourdBabyNormalComparator的compare方法正序排序
		Collections.sort(gbs,new  GourdBabyNormalComparator());
		Iterator<GourdBaby> iter = gbs.iterator(); // 利用iterator接口实现遍历
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
	}	
	public static void sortByInvertedComparator(ArrayList<GourdBaby> gbs) {// 利用 GourdBabyInvertedComparator的compare方法反序排序
		Collections.sort(gbs,new  GourdBabyInvertedComparator());
		Iterator<GourdBaby> iter = gbs.iterator(); // 利用iterator接口实现遍历
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
	}
	public static void sortByRandomComparator(ArrayList<GourdBaby> gbs) {// 利用 GourdBabyRandomComparator的compare方法乱序排序
		Collections.sort(gbs,new  GourdBabyRandomComparator());
		Iterator<GourdBaby> iter = gbs.iterator(); // 利用iterator接口实现遍历
		while(iter.hasNext()) {
			iter.next().selfIntroduce();
		}
	}
	
}
