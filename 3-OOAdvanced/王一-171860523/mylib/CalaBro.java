package homework3.mylib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalaBro extends Human{
    private static final List<Integer> random;
    static {
        random = new ArrayList<>();
        for(int i = 1; i <= 7; ++i)
            random.add(i);
        Collections.shuffle(random);              //打乱序列，打乱后的数字代表葫芦娃的随机位置
    }

    public CalaBro(int id) {
        super(id);
        position = random.get(id-1);
        humanQueue[position] = this;
    }

    /**
     * 代表葫芦娃较换位置的操作
     * @param pos 当前（this）葫芦娃要和指定位置的葫芦娃（pos）交换位置
     */
    private void exchange(int pos) {
        Human human = this;
        //交换位置
        humanQueue[this.position] = humanQueue[pos];
        humanQueue[pos] = human;
        //修改位置参数
        humanQueue[this.position].setPosition(this.position);
        this.position = pos;
    }

    /**
     * 葫芦娃不断判断自己与前后葫芦娃的编号大小，从而达成内部协作排队
     */
    public void compareExchange() {
        int left, right;        //左侧和右侧位置
        while(true) {
            left = position - 1;
            right = position + 1;

            if(left >= 0) { //判断左侧是否越界
                //询问前一个人的编号，前一个人编号比自己大，需要和前一个人交换位置
                if(id < humanQueue[left].getId()) {
                    exchange(left);
                    continue; //交换过一次位置，直接进入下一轮判断
                }
            }
            if(right < 7) { //判断右侧是否越界
                //询问后一个人的编号，后一个人编号比自己小，需要和后一个人交换位置
                if(id > humanQueue[right].getId()) {
                    exchange(right);
                    continue; //交换过一次位置，直接进入下一轮判断
                }
            }
            break; //既没有进行左侧较换，也没有进行右侧较换，说明位置不会发生变动了，结束循环
        }
    }
}
