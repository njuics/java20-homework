package cn.edu.nju.java.huluwa;

import java.util.List;

public class HuLuWa {       /* 葫芦娃类 */

    protected String name;      /* 葫芦娃的名字 */

    protected int rank;     /* 葫芦娃的排名 */

    public HuLuWa() {       /* 初始构造函数 */
        this.name = "";
        this.rank = 0;
    }

    public String tell_name() {     /* 返回自己的名字 */
        return this.name;
    }

    public int tell_rank() {        /* 返回自己的排名 */
        return this.rank;
    }

    public void printout_name() {       /* 输出自己的名字 */
        System.out.println("我是一个葫芦娃");
    }

    public void walk(List<HuLuWa> hulubrothers,int i) {        /* 根据自己的rank走到队列中正确的位置 */
        if((this.rank+i)==7)
            return;
        else {
            HuLuWa temp = hulubrothers.get(7-this.rank);
            hulubrothers.set(7-this.rank, this);
            temp.walk(hulubrothers, 7-this.rank);
        }
    }
}