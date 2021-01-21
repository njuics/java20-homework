package gourdcollection;

class GourdBabySex{ // 葫芦娃性别类
	public static String male = "male GourdBaby";
	public static String female = "female GourdBaby";
}

class GourdBaby implements Comparable<GourdBaby> {
	String name; // 名字
	String sex; // 性别
	public GourdBaby(String n,String s) {
		name = n;
		sex = s;
	}
	public GourdBaby() {
		name = "Aaaa";
		sex = GourdBabySex.male;
	}
	public void selfIntroduce() {
		System.out.println("I am "+name+", and I'm a "+sex);
	}
	public boolean isMale() {
		return sex.equals(GourdBabySex.male);
	}
	public int compareTo(GourdBaby other) { // 重写compareTo方法
		return this.name.compareTo(other.name); // 按照名字字典序正序排序
	}
}
