import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.util.Collections;
import java.util.function.Function;

class GrandFather<Boy extends CalabashBoy>{
    //爷爷特有的名单，可以根据葫芦娃的名字获得排行，也可以根据排行获取名字
    private BidiMap<Integer, String> boysSkill;

    GrandFather(){
        boysSkill = new TreeBidiMap();
        boysSkill.put(1, "红娃");
        boysSkill.put(2, "橙娃");
        boysSkill.put(3, "黄娃");
        boysSkill.put(4, "绿娃");
        boysSkill.put(5, "青娃");
        boysSkill.put(6, "蓝娃");
        boysSkill.put(7, "紫娃");
    }

    //使用google Guava的Ordering新改善的排序方法
    Ordering<Boy> byRank = new Ordering<Boy>() {
        public int compare(Boy boy1, Boy boy2) {
            return Ints.compare(boy1.getRank(), boy2.getRank());
        }
    };



    //爷爷发挥自己的特殊技能，帮助葫芦娃反复触发回复血量的被动技能
    void recover(Boy boy){
        while(boy.getHP() < 1000){
            boy.getWell();
        }
    }
    //排序
    void sort(BoysSequence sequence){
        //Collections.sort(sequence.boysList);

        //使用新方法进行排序
        Collections.sort(sequence.boysList, byRank);
    }
    //打乱次序
    void shuffle(BoysSequence sequence){
        Collections.shuffle(sequence.boysList);
    }

}
