package cn.edu.nju.java.huluwa;

final public class Seven_HuLuWa extends HuLuWa{     /* 七娃类，继承葫芦娃类 */

    public Seven_HuLuWa() {     /* 初始构造函数 */
        this.name = "七娃";
        this.rank = 7;
    }

    @Override
    public void printout_name() {       /* 打印“七娃” */
        System.out.println("七娃");
    }
}
