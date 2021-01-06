package gourdtest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class GourdTest {
	@Test(expected = Exception.class)
	public void testSetNameEmpty() throws Exception{ // 测试葫芦娃空名异常
		new GourdBaby("","male",10);
		fail("Name's empty but without corresponding Exception!");
	}
	@Test(expected = Exception.class)
	public void testSetNameLowercase() throws Exception { // 测试葫芦娃首字母小写异常
		new GourdBaby("peter","female",10);
		fail("Name's first letter is lower case but without corresponding Exception!");
	}
	@Test(expected = Exception.class)
	public void testSetSexNotExist() throws Exception { // 测试性别不存在异常
		new GourdBaby("Peter","sex",10);
		fail("Sex doesn't exist but without corresponding Exception!");
	}
	@Test(expected = Exception.class)
	public void testSetAgeNegative() throws Exception { // 测试年龄为负数异常
		new GourdBaby("Peter","male",-2);
		fail("Age is negative but without corresponding Exception!");
	}
	@Test(timeout = 1000)
	public void testSort()throws Exception{ // 测试排序算法耗时
		GourdBaby[] gbs = new GourdBaby[10000];
		for(int i=0;i<10000;i++) {
			GourdBaby gb = randomGourdBaby();
			gbs[i] = gb;
		}
		bubbleSort(gbs);
	}
	public GourdBaby randomGourdBaby() throws Exception{ // 随机生成一个葫芦娃
		String name = "";
		String sex = "";
		int age = 0;
		Random r = new Random();
		for(int i=0;i<4;i++) // 生成姓名
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
		if (r.nextBoolean() == true) { // 生成性别
			sex = "male";
		}
		else {
			sex = "female";
		}
		age = r.nextInt(25)+1;
		
		GourdBaby gb = new GourdBaby(name,sex,age);
		return gb;
	}
	public void bubbleSort(GourdBaby[] brothers) // 冒泡排序
	{
		int n = brothers.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
			{
				if(!brothers[j].cmp(brothers[j+1]))
					brothers[j].swap(brothers[j+1]);
			}
	}
}
