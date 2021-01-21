package cn.edu.nju.java.huluwa;

import java.util.List;

public class GrandPa {
    public GrandPa(){}      /*默认构造函数*/

    private void swap(List<HuLuWa> hulubrothers,int a,int b) {       /* 交换a,b两个葫芦兄弟的位置 */
        if(a==b)
            return;
        else {
            HuLuWa temp_huluwa = hulubrothers.get(b);
            hulubrothers.set(b, hulubrothers.get(a));
            hulubrothers.set(a, temp_huluwa);
            int rank = hulubrothers.get(a).tell_rank();
            swap(hulubrothers, a, rank-1);
        }
    }

    public void orchestration(List<HuLuWa> hulubrothers) {     /* 对hulubrothers队列进行指挥排序 */
        for(int i=0;i<hulubrothers.size();i++) {
            int rank = hulubrothers.get(i).tell_rank();
            swap(hulubrothers,i,rank-1);
        }
    }
    
}
