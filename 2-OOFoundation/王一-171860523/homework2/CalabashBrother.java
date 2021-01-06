package homework2;

import java.util.List;

public class CalabashBrother extends Human{

    public static List<CalabashBrother> calabashQueue;  //葫芦娃公用的排队队列

    CalabashBrother(String name, int index) {
        super(name, index);
    }

    /**
     * 代表葫芦娃较换位置的操作
     * @param calaBro 当前（this）葫芦娃要和指定的葫芦娃我（calaBro）交换位置
     */
    private void exchange(CalabashBrother calaBro) {
        int myPosition = calabashQueue.indexOf(this), hisPosition = calabashQueue.indexOf(calaBro);
        calabashQueue.set(myPosition, calaBro);
        calabashQueue.set(hisPosition, this);
    }

    /**
     * 葫芦娃不断判断自己与前后葫芦娃的编号大小，从而达成内部协作排队
     */
    public void compareExchange() {
        int nowPosition = calabashQueue.indexOf(this); //当前位置
        int left, right;        //左侧和右侧位置
        while(true) {
            left = nowPosition - 1;
            right = nowPosition + 1;

            if(left >= 0) { //判断左侧是否越界
                //询问前一个人的编号，前一个人编号比自己大，需要和前一个人交换位置
                if(index < calabashQueue.get(left).getIndex()) {
                    exchange(calabashQueue.get(left));
                    nowPosition = left;
                    continue; //交换过一次位置，直接进入下一轮判断
                }
            }
            if(right < 7) { //判断右侧是否越界
                //询问后一个人的编号，后一个人编号比自己小，需要和后一个人交换位置
                if(index > calabashQueue.get(right).getIndex()) {
                    exchange(calabashQueue.get(right));
                    nowPosition = right;
                    continue; //交换过一次位置，直接进入下一轮判断
                }
            }
            break; //既没有进行左侧较换，也没有进行右侧较换，说明位置不会发生变动了，结束循环
        }
    }
}
