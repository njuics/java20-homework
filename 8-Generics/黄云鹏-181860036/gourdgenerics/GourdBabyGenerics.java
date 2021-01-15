package gourdrgenerics;

import java.util.Random;

public class GourdBabyGenerics {
	public static void main(String args[]) {
		GourdBaby gb = new GourdBaby("Tom","male",15); // 自己
		gb.setFather(new GourdBaby("Jack","male",41)); // 父亲
		gb.setMother(new GourdBaby("Mary","female",38)); // 母亲
		for (int i=0;i< new Random().nextInt(10)+1;i++) { // 兄弟姐妹
			gb.appendSibling(randomGourdBaby());
		}
		System.out.println("============First, my self-introduction==========");
		gb.selfIntroduce();
		System.out.println("============Then, my Dad's self-introduction==========");
		gb.getFather().selfIntroduce();
		System.out.println("============Following my Mom's self-introduction==========");
		gb.getMother().selfIntroduce();
		System.out.println("============I have "+ gb.numOfSiblings()+ " siblings and here're their self-introductions in age order==========");
		gb.introduceSiblingsInAgeOrder();
	}
	public static GourdBaby randomGourdBaby(){ // 随机生成一个葫芦娃
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
}
