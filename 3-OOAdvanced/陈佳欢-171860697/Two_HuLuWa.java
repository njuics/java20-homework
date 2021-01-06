package cn.edu.nju.java.huluwa;

final public class Two_HuLuWa extends HuLuWa {      /* 二娃类，继承葫芦娃类 */
    
    public Two_HuLuWa() {       /* 初始构造函数 */
        this.name = "二娃";
        this.rank = 2;
    }

    @Override
    public void printout_name() {       /* 打印“二娃” */
        System.out.println("二娃");
    }
}
