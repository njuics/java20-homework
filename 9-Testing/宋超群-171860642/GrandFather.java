import java.util.Collections;

class GrandFather<Boy extends CalabashBoy>{

    //爷爷发挥自己的特殊技能，帮助葫芦娃反复触发回复血量的被动技能
    void recover(Boy boy){
        while(boy.getHP() < 1000){
            boy.getWell();
        }
    }
    //排序
    void sort(BoysSequence sequence){
        Collections.sort(sequence.boysList);
    }
    //打乱次序
    void shuffle(BoysSequence sequence){
        Collections.shuffle(sequence.boysList);
    }

}
