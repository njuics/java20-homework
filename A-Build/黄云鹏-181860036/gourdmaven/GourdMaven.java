package gourdmaven;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class GourdMaven {

	public static void main(String[] args) {
		int num = RandomUtils.nextInt()%5+5; // 葫芦娃数量
		GourdBaby[] gbs = ArrayUtils.toArray(); // 葫芦娃数组
		for (int i=0;i<num;i++) { // 随机生成葫芦娃数组
			GourdBaby gb = randomGourdBaby();
			gbs = ArrayUtils.add(gbs,gb);
		}
		
		bubbleSort(gbs); // 为葫芦娃数组排序
		
		System.out.println("======向大陆同胞自我介绍======");
		for(GourdBaby gb:gbs) {
			gb.selfIntroduce(false); // 简体汉字自我介绍
		}
		System.out.println("======向台湾同胞自我介绍======");
		for(GourdBaby gb:gbs) {
			gb.selfIntroduce(true); // 繁体汉字自我介绍
		}
	}
	public static void bubbleSort(GourdBaby[] brothers) // 冒泡排序
	{
		int n = brothers.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
			{
				if(!brothers[j].cmp(brothers[j+1]))
					brothers[j].swap(brothers[j+1]);
			}
	}
	public static GourdBaby randomGourdBaby(){ // 随机生成一个葫芦娃
		String name = "";
		String sex = "";
		int age = 0;
		
		name = RandomStringUtils.randomAlphabetic(4); // 生成姓名
		
		if (RandomUtils.nextBoolean() == true) { // 生成性别
			sex = GourdBabySex.male;
		}
		else {
			sex = GourdBabySex.female;
		}
		age = RandomUtils.nextInt()%26+1; // 生成年龄
		
		GourdBaby gb = new GourdBaby(name,sex,age);
		return gb;
	}
}
