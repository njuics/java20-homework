package app;

import java.lang.Comparable;



class Calabash implements Comparable<Calabash>{
    public String name; // 名字
    public String sex; // 性别
    private int age;//年纪

    public Calabash() {
		name = "noname";
		sex = "nosex";
    }
    
	public Calabash(String n,String s) {
		name = n;
		sex = s;
    }
    
    public void rename(Calabash x){
        this.name=x.name;
        this.sex=x.sex;
    }

    public void selfIntroduce() {
		System.out.println("I am "+name+", and I'm a "+sex);
    }

    public String get_name(){
        return this.name;
    }

    public String get_sex(){
        return this.sex;
    }

    public int get_age(){
        return this.age;
    }


    @Override
    public int compareTo(Calabash cal) {
        return this.name.compareTo(cal.name); // 按照名字字典序正序排序
    }

}