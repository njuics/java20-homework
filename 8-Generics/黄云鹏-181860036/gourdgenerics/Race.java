package gourdrgenerics;

import java.util.ArrayList;

class Race <T extends Race<T>> implements Comparable<T> {  // 抽象种族类，属于一个种族后就只能和同族人打交道
	String name; // 姓名
	String sex; // 性别
	int age; // 年龄
	T myself; 
	T father; // 父亲
	T mother; // 母亲
	ArrayList<T> siblings; // 兄弟姐妹
	
	Race(String n){
		name = n;
		setSex("male");
		setAge(0);
		siblings = new ArrayList<T>();
	}
	Race(String n,String s, int a){
		name = n;
		setSex(s);
		setAge(a);
		siblings = new ArrayList<T>();
	}
	public void setSex(String s) { //设置性别
		if (s.equals("male")) {
			sex = s;
		}
		else if (s.equals("female")) {
			sex = s;
		}
		else {
			sex = "male";
		}
	}
	public void setAge(int a) { // 设置年龄
		if (a<0) {
			a = 0;
		}
		age = a;
	}
	public void setFather(T f) { // 设置父亲
		father = f;
	}
	public T getFather() { // 获取父亲
		return father;
	}
	public void setMother(T m) { // 设置母亲
		mother = m;
	}
	public T getMother() { // 获取母亲
		return mother;
	}
	public void appendSibling(T e) { // 添加兄弟姐妹
		siblings.add(e);
	}
	public int numOfSiblings() { // 多少个兄弟姐妹
		return siblings.size();
	}
	public T getSibling(int idx) throws IndexOutOfBoundsException{ // 获取某兄弟姐妹
		return siblings.get(idx);
	}
	public void selfIntroduce(String race) {
		System.out.println("Hi, I'am "+name+", a "+age+" year-old "+sex+" "+race+"!");
	}
	public int compareTo(T other) { // 同族人之间的年龄比较
		return this.age - other.age;
	}
}
