package cn.edu.nju.wuyuxin;

public class SelectSort implements BaseSort {
    public void orchestration(Grandpa grandpa,BoyQueue boyQueue){
        grandpa.orient(boyQueue);
    }
    public void choreography(BoyQueue boyQueue){
        for(int i=boyQueue.queue.length-1;i>=0;i--){
            int temp_max_index=0;
            for(int j=0;j<=i;j++){
                if(boyQueue.queue[j].cmp(boyQueue.queue[temp_max_index])){
                    temp_max_index = j;
                }
            }
            boyQueue.queue[temp_max_index].swap(boyQueue.queue[i]);
        }
    }
}