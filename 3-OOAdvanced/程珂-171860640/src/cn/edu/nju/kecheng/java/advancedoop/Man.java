package cn.edu.nju.kecheng.java.advancedoop;

public class Man {
    protected String name;
    protected int loc;
    Man(String name,int loc){this.name=name;this.loc=loc;}
    public String getName(){ return this.name; }
    public int getLoc(){ return this.loc; }
    public void shoutSelf(){
        System.out.println("I am "+name+", I am in Location "+loc);}
}
