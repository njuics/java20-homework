package cn.edu.nju.java.huluwa;

final public class One_HuLuWa extends HuLuWa {      /* 大娃类，继承葫芦娃类 */
    
    public One_HuLuWa() {       /* 初始构造函数 */
        this.name = "大娃";
        this.rank = 1;
    }

    @Override
    public void printout_name() {        /* 打印“大娃” */
        System.out.println("大娃");
    }
}