package cn.edu.nju.java.huluwa;

final public class Four_HuLuWa extends HuLuWa{      /* 四娃类，继承葫芦娃类 */
    
    public Four_HuLuWa() {      /* 初始构造函数 */
        this.name = "四娃";
        this.rank = 4;
    }

    @Override
    public void printout_name() {       /* 打印“四娃” */
        System.out.println("四娃");
    }
}
