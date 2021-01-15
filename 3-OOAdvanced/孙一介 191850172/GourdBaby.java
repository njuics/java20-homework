public class GourdBaby extends Creature {
    static {
        System.out.println("葫芦娃对象创建完成");
    }
    private  int order;
    private static int count = 0;
    public GourdBaby(){
        this.order = count;
        switch (count){
            case 0:name = "老大";order = 1;break;
            case 1:name = "老二";order = 2;break;
            case 2:name = "老三";order = 3;break;
            case 3:name = "老四";order = 4;break;
            case 4:name = "老五";order = 5;break;
            case 5:name = "老六";order = 6;break;
            case 6:name = "老七";order = 7;break;
        }
        count++;
    }
    public void countoff(){
        System.out.println("我是"+this.name);
    }
    public void set_order(int order){
        this.order = order;
    }
    public int get_order(){
        return this.order;
    }
    public void set_name(String name){
        this.name = name;
    }
    public String get_name(){
        return this.name;
    }
    public boolean compare_order(GourdBaby another){
        return this.order>another.order;
    }
    public void gourdbabysort(GourdBaby another){
        String temple_name = another.name;
        another.name = this.name;
        this.name = temple_name;
        int temple_order = another.order;
        another.order = this.order;
        this.order = temple_order;
    }
}
