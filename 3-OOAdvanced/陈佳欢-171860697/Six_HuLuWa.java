package cn.edu.nju.java.huluwa;

final public class Six_HuLuWa extends HuLuWa{       /* 六娃类，继承葫芦娃类 */
    
    public Six_HuLuWa() {       /* 初始构造函数 */
        this.name = "六娃";
        this.rank = 6;
    }

    @Override
    public void printout_name() {       /* 打印“六娃” */
        System.out.println("六娃");
    }
}
