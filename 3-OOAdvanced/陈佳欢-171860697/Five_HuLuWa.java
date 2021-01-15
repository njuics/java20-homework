package cn.edu.nju.java.huluwa;

final public class Five_HuLuWa extends HuLuWa {     /* 五娃类，继承葫芦娃类 */
    
    public Five_HuLuWa() {      /* 初始构造函数 */
        this.name = "五娃";
        this.rank = 5;
    }

    @Override
    public void printout_name() {       /* 打印“五娃” */
        System.out.println("五娃");
    }
}
