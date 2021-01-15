package gourdtest;

class GourdBaby implements Comparable<GourdBaby> {
	String name; // 名字
	String sex; // 性别
	int age; // 年龄
	public GourdBaby(String n,String s,int a) throws Exception {
		setName(n);
		setSex(s);
		setAge(a);
	}
	public GourdBaby() {
		name = "Peter";
		sex = GourdBabySex.male;
		age = 10;
	}
	public void setName(String n) throws Exception {
		if (n.isBlank() || n.isEmpty()) {
			throw new Exception("Name can't be empty or blank!");
		}
		else if(n.charAt(0) != n.toUpperCase().charAt(0)) {
			throw new Exception("Name's first letter can't be lower case!");
		}
		else {
			name = n;
		}
	}
	public void setSex(String s) throws Exception {
		if (s.equals(GourdBabySex.male)) {
			s = GourdBabySex.male;
		}
		else if (s.equals(GourdBabySex.female)) {
			s = GourdBabySex.female;
		}
		else {
			throw new Exception("Sex is not correct!");
		}
	}
	public void setAge(int a) throws Exception {
		if (a<0) {
			throw new Exception("Age can't be negative!");
		}
		else {
			age = a;
		}
	}
	public void selfIntroduce() { // 自我介绍
		System.out.println("Hi! I am "+name+", and I'm a "+sex+" GourdBaby");
	}
	public int compareTo(GourdBaby other) { // 重写compareTo方法
		return this.age - other.age; // 按照年龄从小到大排序
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
