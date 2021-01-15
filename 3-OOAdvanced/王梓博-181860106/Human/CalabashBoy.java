/*
 * @Author: zb-nju
 * @Date: 2020-09-26 14:33:07
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-09-27 11:22:31
 */
package Human;

public class CalabashBoy{
    private String name;
    private int ID;
    static private int num;
    static{
        num=0;
    }
    static public void reportNum(){
        System.out.println("一共有" + num + "个葫芦娃");
    }

    public CalabashBoy(String name,int ID){
        this.name = name;
        this.ID = ID;
        CalabashBoy.num++;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.name;
    }

    public void report(){
        System.out.println("我是"+name);
    }

    public boolean cmp(CalabashBoy bro){
        return this.ID>bro.ID;
    }

    public void swap(CalabashBoy bro){
        String tStr = bro.name;
        bro.name = this.name;
        this.name = tStr;
        int tInt = bro.ID;
        bro.ID = this.ID;
        this.ID = tInt;
    }
}
