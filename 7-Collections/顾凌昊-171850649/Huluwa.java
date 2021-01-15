package Collections;


public class Huluwa implements Comparable<Huluwa>{

    public String name;

    public boolean gender; //用布尔型变量表示性别，true为男性，false为女性

    public Huluwa(String n, boolean g){
        name = n;
        gender = g;
    }

    /**
     * 默认构造器会初始化一个随机姓名、性别的葫芦娃
     */
    public Huluwa(){

        this(Utils.getEnglishName(), Utils.getGender());
    }
    
    public void call(){

        System.out.println("我叫"+name+"，是"+((gender)?"男生" :"女生"));
    }


    /**
     * 实现Comparable接口中的方法，与另一个葫芦娃比较，返回姓名根据字典进行比较的结果
     * @param o
     * @return
     */
    @Override
    public int compareTo(Huluwa o) {
        return name.compareTo(o.name);
    }


}
