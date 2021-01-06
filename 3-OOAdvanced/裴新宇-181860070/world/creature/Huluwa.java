package world.creature;

public class Huluwa extends Creature{
    private static int num = 0;
    private int order; //0-6
    static{
        System.out.println("开始创建葫芦娃对象...");
    }
    public Huluwa(int c){
        num++;
        order = c;
        switch(order){
            case 0:name = "老大";break;
            case 1:name = "老二";break;
            case 2:name = "老三";break;
            case 3:name = "老四";break;
            case 4:name = "老五";break;
            case 5:name = "老六";break;
            case 6:name = "老七";break;
        }
    }
    public int get_num(){
        return this.num;
    }
    public int get_order(){
        return this.order;
    }
    public String get_name(){
        return this.name;
    }
    public void set_order(int order){
        this.order = order;
    }
    public void set_name(String name){
        this.name = name;
    }
    public void count_off(){
        System.out.print(name+' ');
    }
    // 比较排名
    public boolean compare_order(Huluwa another){
        return this.order > another.get_order();
    }
    // 交换位置
    public void swap_order(Huluwa another){
        String name_t = another.get_name();
        another.set_name(this.name);
        this.name = name_t;
        int order_t = another.get_order();
        another.set_order(this.order);
        this.order = order_t;
    }
}