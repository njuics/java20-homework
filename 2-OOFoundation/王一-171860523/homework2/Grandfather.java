package homework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grandfather extends Human{
    Grandfather(String name, int index) {
        super(name, index);
    }

    /**
     * 爷爷指挥的排队
     * @throws Exception 函数调用顺序出错时，可能会导致乱序队列不存在或者其中的葫芦娃数量少于7个，则抛出异常
     */
    public void commandQueuing() throws Exception {
        if(CalabashBrother.calabashQueue == null || CalabashBrother.calabashQueue.size() < 7) {
            throw new Exception("葫芦娃们还没有来排队");
        }

        System.out.println("爷爷排队中…………");

        //创建一个正确队列用于存储正确的排队顺序
        CalabashBrother[] rightQueue = new CalabashBrother[7];
        for(CalabashBrother calaBro : CalabashBrother.calabashQueue) {
            //按照葫芦娃的编号进行排序
            rightQueue[calaBro.getIndex()] = calaBro;
        }

        //将正确的顺序复制给葫芦娃的队列
        CalabashBrother.calabashQueue.clear();
        CalabashBrother.calabashQueue.addAll(Arrays.asList(rightQueue));

        System.out.println("排队完成…………");
    }
}
