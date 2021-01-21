package hsp.java.nju;

public class Human {
    public static int total;
    static {
        total=0;
    }
    private String name;
    public Human(){
        name="NO NAME";
        total++;
    }
    public Human(String namegiven){
        name=namegiven;
        total++;
    }
    public String getName(){
        return name;
    }
    public int communicate(Hulu other)
    {
        System.out.println(name+":你好，我是一个人");
        System.out.println(other.getName()+":你好，我是一个葫芦娃");
        return 0;
    }

}
