package gourdmaven;

import com.github.houbb.opencc4j.util.ZhConverterUtil;

class GourdBabySex{ // 葫芦娃性别类
	public static String male = "男葫芦娃";
	public static String female = "女葫芦娃";
}

class GourdBaby implements Comparable<GourdBaby> {
	String name; // 名字
	String sex; // 性别
	int age; // 年龄
	public GourdBaby(String n,String s,int a) {
		name = n;
		sex = s;
		age = a;
	}
	public GourdBaby() {
		name = "Aaaa";
		sex = GourdBabySex.male;
		age = 0;
	}
	public void selfIntroduce(boolean iftraditional) { // 根据参数，选择用简体汉字/繁体汉字自我介绍
		String str1 = "大家好，我是";
		String str2 = name;
		String str3 = "，是一个";
		String str4 = sex;
		String str5 = "，今年";
		String str6 = "岁";
		if(iftraditional){ // 转换为繁体
			str1 = ZhConverterUtil.toTraditional(str1);
			str2 = ZhConverterUtil.toTraditional(str2);
			str3 = ZhConverterUtil.toTraditional(str3);
			str4 = ZhConverterUtil.toTraditional(str4);
			str5 = ZhConverterUtil.toTraditional(str5);
			str6 = ZhConverterUtil.toTraditional(str6);
		}
		else { //转换为简体
			str1 = ZhConverterUtil.toSimple(str1);
			str2 = ZhConverterUtil.toSimple(str2);
			str3 = ZhConverterUtil.toSimple(str3);
			str4 = ZhConverterUtil.toSimple(str4);
			str5 = ZhConverterUtil.toSimple(str5);
			str6 = ZhConverterUtil.toSimple(str6);
		}
		System.out.println(str1+str2+str3+str4+str5+age+str6);
	}
	public boolean isMale() {
		return sex.equals(GourdBabySex.male);
	}
	public int compareTo(GourdBaby other) { // 重写compareTo方法
		return this.age-other.age; // 按照名字字典序正序排序
	}
	// 比较方法
	public boolean cmp(GourdBaby other)
		{
			if(this.age<other.age)
				return true;
			return false;
		}
	// 交换方法
	public void swap(GourdBaby other)
	{
		String tmp_name = this.name;
		String tmp_sex = this.sex;
		int tmp_age = this.age;
		this.name = other.name;
		this.sex = other.sex;
		this.age = other.age;
		other.name = tmp_name;
		other.sex = tmp_sex;
		other.age = tmp_age;
	}		
}