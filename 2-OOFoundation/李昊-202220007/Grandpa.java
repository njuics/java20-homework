import org.junit.Test;

import java.util.*;

/**
 * @author q
 * @create 2020-09-19 16:28
 */

//爷爷类
public class Grandpa {
    //爷爷有一群葫芦娃，葫芦娃们是乱序的
    public List<HuLuWa> huLuWas;

    public Grandpa(List<HuLuWa> huLuWas) {
        this.huLuWas = huLuWas;
    }


    //爷爷能将葫芦娃排序
    public void sortHuLuWa() {
        //爷爷将葫芦娃按照他们的位次排序
        Collections.sort(huLuWas, new Comparator<HuLuWa>() {
            @Override
            public int compare(HuLuWa o1, HuLuWa o2) {
                return o1.index- o2.index;
            }
        });
    }
}
