package cn.edu.nju.wuyuxin;

public class BubbleSort implements BaseSort {
    public void orchestration(Grandpa grandpa,BoyQueue boyQueue){
        grandpa.orient(boyQueue);
    }
    public void choreography(BoyQueue boyQueue){
        for(int i=0;i<boyQueue.queue.length;i++){
            for(int j=0;j<boyQueue.queue.length-1;j++){
                if(boyQueue.queue[j].cmp(boyQueue.queue[j+1])){
                    boyQueue.queue[j].swap(boyQueue.queue[j+1]);
                }
            }
        }
    }
}