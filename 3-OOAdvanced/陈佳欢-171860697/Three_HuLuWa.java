package cn.edu.nju.java.huluwa;

final public class Three_HuLuWa extends HuLuWa{     /* 三娃类，继承葫芦娃类 */
    
    public Three_HuLuWa() {     /* 初始构造函数 */
        this.name = "三娃";
        this.rank = 3;
    }

    @Override
    public void printout_name() {       /* 打印“三娃” */
        System.out.println("三娃");
    }
}
